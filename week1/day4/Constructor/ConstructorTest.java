package com.ureca.Constructor;

public class ConstructorTest {

	public static void main(String[] args) {
		
		Constructor c1 = new Constructor();
		Constructor c2 = new Constructor("Java"); 
		c1.hello();
		c2.hello();
		
		System.out.println("c1 str = " + c1.str);
		System.out.println("c2 str = " + c2.str);
	}

}
