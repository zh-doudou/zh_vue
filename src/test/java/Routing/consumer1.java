package Routing;

import com.rabbitmq.client.*;
import com.zhanghui.vue.util.RabbitMqUtil;

import java.io.IOException;

public class consumer1 {
    public static void main(String[] args) throws IOException {
        //根据连接创建通道
        Connection connection = RabbitMqUtil.getConnection();
        //根据连接创建通道
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("logs_direct", "direct");
        //获取队列的名字
        String queueName = channel.queueDeclare().getQueue();
        //指定绑定的队列和交换机  队列名称  交换机名称  标识路由key
        channel.queueBind(queueName, "logs_direct", "error");
        //消费者获取消息
        channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String s = new String(body);
                System.out.println("消费者1拿到结果为：" + s);
            }
        });
    }

}

