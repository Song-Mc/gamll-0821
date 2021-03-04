package com.atguigu.order.controller;

import com.atguigu.gmall.common.bean.ResponseVo;
import com.atguigu.gmall.oms.vo.OrderSubmitVo;
import com.atguigu.order.pojo.OrderConfirmVo;
import com.atguigu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : SongMc
 * @date : 2021/2/26 22:11
 * className : OrderController
 * package: com.atguigu.gmallorder.controller
 * version : 1.0
 * Description
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("confirm")
    public String confirm(Model model) {

        OrderConfirmVo confirmVo = this.orderService.confirm();
        model.addAttribute("confirmVo", confirmVo);
        return "trade";
    }

    @PostMapping("submit")
    @ResponseBody
    public ResponseVo<String> submit(@RequestBody OrderSubmitVo submitVo){
        this.orderService.submit(submitVo);
        return ResponseVo.ok(submitVo.getOrderToken());
    }
}

