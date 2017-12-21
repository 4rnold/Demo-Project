package com.arnold.jms.MessageConverter.test;

import com.arnold.jms.MessageConverter.entity.Email;
import com.arnold.jms.MessageConverter.service.EntityProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.Destination;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:jms/spring-context-jms-MessageConverter.xml","classpath:spring-context.xml"})
public class MessageConverterTest {

	@Resource(name = "entityProducerService")
	private EntityProducerService entityProducerService;

	@Autowired
	@Qualifier("adapterQueue")
	private Destination adapterQueue;

	@Test
	public void testObjectMessage() {
		Email email = new Email("test@qq.com", "测试", "HellWorld");
		entityProducerService.sendMessage(adapterQueue, email);
	}

}
