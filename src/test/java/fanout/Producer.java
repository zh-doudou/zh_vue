package fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zhanghui.vue.util.RabbitMqUtil;
import org.junit.Test;

import java.io.IOException;

public class Producer {
    @Test
    public void sendMessage() throws IOException {
        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();
        /**通过管道指定交换机
         * 参数1：交换机的名称
         * 参数2：指定交换机的类型   fanout：广播类型
         * */
        channel.exchangeDeclare("logs", "fanout");
        //发送消息 参数： 交换机名字  标识  是否持久化
        channel.basicPublish("logs", "", null, "广播模式".getBytes());
        //关闭连接
        RabbitMqUtil.closeConnectionChannel(channel, connection);
    }
}
