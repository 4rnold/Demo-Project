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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context-jms.xml","classpath:spring-context.xml"})
public class MQTest {

	@Autowired
	@Qualifier("ProduceServiceImpl")
	private ProducerService producerService;

	@Autowired
	@Qualifier("queueDestination")
	private Destination queueDestination;

	@Test
	public void testSend() {
		for (int i = 0; i < 5; i++) {
			producerService.sendMessage(queueDestination,"消息--"+i);
			
		}
	}

	@Autowired
	@Qualifier("sessionAwareQueue")
	private Destination sessionAwareQueue;

	/**
	 * 发送到sessionAwareQueue，首先ConsumerSessionAwareMessageListener 获取到消息，再发送一个消息到queueDestination，ConsumerMessageListener获取到消息。
	 * @throws InterruptedException
	 */
	@Test
	public void testSessionAwareMessageListener() throws InterruptedException {
		producerService.sendMessage(sessionAwareQueue,"测试SessionAwareMessageListener");
		Thread.sleep(1000);
	}


	@Autowired
	@Qualifier("adapterQueue")
	private Destination adapterQueue;

	@Test
	public void testMessageListenerAdapter() {
		producerService.sendMessage(adapterQueue, "测试MessageListenerAdapter");
	}


	@Resource(name="producerService2")
	private ProducerService producerService2;

	@Autowired
	@Qualifier("adapterQueue")
	private Destination adapterQueue2;

	@Test

	public void testMessageListenerAdapter2() {
		producerService2.sendMessage(adapterQueue2, "测试MessageListenerAdapter");
	}
}
