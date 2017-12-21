package com.arnold.jms.MessageConverter.service.impl;

import com.arnold.jms.MessageConverter.service.EntityProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import java.io.Serializable;

@Service(value="entityProducerService")
public class EntityProducerServiceImpl implements EntityProducerService {
   
    @Autowired
	private JmsTemplate jmsTemplate;
      
    @Override
	public void sendMessage(Destination destination, final Serializable obj) {
         //未使用MessageConverter的情况    
//        jmsTemplate.send(destination, new MessageCreator() {  
//            public Message createMessage(Session session) throws JMSException {  
//               ObjectMessage objMessage = session.createObjectMessage(obj);    
//                 return objMessage;    
//            }  
//        });  
      //使用MessageConverter的情况  
        jmsTemplate.convertAndSend(destination, obj);    
    }   
}  