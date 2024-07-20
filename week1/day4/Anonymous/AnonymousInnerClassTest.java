package com.ureca.Anonymous;
//익명 내부 클래스 테스트


class A {
	public void happy() {
		System.out.println("happy!");
	}
}

class ChildOfA extends A {
	@Override
	public void happy() {
		System.out.println("행복한!");
	}
}

interface Ureca {
	void good();
}

class My {
	public static void go (Ureca u) {
		u.good();
	}
}


class ChildOfUreca implements Ureca {

	@Override
	public void good() {
		System.out.println("Ureca!");
	}
	
}



public class AnonymousInnerClassTest {
	
	public static void main(String[] args) {
//		A a = new A();
		
//		A a = new ChildOfA(); //따로 클래스 파일 만들기 귀찮아 -> 익명 내부 클래스 이용하자
		A a = new A() { // (중괄호의 의미 = extends A)
			public void happy() {
				System.out.println("익명 행복한!");
			}
		};
		a.happy();
		
		
		
		
		
//		My.go(new Ureca());  interface: new 객체할당 불가 => 자식 생성 필요
//		My.go(new ChildOfUreca());
		
//		자식클래스 없이 구현 객체를 익명 내부 클래스로 정의할 수 있음  
		My.go(new Ureca() { // (중괄호의 의미 = implements Ureca)
			
			@Override
			public void good() {
				System.out.println("익명 Ureca!");
			}	
		});
	}
}
