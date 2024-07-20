package 순열조합부분집합;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {

	static int N, numbers[]; // N: 주사위 던지는 수, numbers: 던저진 주사위 수의 결과값들
	static boolean isSelected[]; // 이전 선택했던 값인지 체크, numbers랑 동일한 인덱스 사용

	public static void main(String[] args) throws Exception {

		// 주사위 던지기 모드 M
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		numbers = new int[N];

		int M = sc.nextInt();

		switch (M) {
		case 1: {// M = 1 : 3번 던져서 나올 수 있는 모든 경우 = 중복순열 -> 6*6*6 재귀 수행
			dice1(0);
			break;
		}
		case 2: {// M = 2 : 3번 던져서 모두 다른 수가 나올 수 있는 모든 경우 = 중복제거순열 -> 6*5*4
			isSelected = new boolean[N]; // 6개 수에 대한 중복 확인
			dice2(0);
			break;
		}
		case 3: {// M = 3 : 고른 수의 순서는 의미 없음 = 중복조합 -> start 인덱스
			dice3(0, 1); // numbers에 i값을 넣은 것처럼 얘도 start값을 데이터로 하기 때문에 1을 넣어줌
			break;
		}
		case 4: {// M = 4 : 골랐던거 또 고르기 = 중복제거조합
			dice4(0,1);
			break;
		}
		}

		sc.close();
	}
	
	private static void dice4(int depth, int start) { // start = 시작 주사위눈 수

		// 종료조건
		if (depth == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		// ======================================================
		// 공통적인 반복문 -> 무슨 데이터를 뽑을건지 정하는 부분 -> 주사위 눈을 뽑을 것이닷
		for (int i = start; i <= N; i++) {

			// 주사위눈 저장: 순열조합저장변수 = 데이터
			numbers[depth] = i; // i=주사위눈, depth = 현재 횟수 인덱스

			dice3(depth+1, i+1); // i+1로 넘어가게 하면서 i에 대해서 중복 제거됨
		}
		
	}

	private static void dice3(int depth, int start) { // start = 시작 주사위눈 수

		// 종료조건
		if (depth == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		// ======================================================
		// 공통적인 반복문 -> 무슨 데이터를 뽑을건지 정하는 부분 -> 주사위 눈을 뽑을 것이닷
		for (int i = start; i <= N; i++) {

			// 주사위눈 저장: 순열조합저장변수 = 데이터
			numbers[depth] = i; // i=주사위눈, depth = 현재 횟수 인덱스

			dice3(depth+1, i); // i부터 다시 체크하면서 중복이 되도록
		}
		
	}

	private static void dice2(int depth) {

		// 종료조건 -> 원하는만큼 주사위를 던졌다면 (=숫자 조합 완성) -> return
		if (depth == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		// ======================================================
		// 공통적인 반복문 -> 무슨 데이터를 뽑을건지 정하는 부분 -> 주사위 눈을 뽑을 것이닷
		for (int i = 0; i < N; i++) {
			if (isSelected[i] == false) // 중복 체크
			{
				isSelected[i] = true;

				// 주사위눈 저장: 순열조합저장변수 = 데이터
				numbers[depth] = i; // i=주사위눈, depth = 현재 횟수 인덱스

				dice2(depth + 1);

				isSelected[i] = false; // 생성된 순열 숫자의 사용이 끝났다면 원상복구
			}
		}
	}

	private static void dice1(int depth) {

		// 종료조건 -> 원하는만큼 주사위를 던졌다면 (=숫자 조합 완성) -> return
		if (depth == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		// ======================================================
		// 공통적인 반복문 -> 무슨 데이터를 뽑을건지 정하는 부분 -> 주사위 눈을 뽑을 것이닷
		for (int i = 0; i < N; i++) {

			// 주사위눈 저장: 순열조합저장변수 = 데이터
			numbers[depth] = i; // i=주사위눈, depth = 현재 횟수 인덱스

			dice1(depth + 1);
		}
	}

}
