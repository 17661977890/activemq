package com.example.activemq.controller;

import com.example.activemq.producer.ProducerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/**
 * 功能描述：点对点消息队列控制层
 */
@RestController
@RequestMapping("/api/v1")
public class QueueController {
    
    @Autowired
    private ProducerService producerService;
    /**
     * ===============================================点对点======================================================
     */
    /**
     * 这里后面调用的是Springboot主类的quene队列
     * @param msg  不能为空
     * @return
     */
    @GetMapping("first")
    public Object common(String msg){
        producerService.sendMessage(msg);    
        return "Success";
    }

    /**
     * 这个队列是新建的一个名为two.queue的点对点消息队列
     * @param msg 不能为空
     * @return
     */
    @GetMapping("two")
    public Object order(String msg){
        Destination destination = new ActiveMQQueue("two.queue");
        producerService.sendMessage(destination, msg);
        return "Success";
    }

    /**
     * =====================================================发布/订阅====================================================
     */
    @GetMapping("topic")
    public Object topic(String msg){
        producerService.publish(msg);
        return "Success";
    }
}