package workQuene;

import com.rabbitmq.client.*;
import com.zhanghui.vue.util.RabbitMqUtil;

import java.io.IOException;

public class consumer1 {
    public static void main(String[] args) throws IOException {
        //根据连接创建通道
        Connection connection = RabbitMqUtil.getConnection();
        //根据连接创建通道
        Channel channel = connection.createChannel();
        channel.queueDeclare("hh", true, false, true, null);
        /**消费者消费消息
         * 参数1：消费哪个队列
         * 参数2：开启消息的自动确认机制-->打开的话会出现轮巡机制,不能体现能者多劳！
         *        关闭之后  手动向rabbitmq确认消息消费
         *
         * */
        channel.basicQos(1);//一次只接受一条未确认的消息
        channel.basicConsume("hh", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body);
                System.out.println("消费者1,消费信息" + message);
                channel.basicAck(envelope.getDeliveryTag(), false);//手动确认消息
            }
        });
    }
}

