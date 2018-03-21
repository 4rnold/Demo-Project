package com.arnold.thread.segmentfault;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class test1010000012993512_2 {
	public static class Task implements Callable<String> {
		@Override
		public String call() throws Exception {
			String tid = String.valueOf(Thread.currentThread().getId());
			System.out.printf("Thread#%s : in call\n", tid);
			return tid;
		}
	}

	ExecutorService es = Executors.newFixedThreadPool(200);//Executors.newCachedThreadPool();

	public void doworks() throws ExecutionException, InterruptedException {
		List<Future<String>> results = new ArrayList<Future<String>>();

		for (int i = 0; i < 100; i++) {
			results.add(es.submit(new test1010000012993512.Task()));
		}

		for (Future<String> res : results) {
			System.out.println(res.get());
		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		test1010000012993512_2 a = new test1010000012993512_2();
		a.doworks();
		System.out.println("over");
	}
}
