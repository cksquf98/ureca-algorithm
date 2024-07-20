package com.ureca.Mission;

import java.util.Random;

public class Answer2 {

	public static void main(String[] args) {
		
	   int[]lotto = new int[45];//[0]번지~[44]번지 생성
	   Random r = new Random();
	   
	   for (int i = 0; i < lotto.length; i++) {//1~45 번호 저장
		  lotto[i]= i+1; 
	   }
	   
	   int tmp;
	   
	   for(int i=0; i<1000; i++) {//숫자를 섞어주는 횟수 표현
	      int changeIdx = r.nextInt(44)+1;//0~43 +1  = 1~44번지
		  tmp      = lotto[0];
		  lotto[0] = lotto[changeIdx];
		  lotto[changeIdx] = tmp;
	   }

	   //로또 번호 출력
	   for(int i=0; i<6; i++) {
		   System.out.print(lotto[i]+" ");
	   }
	}
	
}











