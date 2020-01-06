package com.mq.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.transaction.RabbitTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rabbitmq.RabbitApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=RabbitApplication.class)
public class ProductTest {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Test
	public void sendMsg(){
		rabbitTemplate.convertAndSend("zhiyou","测试直接模式");
	}
	
	 @Test
	    public void testSendFanout(){
	        rabbitTemplate.convertAndSend("chuanzhi","","分列模式了解一下?");
	    }


	    @Test
	    public void testSendTopic1(){
	        rabbitTemplate.convertAndSend("topictest","goods.aaa","主题模式绑定itcast");
	    }

	
	     
}
