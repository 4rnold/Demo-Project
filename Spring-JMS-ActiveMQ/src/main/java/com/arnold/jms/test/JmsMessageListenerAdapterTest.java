package com.arnold.jms.test;

import com.arnold.jms.service.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @author Arnold
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:jms/spring-context-jms-MessageListenerAdapter.xml","classpath:spring-context.xml"})
public class JmsMessageListenerAdapterTest {

	@Autowired
	@Qualifier("ProduceServiceImpl")
	private ProducerService producerService;

	@Autowired
	@Qualifier("adapterQueue")
	private Destination adapterQueue;

	/**
	 * MessageListenerAdapter可以使普通bean的方法，作为mq消息的接收者。
	 * 此处是ConsumerListener.receiveMessage() 方法接收消息
	 */
	@Test
	public void testMessageListenerAdapter() {
		producerService.sendMessage(adapterQueue, "测试MessageListenerAdapter");
	}


	@Resource(name="producerService2")
	private ProducerService producerService2;

	@Autowired
	@Qualifier("adapterQueue2")
	private Destination adapterQueue2;

	/**
	 * 1.producerService2生产消息，发送到adapterQueue2 中由 ConsumerListener2.receiveMessage 处理（带返回值）
	 * 2.producerService2 将返回值 发送到 responseQueue中， 由ResponseQueueListener处理。
	 */
	@Test
	public void testMessageListenerAdapter2() {
		producerService2.sendMessage(adapterQueue2, "测试MessageListenerAdapter");
	}


	@Autowired
	@Qualifier("adapterQueue3")
	private Destination adapterQueue3;

	/**
	 * producerService不用设置reply，设置defaultResponseDestination属性自动绑定返回值到此队列
	 * 再配置相应的Listener处理返回值。
	 */
	@Test
	public void testMessageListenerAdapter3() {
		producerService.sendMessage(adapterQueue3, "测试MessageListenerAdapter");
	}


}
