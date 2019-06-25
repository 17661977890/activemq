package com.example.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class FirstConsumer {

    /**
     * 名为"first.queue"消息队列的消费者，通过JmsListener进行监听此队列有没有消息，有消息会立刻读取过来
     * @param text
     */
    @JmsListener(destination="first.queue")
    public void receiveQueue(String text){
        System.out.println("FirstConsumer收到的报文为:"+text);
    }
}