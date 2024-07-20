package com.ureca.Interface;

public class Restaurant implements Menupan {

	@Override
	public void 짜장면() {
		System.out.println("짜장면");
	}

	@Override
	public void 짬뽕() {
		System.out.println("짬뽕");
	}

	@Override
	public void 볶음밥() {
		System.out.println("볶음밥");
	}
	
	void 초밥() {
		System.out.println("초밥");
	}

}
