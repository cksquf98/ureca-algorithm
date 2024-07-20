package com.ureca.API;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {

		Stack<String> stack = new Stack<>();

		System.out.println("stack size :" + stack.size() + ", empty : " + stack.isEmpty());
	
		
		//push : 데이터 입력
		stack.push("A");
		stack.push("B");
		stack.push("C");
	
		System.out.println("stack size :" + stack.size() + ", empty : " + stack.isEmpty());
		
		
		
		//pop : 데이터 삭제
		//peek : 데이터 조회
		System.out.println(stack.pop() + " is deleted");
		System.out.println("TOP : " + stack.peek());
		System.out.println("stack size :" + stack.size() + ", empty : " + stack.isEmpty());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
//		System.out.println(stack.pop());  <== EmptyStackException
//		System.out.println(stack.peek());  <== EmptyStackExceptio
	}

}
