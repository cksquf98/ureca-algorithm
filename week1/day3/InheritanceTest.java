package com.uplus;

public class InheritanceTest {

	public static void main(String[] args) {
		Child c = new Child();
		Parent p = new Child();
		
//		c.hello("하하"); //Parent
		c.print();     //overriding된 자식 메서드
		System.out.println(c.su);
		System.out.println(p.su);
		
		c.toString(); //메서드 탐색 : Child -> Parent -> Object

	}
}
