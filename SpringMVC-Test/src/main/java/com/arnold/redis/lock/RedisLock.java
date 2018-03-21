package com.arnold.redis.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisLock {

	@Autowired
	RedisTemplate redisTemplate;

	public void lock(String lockKey) {
		while (true) {
			if(tryAcquireLock(lockKey)) {
				return;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean tryAcquireLock(String lockKey) {
		boolean isSuccess = redisTemplate.opsForValue().setIfAbsent(lockKey,"1");
		if (isSuccess) {
			//key的有效期为30秒，防止线程崩溃不释放key
			redisTemplate.expire(lockKey,30, TimeUnit.SECONDS);
		} else {
			//判断是否
		}

		return isSuccess;
	}

	public boolean unlock(String lockKey) {
		redisTemplate.delete(lockKey);
		return true;
	}
}
