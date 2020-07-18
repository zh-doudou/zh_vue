package com.zhanghui.vue.springboot_rabbitmqconsumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * 消费者监听接收哪个队列的消息
 * 没有队列声明队列
 * queuesToDeclare = @Queue("hello")
 *
 * @author 张辉
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("hello"))
public class HelloWordConsumer {
    /**
     * 存在了消费者 才能发送消息
     */
    @RabbitHandler
    public void receive1(String message) {
        System.out.println("message = " + message);
    }
}
