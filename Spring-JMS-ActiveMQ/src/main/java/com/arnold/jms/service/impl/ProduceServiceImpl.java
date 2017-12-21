package com.arnold.jms.service.impl;

import com.arnold.jms.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author Arnold
 */
@Service("ProduceServiceImpl")
public class ProduceServiceImpl implements ProducerService {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public void sendMessage(Destination destination, String message) {
		System.out.println("生产者发送消息：" + message);
		jmsTemplate.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}
}
