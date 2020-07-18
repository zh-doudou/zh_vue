package com.zhanghui.vue.springboot_rabbitmqconsumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class worlConsumer {
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receivel1(String message) {
        System.out.println("message1 = " + message);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receivel2(String message) {
        System.out.println("message2 = " + message);
    }
}
