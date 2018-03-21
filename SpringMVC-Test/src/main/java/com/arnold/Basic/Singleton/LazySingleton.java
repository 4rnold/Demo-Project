package com.arnold.Basic.Singleton;

public class LazySingleton {
	private static LazySingleton lazySingleton = null;

	private LazySingleton() {}

	/*没有考虑线程安全
	public static LazySingleton newInstance() {
		if (lazySingleton == null) {
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}*/

	public static synchronized LazySingleton newInstance() {
		if (lazySingleton == null) {
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}
}
