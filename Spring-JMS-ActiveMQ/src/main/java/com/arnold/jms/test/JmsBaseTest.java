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
@ContextConfiguration({"classpath:jms/spring-context-jms-base.xml","classpath:spring-context.xml"})
public class JmsBaseTest {

	@Autowired
	@Qualifier("ProduceServiceImpl")
	private ProducerService producerService;

	@Autowired
	@Qualifier("queueDestination")
	private Destination queueDestination;

	/**
	 * 基础的发送消息，接受消息
	 */
	@Test
	public void testSend() {
		for (int i = 0; i < 5; i++) {
			producerService.sendMessage(queueDestination,"消息--"+i);

		}
	}
}
