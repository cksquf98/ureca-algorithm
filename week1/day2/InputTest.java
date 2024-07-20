package com.uplus;

import java.io.*;
import java.util.Scanner;

public class InputTest {
	
	//예외 : IOException(java.io) < Exception(기본 패키지에 존재) < Throwable
	public static void main(String[] args) throws Exception {
		
		//1. System.in.read()
		System.out.print("input : ");
		int a = System.in.read();	 //아스키 코드로 저장됨
		System.out.println(a - '0'); // '0' = 48
		System.out.println(a - 48);
		
		//엔터키 처리 문장
		System.in.read(); // CR 처리
		System.in.read(); // LF 처리
		
		
		System.out.print("input : ");
		int b = System.in.read();
		System.out.println(b-48+"의 아스키 코드 = "+b);	//이상한 숫자 나옴 -> 이전 입력에서의 엔터 입력(줄 내림 + 커서 앞으로 땡기기)의 아스키코드가 버퍼에 남아있기 때문
		
		
		
		
		//2. Scanner 
		Scanner sc = new Scanner(System.in);
		
		//3. BufferedReader
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		
		
	}
}
