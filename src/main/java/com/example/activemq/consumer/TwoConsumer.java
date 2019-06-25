package com.example.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TwoConsumer {

    /**
     * 名为"two.queue"消息队列的消费者，通过JmsListener进行监听此队列有没有消息，有消息会立刻读取过来
     * @param text
     */
    @JmsListener(destination="two.queue")
    public void receiveQueue(String text){
        System.out.println("TwoConsumer收到的报文为:"+text);
    }
}