package com.uplus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//<Mission>
//:앞쪽_화살표:입력값
//0 1 0 0 1
//1 3 5
//==> 8개의 정수데이터가 두줄에  입력된다.
//이 입력된 값을 arr[ ]배열에 저장하자.
public class InputMission {

	public static void main(String[] args) throws Exception {
		/*
		 * <입출력 4대클래스>
		 * 
		 * 스트림(Stream) - 연속된 바이트의 흐름.
		 * 
		 * 
		 * 읽기 쓰기 InputStream OutputStream <=== 바이트단위
		 * ------------------------------------- Reader Writer <=== 문자단위
		 * ===========================================================-- 대표메서드 read()
		 * write()
		 * 
		 */

		/*
		 * 입력값 0 1 0 0 1 1 3 5
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine(); // Scanner의 nextLine()과 동일한 동작 ==> 엔터가 구분자
		// str="0 1 0 0 1";

		int N = 5; // 보통 알고리즘문제에서는 입력될 데이터 수가 정해짐

		int[] arr = new int[N];

//			  StringTokenizer tokens = new StringTokenizer(String 기준문자열str, String 구분문자열delimiter);
//			  StringTokenizer tokens = new StringTokenizer(String 기준문자열str); ==>  공백을 구분자로 사용

		// str="0 1 0 0 1";
		StringTokenizer tokens = new StringTokenizer(str, " "); // 구분자를 통해 구분된 각각의 데이터를 '토큰'이라고 표현
		// tokens = [ 0,1,0,0,1 ]

		// ==> 알고리즘에서는 데이터의 갯수가 정해져 있으므로 for문을 사용하면 됨
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		} // arr={0,1,0,0,1};

		System.out.println(Arrays.toString(arr));

	}// main

}