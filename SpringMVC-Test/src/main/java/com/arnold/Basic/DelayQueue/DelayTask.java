package com.arnold.Basic.DelayQueue;

import java.util.Date;
import java.util.concurrent.DelayQueue;

public class DelayTask implements Runnable {
	private int id;
    private DelayQueue<DelayItem> queue;
    public DelayTask(int id, DelayQueue<DelayItem> queue) {
        super();
        this.id = id;
        this.queue = queue;
    }
    @Override
    public void run() {
        Date now = new Date();
        //延迟时间
        Date delay = new Date();
        delay.setTime(now.getTime() + id * 10000);
        System.out.println("Thread " + id + " " + delay);
        for (int i = 0; i < 100; i++) {
            DelayItem delayItem = new DelayItem(delay);
            //向queue中加入100个item
            queue.add(delayItem);
        }
    }
}