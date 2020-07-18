package Routing;

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
        //通过通道绑定声明交换机      名字       交换机类型:路由模式
        channel.exchangeDeclare("logs_direct", "direct");
        //String routingKey = "error";
        //String routingKey = "warning";
        String routingKey = "info";
        //参数：交换机名称   路由key
        channel.basicPublish(
                "logs_direct",
                routingKey,
                null,
                ("这是直连订阅类型发布的消息:(" + routingKey + ")").getBytes());
        RabbitMqUtil.closeConnectionChannel(channel, connection);
    }

}
