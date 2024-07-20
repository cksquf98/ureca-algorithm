package com.uplus;

public class ConditionTest {

	public static void main(String[] args) {
		int jumsu = 85;
		
		switch (jumsu/10) {
		case 10:
		case 9:	
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default:
			System.out.println("E");
			break;
		}

	}

}
