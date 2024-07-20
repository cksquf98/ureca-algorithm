package com.ureca.Mission;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class QueueMission {

	public static void main(String[] args) {
		
		//pop이 되고 다시 큐에 offer --> 다음 싸이클 --> 새로운 사람 등장
		//int[]배열 사탕 개수 체크
		int candy = 20;
		int personNum = 1;
		int[] candyCheck = new int[31];
		
		Arrays.fill(candyCheck, 1);
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1); //1번이 줄을 섬
		
		int currentPerson = 0;
		
		while(candy >= 0) {
			if(!queue.isEmpty()) currentPerson = queue.peek();
			
			queue.poll(); //싸이클 끝
			candy -= candyCheck[currentPerson];
			candyCheck[currentPerson]++;
			
			//나간애가 다시 줄을 섬
			queue.offer(currentPerson);
			personNum++;
			queue.offer(personNum);
			
			
		}
		
		//person 저장했다가 출력하게
		System.out.println(currentPerson);

	}

}
