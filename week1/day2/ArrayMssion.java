package com.uplus;

import java.util.Arrays;

public class ArrayMssion {

	public static void main(String[] args) {
		int[] su = {1,2,3,4,5};
		int len = su.length; //자주 쓰이기 때문에 아예 변수에 저장하기 -> 미미하지만 시간 절약
		
		//1. 데이터를 차례대로 출력
		for (int i = 0; i < len; i++) {
			System.out.print(su[i] + " ");
		}
			
		for (int s : su) {
			System.out.print(s + " ");
		}
		
		System.out.println("1차원 su배열 바로 출력 : " + Arrays.toString(su));
		
		System.out.println();
		
		//2. 데이터를 역순으로 출력
		for (int i = len - 1; i >= 0; i--) {
			System.out.print(su[i] + " ");
		}
		
		System.out.println();
		
		
		
		//3. su2배열의 데이터를 번지값과 함께 출력하시오
		int su2[][]={ {1}, {1,2}, {1,2,3}};
		
		for (int i=0; i < su2.length; i++)
		{
			for (int j=0; j < su2[i].length; j++)
			{
				System.out.println("su2["+i+"]["+j+"]번지 = " + su2[i][j]);
			}
		}

		
		//4. su3 이라는 배열을 새롭게 만들어서 [예시]su배열의 값을 복사하시오 (깊은 복사)
		int[] su3 = new int[len];      //int[] su3 = su; (동일 메모리 참조) -> 원본도 su[2] = 33으로 변경됨

		
		
//		1> for문으로 일일이 복사
//		for (int i = 0; i < len; i++) {
//			su3[i] = su[i];
//		}
		
//		2> 메서드 이용 => 속도가 빠르닷
		su3 = Arrays.copyOf(su, len);
		
		
		
		su3[2] = 33;
		System.out.println("su[2] = " + su[2]);
		
		
		
		//5. su배열을 for문을 통해 [0]번지~[4]번지까지 출력을 했을때 5  4  3  2  1 과 같이 출력되도록 하시오. 
		for (int i=1; i<=5; i++) {
			System.out.print(su[len-i] + " ");
		}
		System.out.println();
		
		
		//5. [0]번지와 [4]번지 데이터 교환,  [1]번지와 [3]번지 데이터 교환 후 출력
		for(int i=0; i<len/2;i++)
		{
			int tmp = su[i];
			su[i] = su[len-i-1];
			su[len-i-1] = tmp;
		}
		for (int i = 0; i < len; i++) {
			System.out.print(su[i] + " ");
		}
		
		System.out.println();
		
		
		
		
		//6. su배열의 홀수번지
		for(int i=1;i<5;i+=2)
		{
			System.out.print(su[i] + " ");
		}
		System.out.println();
		
		
		//7.su배열의 홀수값
		for (int i = 0; i < len; i++) {
			if(su[i] % 2 != 0)
				System.out.print(su[i] + " ");
		}
	}

}
