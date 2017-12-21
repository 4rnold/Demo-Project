package com.arnold.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 接受普通bean（ConsumerListener）的返回结果
 */
public class ResponseQueueListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;  
            try {  
                System.out.println("接收到发送到responseQueue的一个消息" + textMessage.getText());  
            } catch (JMSException e) {
                e.printStackTrace();  
            }  
        }  
    }  
}  