package com.ureca.mission;

import java.util.Arrays;

public class SortingMission {
	
	public static void main(String[] args) {
		//1. 오름차순 정렬
		int[]su = {13, 8, 7, 10, 100, 5};
		
		Arrays.sort(su);
		
		for (int i = 0; i < su.length; i++) {
			System.out.print(su[i] + " ");
		}
		System.out.println();
		
		
		//2. 문자,문자열 배열 오름차순 정렬
		char[]ch= {'J','a','v','A'};	//아스키 코드 비교
		String[]names= {"홍길동","길라임","김주원"};
		
		Arrays.sort(ch);
		for (int i = 0; i < ch.length; i++) {
			System.out.print(ch[i] + " ");
		}
		System.out.println();
		
		Arrays.sort(names);
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i] + " ");
		}
		System.out.println();
		
		
		//3.Person name에 대한 오름차순 정렬
		Person p = new Person("갓길동",11,"학생",95);
		Person[] persons= {p ,
		   	            new Person("빛길동",19,"학생",80),
			            new Person("남길동",14,"학생",100),
			            new Person("여길동",17,"학생",99),
			            new Person("킹길동",15,"학생",56)};
		
		Arrays.sort(persons);
		System.out.println(Arrays.toString(persons));
	}

	
//	static class Person implements Comparable<Object>{
//		String name;
//		int age;
//		String job;
//		int score;
//		
//		Person(String name, int age, String job, int score) {
//			this.name = name;
//			this.age = age;
//			this.job = job;
//			this.score = score;
//		}
//
//		@Override  //Person 객체가 구현하는 Comparable 인터페이스의 compareTo: 객체 자체의 정렬 순서를 정의
//		public int compareTo(Object o) {
//			
//			return name.compareTo(((Person)o).name); //String 클래스의 compareTo : 사전순 문자열 비교 -> 음수/0/양수
//		
//		}
//	}
}
