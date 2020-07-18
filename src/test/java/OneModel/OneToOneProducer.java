package OneModel;

import com.rabbitmq.client.*;
import com.zhanghui.vue.util.RabbitMqUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

//生产者和消费者   1一对1
public class OneToOneProducer {
    //生产者
    @Test
    public void OneToOneProducer1() throws IOException, TimeoutException {
        //根据连接创建通道
        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();
        /**
         * 通道绑定队列声明
         * 参数1：队列的名称 如果没有则自动创建
         * 参数2：是否参数持久化
         * 参数3：是否独占队列
         * 参数4：消费完毕是否自动删除
         * 参数5：其他属性
         * * */
        channel.queueDeclare("javaOneToOne", false, false, false, null);
        /**
         * 生产者消息的发布
         *参数1：交换机的名字，队列的名字，由于咱们是1对1所以不需要设置交换机
         *参数2：队列名称
         *参数3：可以通过BasicProperties设置消息的一些属性
         * AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
         *                     .deliveryMode(2) // 传送方式
         *                     .contentEncoding("UTF-8") // 编码方式
         *                     .expiration("10000") // 过期时间
         *                     .headers(headers) //自定义属性
         *                     .build()
         *参数4：将消息转换为bet数组
         * */
        channel.basicPublish("", "javaOneToOne", null, "hello-192-zh".getBytes());
        //关闭连接
        channel.close();
        connection.close();
    }

    //消费者持续监听   junit不支持多线程
    public static void main(String[] args) throws IOException, TimeoutException {

        //根据连接创建通道
        Connection connection = RabbitMqUtil.getConnection();
        //根据连接创建通道
        Channel channel = connection.createChannel();

        channel.queueDeclare("javaOneToOne", false, false, false, null);
        /**消费者消费消息
         * 参数1：消费哪个队列
         * 参数2：开启消息的自动确认机制
         * */
        channel.basicConsume("javaOneToOne", true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body);
                System.out.println("消费者,消费信息" + message);
            }
        });
    }
}
