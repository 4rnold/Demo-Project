package com.arnold.thread.ABCABC;

public class ABC {
	public static void main(String[] args) throws InterruptedException {
		Object o = new Object();
		PrinterThread threadA = new PrinterThread(o);
		PrinterThread threadB = new PrinterThread(o);
		PrinterThread threadC = new PrinterThread(o);

		new Thread(threadA).start();
		Thread.sleep(1000);
		new Thread(threadB).start();
		new Thread(threadC).start();

	}
}


class PrinterThread implements Runnable{

	private Object lock = new Object();

	public PrinterThread(Object lock) {
		this.lock = lock;
	}

	@Override
	public synchronized void run() {
		synchronized (PrinterThread.class) {
			int i=10;
			while (i > 0) {
				System.out.println(Thread.currentThread().getName() + " | " + i);
				i--;
			}
		}
	}
}