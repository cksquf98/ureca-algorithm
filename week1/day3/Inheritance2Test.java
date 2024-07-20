package com.uplus;

import java.util.ArrayList;
import java.util.Vector;

public class Inheritance2Test {

	public static void main(String[] args) {
		//가변길이 Object 배열 : 다른 자료형 타입들을 한번에 담을 수 있지만 나중에 오류 발생할 가능성 높음
		ArrayList list1 = new ArrayList();
		
		list1.add("hong");
		list1.add("kim");
		list1.add("lee");
		list1.add(100);
		
		
		//<Generic>을 사용해서 특정 자료형만 담아두게 하자!
		ArrayList<String> list2 = new ArrayList<>();
		
		list2.add("hong");
		list2.add("kim");
		list2.add("lee");
//		list2.add(100); error-!
		
		Inheritance2.print(list2);
		
		
		//Vector
		Vector<String> list3 = new Vector<>();
		list3.add("hong");
		list3.add("kim");
		list3.add("lee");
//		list3.add(100); error-!
		
//		Overriding.print(list3); 상속관계도 아니고 자료형 아예 달라서 error-!
		Inheritance2.print2(list3); //Vector의 부모가 List이기 때문에 부=자 성립
	}

}
