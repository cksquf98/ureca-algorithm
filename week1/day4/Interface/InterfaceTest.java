package com.ureca.Interface;

public class InterfaceTest {
	public static void main(String[] args) {
//		Menupan menu = new Menupan(); error! 인터페이스는 직접 객체 할당 불가
		
		Menupan menu;  
		menu = new Restaurant();
		menu.짜장면();
		
//		menu.초밥(); error! 초밥은 자식 클래스에만 있는 메서드임
		((Restaurant) menu).초밥();
	}
}