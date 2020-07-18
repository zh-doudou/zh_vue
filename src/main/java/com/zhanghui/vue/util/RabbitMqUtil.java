package com.zhanghui.vue.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

//封装工具类

public class RabbitMqUtil {
    private static ConnectionFactory factory;

    static {
        //创建连接工厂
        factory = new ConnectionFactory();
        //设置ip地址
        factory.setHost("192.168.32.163");
        //设置端口号
        factory.setPort(5672);
        //设置虚拟机的名字
        factory.setVirtualHost("/vue");
        //设置用户名
        factory.setUsername("zh");
        //设置密码
        factory.setPassword("123");
    }

    public static Connection getConnection() {
        //创建一个连接
        Connection connection = null;
        try {
            connection = factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnectionChannel(Channel channel, Connection connection) {
        try {
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
