package com.zhanghui.vue.springboot_rabbitmqconsumer;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 张辉
 */
@Component
public class FanoutConsumer {
    //bindings 队列和交换机的绑定
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //创建临时队列
                    exchange = @Exchange(value = "logSs", type = "fanout")//绑定的交换机
            )
    })


    public void receievl1(String message) {
        System.out.println("fanout消费者1---message = " + message);

    }


    //bindings 队列和交换机的绑定
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //创建临时队列
                    exchange = @Exchange(value = "logSs", type = "fanout")//绑定的交换机
            )
    })
    public void receievl2(String message) {
        System.out.println("fanout消费者2-----message = " + message);

    }

}
