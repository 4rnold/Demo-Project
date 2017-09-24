package com.arnold.SpringmvcAsync;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LongTimeAsyncCallService {
	private final int CorePoolSize = 4;
	private final int NeedSeconds = 3;
	private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(CorePoolSize);

	public void makeRemoteCallAndUnknownWhenFinish(final LongTermTaskCallback callback) {
		System.out.println("完成此任务需要 : " + NeedSeconds + " 秒");
		scheduler.schedule(new Runnable() {
			@Override
			public void run() {
				//长时间逻辑处理


				callback.callback("长时间异步调用完成.");
			}
		}, 3, TimeUnit.SECONDS);
	}
}