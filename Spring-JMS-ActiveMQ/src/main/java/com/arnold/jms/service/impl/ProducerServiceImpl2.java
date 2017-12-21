package com.arnold.jms.service.impl;

import com.arnold.jms.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service(value="producerService2")
public class ProducerServiceImpl2 implements ProducerService {
   
    @Autowired
	private JmsTemplate jmsTemplate;
    @Autowired    
    @Qualifier("responseQueue")
    private Destination responseDestination;
        
    @Override
	public void sendMessage(Destination destination, final String message) {
        System.out.println("生产者发送消息：" + message);    
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
			public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                //设置reply到一个queue中去。接收返回值
                textMessage.setJMSReplyTo(responseDestination);    
                return textMessage;    
            }    
        });    
    }    
}  