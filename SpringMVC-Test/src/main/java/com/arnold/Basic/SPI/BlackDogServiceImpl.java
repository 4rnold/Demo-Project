package com.arnold.Basic.SPI;

public class BlackDogServiceImpl implements DogService {
	@Override
	public void sleep() {
		System.out.println("black sleep。。");
	}
}
