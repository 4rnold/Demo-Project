package com.arnold.Basic.Singleton;

public class DoubleCheckSingleton {

	private static volatile DoubleCheckSingleton instance = null;

	//存在指令重排的问题
	//private static DoubleCheckSingleton instance = null;

	private DoubleCheckSingleton(){}

	public static DoubleCheckSingleton getInstance() {
		if (instance == null) { //由于指令重排，提前分配空间，但没有进行初始化操作。
			synchronized (DoubleCheckSingleton.class) {
				if (instance == null) {
					instance = new DoubleCheckSingleton();//分为三步，如果没有volatile，会产生多例。
				}
			}
		}
		return instance;
	}
}
