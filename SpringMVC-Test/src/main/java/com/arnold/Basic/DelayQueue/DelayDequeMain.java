package com.arnold.Basic.DelayQueue;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class DelayDequeMain {
	public static void main(String[] args) throws Exception {
        DelayQueue<DelayItem> queue = new DelayQueue<DelayItem>();
        Thread threads[] = new Thread[5];

        //设置5个线程，共享一个DelayQueue
        for (int i = 0; i < threads.length; i++) {
            DelayTask task = new DelayTask(i + 1, queue);
            threads[i] = new Thread(task);
        }

        //启动5个小城
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        //join到main
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        do {
            int counter = 0;
            DelayItem delayEvent;
            //先取出第一个线程加入的100个，再取第二个线程加入的100个
            do {
            	//时间没到取出为空
                delayEvent = queue.poll();
                if (delayEvent != null) {
                    counter++;
                }
            } while (delayEvent != null);
            System.out.println("At " + new Date() + " you have read " + counter+ " event");
            TimeUnit.MILLISECONDS.sleep(500);
        } while (queue.size() > 0);
    }
}