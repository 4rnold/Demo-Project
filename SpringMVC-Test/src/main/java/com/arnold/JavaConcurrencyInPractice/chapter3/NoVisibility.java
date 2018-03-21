package com.arnold.JavaConcurrencyInPractice.chapter3;

public class NoVisibility {
	private static boolean ready;
	private static int number;

	private static class ReaderThread extends Thread {
		public void run() {
			while (!ready)
				Thread.yield();
			System.out.println(number);
		}
	}

	public static void main(String[] args) {
		int a =100;
		//while (a>0) {
			System.out.print(a + ":");
			new ReaderThread().start();
			number = 42;
			ready = true;
			a--;
		//}
	}
}