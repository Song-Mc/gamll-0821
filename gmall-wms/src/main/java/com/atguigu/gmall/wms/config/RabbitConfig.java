package com.atguigu.gmall.wms.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : SongMc
 * @date : 2021/3/4 9:45
 * className : RabbieConfig
 * package: com.atguigu.gmallorder.config
 * version : 1.0
 * Description
 */
@Slf4j
@Configuration
public class RabbitConfig {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void init(){
        this.rabbitTemplate.setConfirmCallback((correlationData,ack,cause) -> {
            if (!ack){
                log.error("消息没有成功的到达交换机，失败原因：{}", cause);
            }
        });
        this.rabbitTemplate.setReturnCallback((message,replyCode,replyText,exchange,routingKey) -> {
            log.error("消息没有到达队列。交换机：{}，路由键：{}，消息内容：{}", exchange,routingKey,new String(message.getBody()));
        });
    }

    /**
     * 定义业务交换机：ORDER_EXCHANGE
     */

    /**
     * 定义延时队列：STOCK_TTL_QUEUE
     * 配置参数：
     *  x-message-ttl：90000
     *  x-dead-letter-exchange: ORDER_EXCHANGE
     *  x-dead-letter-routing-key：stock.dead
     */
    @Bean
    public Queue ttlQueue(){
        return QueueBuilder.durable("STOCK_TTL_QUEUE")
                .withArgument("x-message-ttl", 100000)
                .withArgument("x-dead-letter-exchange", "ORDER_EXCHANGE")
                .withArgument("x-dead-letter-routing-key", "order.disable")
                .build();
    }

    /**
     * 延时队列绑定到业务交换机：stock.ttl
     */
    @Bean
    public Binding ttlBinding(){
        return new Binding("STOCK_TTL_QUEUE", Binding.DestinationType.QUEUE, "ORDER_EXCHANGE", "stock.ttl", null);
    }

    /**
     * 死信交换机：ORDER_EXCHANGE
     */

    /**
     * 死信队列：STOCK_DEAD_QUEUE
     */

    /**
     * 死信队列绑定到死信交换机：stock.dead
     */
    @Bean
    public Binding deadBinding(){
        return new Binding("STOCK_UNLOCK_QUEUE", Binding.DestinationType.QUEUE, "ORDER_EXCHANGE", "order.disable", null);
    }

}
