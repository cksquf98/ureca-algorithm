package com.ureca.API;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		
		Queue<String> queue = new ArrayDeque<String>();
		System.out.println("queue size :" + queue.size() + ", empty : " + queue.isEmpty());
		
		//입력
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		System.out.println("queue size :" + queue.size() + ", empty : " + queue.isEmpty());
		
		
		
		//삭제
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println("queue size :" + queue.size() + ", empty : " + queue.isEmpty());
		
		
	}

}
