package com.ureca.Mission;

import java.util.ArrayDeque;
import java.util.Queue;

public class Answer_usingArray {

	public static void main(String[] args) {
		
		
		
		Queue<int[]> queue = new ArrayDeque<>(); //int[] 배열도 결국 주소값을 참조하기 때문에 Wrapper 클래스와 같은 역할
		
		/*
		int[] peopleCandy;
		peopleCandy = { 사람 번호, 받을 사탕 수 }  --> 에러: 배열 선언과 동시에 할당되어야 함
		
		int[] peopleCandy;
		peopleCandy = new int[N]  --> O
		
		int[] peopleCandy;
		peopleCandy = new int[} { 사람 번호, 받을 사탕 수 } --> O
		*/
		
		
		int[] person;
		int no = 1; //줄 선 사람 번호
		
		int totalCandy = 20;    //전체 사탕
		int availableCandy = 0; //받을 사탕 수
		
		
		//첫번째 대기자 번호랑 사탕 개수 넣기
		queue.offer(new int[] {no,1});
		
		while(totalCandy > 0) {
			if(!queue.isEmpty()) {
				//사탕 받고 줄에서 나오기
				person = queue.poll();
				availableCandy = (totalCandy > person[1])? person[1] : totalCandy; //받을 사탕보다 전체 사탕이 적은 경우 -> 남은 캔디 다 주도록 함 (for 음수값 안나오도록)
				totalCandy -= availableCandy;
				
				
				if(totalCandy == 0) 
				{
					//캔디 다 나눠준 경우
					System.out.println("### 마지막 사탕의 주인 : " + person[0] + "번!!");
				}
				else 
				{
					System.out.println(person[0]+"번이 사탕을 "+person[1]+"개 가져감");
					
					//캔디 남아있는 경우 : 다음에 받을 캔디 개수+1 -> 다시 줄 서기
					person[1]++;
					queue.offer(person); //두 문장 순서 바뀌어도 됨 : 참조 변수이기 때문에 변경 값을 그대로 사용할 수 있음! ***
					
					//새로운 사람 줄 서기
					no++;
					queue.offer(new int[] {no,1});
				}
			}
		}
	}

}
