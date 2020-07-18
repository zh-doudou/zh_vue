package workQuene;

import com.rabbitmq.client.*;
import com.zhanghui.vue.util.RabbitMqUtil;

import java.io.IOException;

public class consumer2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("hh", true, false, true, null);
        /**消费者消费消息
         * 参数1：消费哪个队列
         * 参数2：开启消息的自动确认机制
         * */
        channel.basicQos(1);//每一次只消费一条消息
        channel.basicConsume("hh", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    //模拟消费者2性能不好  2个分配情况
                    Thread.sleep(1000);
                    String message = new String(body);
                    System.out.println("消费者2,消费信息" + message);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /**确认消息消费在删除消息
                 * 参数一：确认队列中哪个具体消息
                 * 参数2：是否开启多个消息同时确认
                 * */
                channel.basicAck(envelope.getDeliveryTag(), false);//手动确认消息
            }
        });

    }

}
