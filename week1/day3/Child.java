package com.uplus;

public class Child extends Parent{
                  //extends = is a 관계  : 자식은 부모다 ==> 자식클래스는 부모클래스로 형변환이 가능하다
	int su = 100;
	
   void print() {//오버라이딩 (메소드 재정의)
	   System.out.println("자식");
   }
}
