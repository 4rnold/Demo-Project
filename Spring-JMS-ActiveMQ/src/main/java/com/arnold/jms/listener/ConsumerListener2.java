package com.arnold.jms.listener;

/**
 * 普通bean作为mq的接收方法
 */
public class ConsumerListener2 {
   
    public void handleMessage(String message) {
		System.out.println("ConsumerListener通过handleMessage接收到消息：" + message);
    }

	/*public void receiveMessage(String message) {
		System.out.println("ConsumerListener通过receiveMessage接收到消息：" + message);

	}*/

	/**
	 * 有返回值的
	 * @param message
	 * @return
	 */
    public String receiveMessage(String message) {
        System.out.println("ConsumerListener通过receiveMessage接收到消息：" + message);
		return "这是ConsumerListener对象的receiveMessage方法的返回值。";

	}
      
}  