package com.arnold.jms.MessageConverter.listener;

import com.arnold.jms.MessageConverter.entity.Email;

public class ConsumerListener {
   
    public void handleMessage(String message) {
		System.out.println("ConsumerListener通过handleMessage接收到消息：" + message);
    }  
//    public void receiveMessage(String message) {  
//        System.out.println("ConsumerListener通过receiveMessage接收到消息：" + message);  
//    }  
//    public String receiveMessage(String message) {  
//      System.out.println("ConsumerListener通过receiveMessage接收到消息：" + message);  
//      return "这是ConsumerListener对象的receiveMessage方法的返回值。";    
//    }  
      
    public void receiveMessage(Email email) {
        System.out.println("接收到一个包含Email的ObjectMessage。");    
        System.out.println(email);    
    }    
}  