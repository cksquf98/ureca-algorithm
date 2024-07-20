package recursive;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class BabyGinTest {
	static int N = 6; // 뽑을 요소의 개수
	static int[] number;
	static boolean[] selected; // 중복 제거를 위한 배열
	static int[] sy; // 순열 저장할 곳

	
	public static void main(String[] args) throws Exception {
		// 생성된 순열 저장할 배열
		sy = new int[N];

		System.setIn(new FileInputStream("babygin.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine(); // 개행 문자 소진

		for (int i = 0; i < T; i++) {
			// 입력값 저장할 배열
			number = new int[N];
			selected = new boolean[N];
			
			String num = sc.nextLine().trim();
			
			//"667766" -> {'6','6','7','7','6','6'} -> {6,6,7,7,6,6}
//			char[] charArr = num.toCharArray();
			for (int j = 0; j < num.length(); j++) {
				number[j] = (num.charAt(j)) -'0'; //--> error 왜지
//				number[j] = charArr[j] - '0';
			}
			
			// 순열로 모든 경우의 수 생성
			boolean flag = sunyeol(0);

			if (flag)
				System.out.println("BabyGin");
			else
				System.out.println("Not BabyGin");
		}

//		sc.close();
	}
	
	
	
	// 순열 생성 함수
	static boolean sunyeol(int pickCount) { // pickCount는 뽑은 횟수이자 뽑을 요소가 저장될 배열의 인덱스이기도 함
		
		// 끝날 조건: 순열 조합 끝
		if (pickCount == N) {
			if (isBabyGin())
				return true;
		}

		// 수행 부분
		for (int i = 0; i < N; i++) {
			if (!selected[i]) {
				selected[i] = true;
				sy[pickCount] = number[i];

				if (sunyeol(pickCount + 1))
					return true;

				selected[i] = false;
			}
		}

		return false;
	}

	// 연속되는 3개의 수인지 검사 <- 3개의 수만 전달되면 됨
	static boolean runCheck(int[] sy) {

		/*
		 * sy[2] == sy[1] + 1 && sy[3] == sy[2] + 1 동시에 만족하면 연속되는 수임
		 */

		return (sy[1] == sy[0] + 1 && sy[2] == sy[1] + 1);

	}

	// 동일한 3개의 수인지 검사 <- 얘도 3개의 수만 전달되면 됨
	static boolean tripletCheck(int[] sy) {
		return (sy[2] == sy[1] && sy[0] == sy[1]);
	}

	static boolean isBabyGin() {
		int[] leftCards = new int[] { sy[0], sy[1], sy[2] }; // 좌측 카드 절반
		int[] rightCards = new int[] { sy[3], sy[4], sy[5] }; // 우측 카드 절반

		/*
		 * 1. runCheck(leftCards); -> triplet(leftCards) 체크해서 둘중 하나라도 true인지 2.
		 * runCheck(rightCards); -> triplet(rightCards) 체크해서 둘중 하나라도 true인지 1 && 2 ==
		 * true이면 베이비진
		 */

		return (runCheck(leftCards) || tripletCheck(leftCards) && (runCheck(rightCards) || tripletCheck(rightCards)));
	}

	
}
