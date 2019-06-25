package com.example.activemq.producer.impl;

import com.example.activemq.producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * 功能描述：消息生产者实现类
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    //这个队列就是Springboot主类中bean的对象
    @Autowired
    private Queue queue;
    
    //用来发送消息到broker的对象,可以理解连接数据库的JDBC
    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    @Autowired
    private Topic topic;

    /**
     * 发送消息，destination是发送到的队列，message是待发送的消息
     * convertAndSend():参数1：消息发送地址 参数2：消息内容
     * @param destination
     * @param message
     */
    @Override
    public void sendMessage(Destination destination, String message) {
        jmsTemplate.convertAndSend(destination, message);    
    }

    /**
     * 发送消息，queue是发送到的队列，message是待发送的消息
     * @param message
     */
    @Override
    public void sendMessage(final String message) { 
        jmsTemplate.convertAndSend(this.queue, message);    
    }

    /**
     * 发布订阅
     * @param msg
     */
    @Override
    public void publish(String msg) {
        this.jmsTemplate.convertAndSend(this.topic, msg);

    }
}