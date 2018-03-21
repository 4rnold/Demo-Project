package com.arnold.JavaConcurrencyInPractice.chapter5;

import java.util.concurrent.*;

public class FutureRenderer {

	ExecutorService executorService = Executors.newCachedThreadPool();


	public static void downLoadImage() {

	}

	public void renderText() {

	}

	public void renderPage() {
		Future<Object> future = executorService.submit(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				return null;
			}
		});
	}
}
