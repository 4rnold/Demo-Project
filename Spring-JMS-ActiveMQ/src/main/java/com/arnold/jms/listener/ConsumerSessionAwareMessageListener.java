package com.arnold.jms.listener;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.*;

/**
 * @author Arnold
 */
public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener<TextMessage> {
  
    private Destination destination;

	@Override
    public void onMessage(TextMessage textMsg, Session session) throws JMSException {
        System.out.println("接收到消息：" + textMsg.getText());  
        //发送消息  
        MessageProducer producer = session.createProducer(destination);
        Message message = session.createTextMessage("SessionAwareMessageListener........");
        producer.send(message);  
    }  
  
    public Destination getDestination() {  
        return destination;  
    }  
  
    public void setDestination(Destination destination) {  
        this.destination = destination;  
    }  
  
} 