package com.example.activemq.producer;

import javax.jms.Destination;

/**
 * 功能描述：消息生产
 */
public interface ProducerService {
    /**
     * =============================================点对点==================================================
     */
    /**
     * 功能描述：指定消息队列，还有消息
     * @param destination
     * @param message
     */
    void sendMessage(Destination destination, final String message);


    /**
     * 功能描述：使用默认消息队列， 发送消息
     * @param message
     */
    void sendMessage( final String message);

    /**
     * ================================================发布/订阅================================================
     */
    /**
     * 功能描述：消息发布者
     * @param msg
     */
    void publish(String msg);

}