package springboot_rabbitmqproducer;

import com.zhanghui.vue.VueApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = VueApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class TestProducer {
    //rabbitTemplate 简化操作
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testHelloWorld() {
        //转化发送  队列名称   消息  //创建队列不在生产者这边
        rabbitTemplate.convertAndSend("hello", "sdasadsadsada");
    }

    //轮巡模式默认在Spring AMQP实现中Work这种方式就是公平调度,如果需要实现能者多劳需要额外配置
    @Test
    public void testWork() {
        for (int i = 0; i < 50; i++) {
            rabbitTemplate.convertAndSend("work", "sdasadsadsada----" + i);
        }

    }

    //fanout广播模式
    @Test
    public void testFanout() {
        // 生产者将日志 绑定到交换机  通过交换机 创建临时队列  消费者获取到
        rabbitTemplate.convertAndSend("logSs", "", "fanout发布的消息");
    }

    //路由模式
    @Test
    public void testRoute() {
        rabbitTemplate.convertAndSend("logSs_directs", "error", "发送的是info信息");
    }
}
