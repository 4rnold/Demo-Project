package com.arnold.jms.test;

import com.arnold.jms.service.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:jms/spring-context-jms-SessionAwareMessageListener.xml","classpath:spring-context.xml"})
public class JmsSessionAwareMessageListenerTest {

	@Autowired
	@Qualifier("ProduceServiceImpl")
	private ProducerService producerService;

	@Autowired
	@Qualifier("sessionAwareQueue")
	private Destination sessionAwareQueue;

	/**
	 * SessionAwareMessageListener 可以在onMessage() 中获取session对象，通过session对象可以发送消息。
	 * 发送到sessionAwareQueue，首先ConsumerSessionAwareMessageListener 获取到消息，再发送一个消息到queueDestination，ConsumerMessageListener获取到消息。
	 * @throws InterruptedException
	 */
	@Test
	public void testSessionAwareMessageListener() throws InterruptedException {
		producerService.sendMessage(sessionAwareQueue,"测试SessionAwareMessageListener");
		Thread.sleep(1000);
	}
}
