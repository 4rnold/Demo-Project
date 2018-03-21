package com.arnold.Basic.Singleton;

public class EagerSingleton {
	private static EagerSingleton instance = new EagerSingleton();

	public static EagerSingleton getInstance() {
		return instance;
	}

	private EagerSingleton(){}

	public static void main(String[] args) {
		EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
		EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();
		if (eagerSingleton1 == eagerSingleton2)
			System.out.println("yes");

	}
}
