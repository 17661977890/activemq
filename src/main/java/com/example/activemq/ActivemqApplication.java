package com.example.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * 点对点：一对一（生产者对消费者）
 * 发布订阅：一对多
 */
@EnableJms
@SpringBootApplication
public class ActivemqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivemqApplication.class, args);
	}

	//新建一个的Queue对象，交给sringboot管理，这个queue的名称叫"first.queue".（点对点）
	@Bean
	public Queue queue(){
		return new ActiveMQQueue("first.queue");
	}

	//新建一个topic队列（发布/订阅）
	@Bean
	public Topic topic(){
		return new ActiveMQTopic("video.topic");
	}

}
