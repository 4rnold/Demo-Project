package com.arnold.databinder.Formatter.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springmvc-config.xml")
public class FormatterTest {

	@Test
	public void testFormatter() {
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
		form.add("userName", "tom");
		form.add("password", "123456");
		form.add("age", "45");
		form.add("birthday", "1980-01-01");
		form.add("salary", "4,500.00");
		String html = restTemplate.postForObject(
				"http://localhost:8080/Formatter", form, String.class);
		Assert.assertNotNull(html);
		Assert.assertTrue(html.indexOf("tom") > -1);
	}

}
