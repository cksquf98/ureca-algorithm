package com.ureca.pack1;

//기준 클래스 (자원 정의)
public class AccessControl {
	//필드,메소드 전부 access modifier의 개념은 같음!!
		
	public    void m1() {}             //다른 패키지
	protected void m2() {}             //같은 패키지,다른패키지 자식
		      void m3() { m4();  }     //같은 패키지
	private   void m4() {}			   //같은 클래스
}