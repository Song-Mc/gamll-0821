package com.atguigu.gmall.cart.listener;

import com.alibaba.fastjson.JSON;
import com.atguigu.gmall.cart.feign.GmallPmsClient;
import com.atguigu.gmall.common.bean.ResponseVo;
import com.atguigu.gmall.pms.entity.SkuEntity;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author : SongMc
 * @date : 2021/2/25 14:57
 * className : CartListener
 * package: com.atguigu.gmall.cart.listener
 * version : 1.0
 * Description
 */
@Component
public class CartListener {

    @Autowired
    private GmallPmsClient pmsClient;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String KEY_PREFIX = "cart:info:";
    private static final String PRICE_PREFIX = "cart:price:";

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "CART_PRICE_QUEUE",durable = "true"),
            exchange = @Exchange(value = "PMS_ITEM_EXCHANGE",ignoreDeclarationExceptions = "true",type = ExchangeTypes.TOPIC),
            key = {"item.update"}
    ))
    public void listener(Long spuId, Channel channel, Message message) throws IOException {

        if (spuId == null){
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            return;
        }
        ResponseVo<List<SkuEntity>> listResponseVo = this.pmsClient.querySkusBySpuId(spuId);
        // 如果spu下sku为空，直接确认消息并结束
        List<SkuEntity> skuEntities = listResponseVo.getData();
        if (CollectionUtils.isEmpty(skuEntities)){
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            return;
        }

        skuEntities.forEach(skuEntity -> {
            if (this.redisTemplate.hasKey(PRICE_PREFIX + skuEntity.getId())) {
                this.redisTemplate.opsForValue().set(PRICE_PREFIX + skuEntity.getId(), skuEntity.getPrice().toString());
            }
        });

        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);

    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "CART_DELETE_QUEUE",durable = "true"),
            exchange = @Exchange(value = "ORDER_EXCHANGE",ignoreDeclarationExceptions = "true",type = ExchangeTypes.TOPIC),
            key = {"cart.delete"}
    ))
    public void deleteCart(HashMap<Object, Object> map, Channel channel, Message message) throws IOException {

        if (CollectionUtils.isEmpty(map)){
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            return;
        }

        // 获取用户id和skuIds
        String userId = map.get("userId").toString();
        List<String> skuIds = JSON.parseArray(map.get("skuIds").toString(), String.class);

        BoundHashOperations<String, Object, Object> hashOps = this.redisTemplate.boundHashOps(KEY_PREFIX + userId);
        hashOps.delete(skuIds.toArray());

        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);

    }

}
