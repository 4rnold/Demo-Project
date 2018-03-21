package com.arnold.Basic.SPI;

import java.util.ServiceLoader;

public class Main {
	public static void main(String[] args) {
		ServiceLoader<DogService> loaders = ServiceLoader.load(DogService.class);
		for (DogService loader : loaders) {
			loader.sleep();
		}
	}
}
