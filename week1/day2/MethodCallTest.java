package com.uplus;

//1. 자바클래스 만들수 있어? => MethodCallTest
//2. '안녕, 유플러스~^O^' 콘솔화면에 찍을 수 있어?
//5. MethodCallTest에 good( )메서드를 만들고 main( )에서 호출할 수 있어?

public class MethodCallTest {
	
	//Inner Class
	static class B {
		
	}
	
	
	static void good() {
		System.out.println("Goooood");
	}
	
	public static void main(String[] args) {
		
		System.out.println("안녕 유플러스");
		
		A a = new A();
		a.Hello();
		
		
		good();
		A.uplus();
	}
}

//A.java를 통해 이미 B클래스 파일이 만들어져 있어서 에러남 => 내부 클래스로 만들어야겠다
//class B {
//	
//}