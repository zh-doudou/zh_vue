package workQuene;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zhanghui.vue.util.RabbitMqUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    /**
     * 获取连接
     */
    @Test
    public void sendMessage() throws IOException, TimeoutException {
        Connection connection = RabbitMqUtil.getConnection();
        //获得管道
        Channel channel = connection.createChannel();
        /**
         * 队列绑定
         * 参数1：绑定队列的名称 如果没有自动创建
         * 参数2：是否持久化
         * 参数3：是否独占队列
         * 参数4：消费完毕自动删除此队列
         *
         * */
        channel.queueDeclare("hh", true, false, true, null);
        /**
         * 消息的发布
         * 交换机的名字，队列的名字，由于咱们是1对一所以不需要设置交换机
         * 队列名称
         * */
        for (int i = 1; i < 51; i++) {
            channel.basicPublish("", "hh", null, ("这是发布的第" + i + "个消息").getBytes());
        }
        channel.close();
        connection.close();

    }
}
