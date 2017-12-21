package com.arnold.jms.MessageConverter.listener;

import com.arnold.jms.MessageConverter.entity.Email;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class ConsumerObjMessageListener implements MessageListener {

	private MessageConverter emailMessageConverter;


	public MessageConverter getEmailMessageConverter() {
		return emailMessageConverter;
	}

	public void setEmailMessageConverter(MessageConverter emailMessageConverter) {
		this.emailMessageConverter = emailMessageConverter;
	}

	@Override
	public void onMessage(Message message) {

		if (message instanceof ObjectMessage) {
            ObjectMessage objMessage = (ObjectMessage) message;  
            try {  
                Object obj = objMessage.getObject();  
                Email email = (Email) obj;
                System.out.println("接收到一个ObjectMessage，包含Email对象。");  
                System.out.println(email);  
            } catch (JMSException e) {
                e.printStackTrace();  
            }  
        }  
    }  
   
}  