package com.arnold.Basic.Singleton;

public class InnerStaticSingleton {

	private static class singletonholder{
		public static InnerStaticSingleton instance = new InnerStaticSingleton();
	}

	private InnerStaticSingleton() {}

	public static InnerStaticSingleton getInstance() {
		return singletonholder.instance;
	}
}
