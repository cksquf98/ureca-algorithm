package com.uplus;
//<윤년의 조건>
//1. 연도를 4로 나누어 나머지가 0이고
//   연도를 100 으로 나누어 나머지가 0이 아닌 경우.
//
//2. 연도를 400으로 나누어 나머지가 0인 경우.
//
//    실행결과)
//           ==> 조건을 만족했을때 true 출력
//           ==> 조건을 만족하지않았을때 false 출력

public class LeapYearTest {
	
	public static void main(String[] args) {
		int year = 2023;
		
		boolean c1 = (year % 4) == 0;
		boolean c2 = (year % 100) != 0;		
		boolean c3 = (year % 400) == 0;				
		
		boolean result = ((c1 && c2) || c3);
		
	
		if(result)
			System.out.println(year + "년은 윤년입니다.");
		else
			System.out.println(year + "년은 평년입니다.");
	}
}