package fanout;

import com.rabbitmq.client.*;
import com.zhanghui.vue.util.RabbitMqUtil;

import java.io.IOException;

public class consumer1 {
    public static void main(String[] args) throws IOException {
        //获取连接对象
        Connection connection = RabbitMqUtil.getConnection();
        //拿到通道
        Channel channel = connection.createChannel();
        //通道绑定交换机 参数： 交换机名字  类型
        channel.exchangeDeclare("logs", "fanout");
        //获取临时队列名称  由交换机临时创建的
        String queueName = channel.queueDeclare().getQueue();
        //绑定交换机和队列参数：队列名称  交换机名称  标识
        channel.queueBind(queueName, "logs", "");
        //消费消息
        channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body);
                System.out.println("消费者1" + message);
            }
        });
    }
}

