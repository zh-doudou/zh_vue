package topic;

import com.rabbitmq.client.*;
import com.zhanghui.vue.util.RabbitMqUtil;

import java.io.IOException;

public class Coimsumer1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();
        // 路由名字    订阅模型
        channel.exchangeDeclare("logs_topic", "topic");
        //获取动态队列名称
        String queueName = channel.queueDeclare().getQueue();
        //绑定对立和交换机  队列名称   交换机名字      动态路由key通配符
        channel.queueBind(queueName, "logs_topic", "user.*");
        //消费消息
        channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String s = new String(body);
                System.out.println("消费者1拿到消息：" + s);
            }
        });
    }
}
