package com.ureca.override;


class Parent {
	public Parent() {
		System.out.println("Parent 기본 생성자");
	}
	
	void good() {
		System.out.println("굿");
	}
}

class Child extends Parent {
	public Child() {
		System.out.println("Child 기본 생성자");
	}
}

public class ConstructorCallTest {

	public static void main(String[] args) {
		Child c = new Child();
		c.good();
		//부모 먼저 메모리 할당 -> 부모  생성자 호출 -> 자식 메모리 할당 -> 자식 생성자 호출
	}
}