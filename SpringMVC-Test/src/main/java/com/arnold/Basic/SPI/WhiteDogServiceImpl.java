package com.arnold.Basic.SPI;

public class WhiteDogServiceImpl implements DogService {
	@Override
	public void sleep() {
		System.out.println("White sleep...");
	}
}
