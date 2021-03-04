package com.atguigu.gmall.payment.controller;

import com.alipay.api.AlipayApiException;
import com.atguigu.gmall.common.bean.ResponseVo;
import com.atguigu.gmall.common.exception.OrderException;
import com.atguigu.gmall.oms.entity.OrderEntity;
import com.atguigu.gmall.payment.config.AlipayTemplate;
import com.atguigu.gmall.payment.interceptor.LoginInterceptor;
import com.atguigu.gmall.payment.pojo.PaymentInfoEntity;
import com.atguigu.gmall.payment.pojo.UserInfo;
import com.atguigu.gmall.payment.service.PaymentService;
import com.atguigu.gmall.payment.pojo.PayAsyncVo;
import com.atguigu.gmall.payment.pojo.PayVo;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RCountDownLatch;
import org.redisson.api.RedissonClient;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author : SongMc
 * @date : 2021/3/4 15:12
 * className : PaymentController
 * package: com.atguigu.gmallpayment.controller
 * version : 1.0
 * Description
 */
@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private AlipayTemplate alipayTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("pay.html")
    public String toPay(@RequestParam("orderToken")String orderToken, Model model){
        OrderEntity orderEntity = this.paymentService.queryOrderByToken(orderToken);
        if (orderEntity == null) {
            throw new OrderException("要支付的订单不存在。");
        }
        // 判断订单是否属于该用户
        UserInfo userInfo = LoginInterceptor.getUserInfo();
        if (userInfo.getUserId() != orderEntity.getUserId()){
            throw new OrderException("该订单不属于您，或者您没有支付权限");
        }
        // 判断订单是否属于待付款状态
        if (orderEntity.getStatus() != 0){
            throw new OrderException("该订单无法支付，请注意您的订单状态");
        }
        model.addAttribute("orderEntity", orderEntity);
        return "pay";
    }

    @GetMapping("alipay.html")
    @ResponseBody
    public String alipay(@RequestParam("orderToken") String orderToken) throws AlipayApiException {
        OrderEntity orderEntity = this.paymentService.queryOrderByToken(orderToken);
        if (orderEntity == null) {
            throw new OrderException("要支付的订单不存在。");
        }
        // 判断订单是否属于该用户
        UserInfo userInfo = LoginInterceptor.getUserInfo();
        if (userInfo.getUserId() != orderEntity.getUserId()){
            throw new OrderException("该订单不属于您，或者您没有支付权限");
        }
        // 判断订单是否属于待付款状态
        if (orderEntity.getStatus() != 0){
            throw new OrderException("该订单无法支付，请注意您的订单状态");
        }

        // 调用阿里的支付接口，跳转到支付页面
        PayVo payVo = new PayVo();
        payVo.setOut_trade_no(orderToken);
        // 注意：一定不要使用实际价格，建议直接使用0.01
        payVo.setTotal_amount("0.01");
        payVo.setSubject("谷粒商城订单支付平台");
        // 生成对账记录
        String payId = this.paymentService.savePayment(orderEntity);
        payVo.setPassback_params(payId);
        String form = this.alipayTemplate.pay(payVo);

        return form;
    }

    @GetMapping("pay/success")
    public String paysuccess(PayAsyncVo payAsyncVo){

        return "paysuccess";
    }

    @PostMapping("pay/ok")
    @ResponseBody
    public Object payOk(PayAsyncVo payAsyncVo){

        // 1.验签
        Boolean flag = this.alipayTemplate.checkSignature(payAsyncVo);
        if (!flag){
            return "failure";
        }

        // 2.校验业务参数：app_id,out_trade_no,total_amount
        String app_id = payAsyncVo.getApp_id();
        String out_trade_no = payAsyncVo.getOut_trade_no();
        String total_amount = payAsyncVo.getTotal_amount();
        // 对账记录的id
        String payId = payAsyncVo.getPassback_params();
        PaymentInfoEntity paymentInfoEntity = this.paymentService.queryPaymentById(payId);
        if (!StringUtils.equals(app_id,this.alipayTemplate.getApp_id())
                || new BigDecimal(total_amount).compareTo(paymentInfoEntity.getTotalAmount()) != 0
                || !StringUtils.equals(out_trade_no,paymentInfoEntity.getOutTradeNo())
        ){
            return "failure";
        }

        // 3.校验支付状态
        String trade_status = payAsyncVo.getTrade_status();
        if (!StringUtils.equals("TRADE_SUCCESS", trade_status)){
            return "failure";
        }

        // 4.更新支付对账表中状态
        if (this.paymentService.updatePaymentInfo(payAsyncVo,payId) == 0){
            return "failure";
        }

        // 5.发送消息给订单(oms 发送消息给wms 减库存)
        this.rabbitTemplate.convertAndSend("ORDER_EXCHANGE","order.success",out_trade_no);

        // 5.响应消息给支付宝
        return "success";
    }

    @GetMapping("order/{orderToken}")
    public ResponseVo<OrderEntity> queryOrderByToken(@PathVariable("orderToken")String orderToken) throws InterruptedException {

        RCountDownLatch countDownLatch = this.redissonClient.getCountDownLatch("seckill:countdown:" + orderToken);
        countDownLatch.await();

        UserInfo userInfo = LoginInterceptor.getUserInfo();
        OrderEntity orderEntity = this.paymentService.queryOrderByToken(orderToken);
        if (orderEntity.getUserId() == userInfo.getUserId()){
            return ResponseVo.ok(orderEntity);
        }
        return ResponseVo.ok();
    }

}
