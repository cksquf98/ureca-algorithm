package com.uplus;

import java.util.Scanner;

public class LoopTest {

	public static void main(String[] args) {
		
		//문제1) 다음과 같이 화면에 출력하시오.
		//1
		//2
		//3
		//4
		//5
		for(int i=0; i<5; i++)
		{
			System.out.println(i+1);
		}
		
		System.out.println();
		
		
		//문제3) 다음과 같이 화면에 출력하시오.
		//5 4 3 2 1
		for(int i=5; i>0; i--)
		{
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		
		//문제4) 다음과 같이 화면에 출력하시오.
		//3 6 9 12
		for(int i=3; i<=12; i+=3)
		{
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		
		//MenuMission.java
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int res = 0;
		
		do
		{
			System.out.println("<<메뉴>>\n1.검색 2.증가 3.감소 4.종료\n번호 입력==> ");
			num = sc.nextInt();
			
			if(num == 1)
				System.out.println("검색 결과:" + res);
			else if(num == 2)
			{
				res++;
				System.out.println("1 증가하였습니다.");
			}
			else if(num == 3)
			{
				res--;
				System.out.println("1 감소하였습니다.");
			}
			else
			{
				System.out.println("--END--");
			}
				
		}while(num != 4);
	}

}
