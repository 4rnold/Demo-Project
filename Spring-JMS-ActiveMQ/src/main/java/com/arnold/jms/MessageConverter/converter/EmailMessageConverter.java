package com.arnold.jms.MessageConverter.converter;

import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.io.Serializable;

/**
 * @author Arnold
 */
public class EmailMessageConverter implements MessageConverter {
  
    @Override
	public Message toMessage(Object object, Session session) {
		ObjectMessage objectMessage = null;
        try {  
            objectMessage = session.createObjectMessage((Serializable) object);
        } catch (JMSException e) {
            e.printStackTrace();  
        }  
        return objectMessage;  
    }  
  
    @Override
	public Object fromMessage(Message message) {
        ObjectMessage objMessage = null;  
        Serializable serializable = null;  
        try {  
            objMessage = (ObjectMessage) message;  
            serializable = objMessage.getObject();  
        } catch (JMSException e) {  
            e.printStackTrace();  
        }  
        return serializable;  
    }  
}  