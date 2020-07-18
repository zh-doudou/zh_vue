package topic;

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
        // 路由名字    订阅模型
        channel.exchangeDeclare("logs_topic", "topic");
        //生成动态路由key
        String routingKey = "user.save";
        channel.basicPublish("logs_topic", routingKey,
                null,
                ("这是topic动态路由模型 routingKey:" + routingKey).getBytes());
        RabbitMqUtil.closeConnectionChannel(channel, connection);
    }
}
