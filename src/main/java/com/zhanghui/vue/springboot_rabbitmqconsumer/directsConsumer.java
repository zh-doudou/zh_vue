package com.zhanghui.vue.springboot_rabbitmqconsumer;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class directsConsumer {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    //自定义交换机的名字和类型
                    exchange = @Exchange(
                            value = "logSs_directs",
                            type = "direct"
                    ),
                    //指定路由key的信息
                    key = {"info", "error"}
            )
    })
    public void receivel(String message) {
        System.out.println("消费者1接收到的信息 = " + message);
    }


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    //自定义交换机的名字和类型
                    exchange = @Exchange(
                            value = "logSs_directs",
                            type = "direct"
                    ),
                    //指定路由key的信息
                    key = {"error"}
            )
    })
    public void receivel2(String message) {
        System.out.println("消费者2接收到的信息 = " + message);
    }
}
