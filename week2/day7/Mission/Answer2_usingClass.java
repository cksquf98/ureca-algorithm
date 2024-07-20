package com.ureca.Mission;

import java.util.LinkedList;
import java.util.Queue;

public class Answer2_usingClass {
	//int[]person=new int[]{1,1}; 을 클래스로 표현!!
	static class Person{
		int no;      //배열 person[0]번지
		int candyCnt;//배열 person[1]번지
		
		public Person(int no, int candyCnt) {
			super();
			this.no = no;
			this.candyCnt = candyCnt;
		}

		@Override
		public String toString() {
			return "Person [no=" + no + ", candyCnt=" + candyCnt + "]";
		}
		
		
	}
	
	public static void main(String[] args) {
		Queue<Person> queue = new LinkedList<>(); //==> 대기열
		
		int no=1; //줄서기 번호
		
//		첫번째 데이터(사람) 입력
		queue.offer(new Person(no,1));//==> 0번지:사람번호,  1번지:받을 캔디수
		
		Person person;
		int candyTotalCnt=20;//전체캔디수
		int availableCnt = 0;//받을 캔디수
		
		while(candyTotalCnt > 0) {
			if(!queue.isEmpty()) { //대기열에 줄 선 사람이 있다며
				//캔디 받기(줄에서 나오기)
                person = queue.poll();
                availableCnt = (candyTotalCnt>= person.candyCnt)?  person.candyCnt:candyTotalCnt ;
				candyTotalCnt -= availableCnt; //캔디를 나눠준 만큼 total에서 빼주기
                
				if(candyTotalCnt==0) {//캔디를 전부 나누어 주었을때
					System.out.println("##마지막 캔디를 가져간 사람: "+ person.no +"번!!");
				}else {//캔디를 나누어 줄수 있을때
					System.out.println(">>["+person.no+"번]캔디 "+person.candyCnt+"개 가져가요~^^");
					person.candyCnt++; //다음에 받을 캔디수를 증가
                    queue.offer(person);//다시 줄서기
                    queue.offer(new Person(++no,1));//다음 사람 줄세우기
				}
				
			}
		}//while
		
		System.out.println();
		System.out.println("대기열 정보>>>"+ queue);

	}//main

}//end class

