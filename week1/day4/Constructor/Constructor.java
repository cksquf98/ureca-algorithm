package com.ureca.Constructor;

public class Constructor {
	
	int s; //멤버변수니까 알아서 0으로 초기화된 상태
	String str; //멤버변수 알아서 null 초기화
	
	//기본 생성자 : 초기화 메서드
	Constructor() {
		s = 1000;
	}
	
	//오버로딩 생성자
	Constructor(String str) {
		this.str = str;
		//str = str;  --> 가장 가까운 변수인 파라미터 지역변수 str로 인식됨
		// => 멤버변수에 str이 들어가지 않음.
	}
		
	void hello() {
		System.out.println("안뇽");
	}
}
