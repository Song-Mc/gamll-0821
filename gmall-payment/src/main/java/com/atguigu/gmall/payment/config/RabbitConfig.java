package com.atguigu.gmall.payment.config;

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


}
