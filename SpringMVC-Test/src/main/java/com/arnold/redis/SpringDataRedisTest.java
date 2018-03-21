package com.arnold.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.sql.Connection;

public class SpringDataRedisTest {
	public static void main(String[] args) {
		args = new String[]{"classpath:spring-context.xml","classpath:spring-context-redis.xml"};
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(args);
		RedisTemplate redisTemplate = (RedisTemplate) applicationContext.getBean("redisTemplate");

		redisTemplate.opsForSet().add("123","456");

		String result = (String) redisTemplate.opsForSet().pop("123");

		System.out.println(result);
		/*redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
				redisConnection.set("testkey".getBytes(),"testvalue".getBytes());
			}
		});
		
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
				return null;
			}
		});*/
		
		
	}
}
