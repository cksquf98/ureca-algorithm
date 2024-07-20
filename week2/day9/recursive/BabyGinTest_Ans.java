package recursive;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class BabyGinTest_Ans {

	static int N=6; //요소 개수
	
	static int[] numbers; //실행 중 입력
	static boolean[] selected;//뽑은 수는 다시 뽑지 않음 => 중복제거
	static int[] ans;     //생성된 순열을 저장
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("babygin.txt"));
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
//		N = numbers.length;
//		N = 6; //베이비진의 전체수 길이
		
		ans = new int[N];
		
	for(int tc=1; tc<=T; tc++) {	
		numbers = new int[N];
		selected = new boolean[N];		
		//"667767"  ==> 문자열String   ==> {'6','6','7','7','6','7'} => {6,6,7,7,6,7}
		char[]data = scan.next()                       .toCharArray();
		
		//'6'==54    '6'-48 : 6     '6'-'0' : 6
		for(int i=0; i<N; i++) {
			numbers[i] = data[i]-'0';
		}
		
		boolean flag = go(0);
		if(flag)
		 System.out.println("Baby-Gin");
		else
		 System.out.println("Not Baby-Gin");
	}//테스트 케이스 for
		
//		System.out.println("===> "+totalCount);
	}//main
	
	//연속된 3개의 수 검사!!    3 4 5
	static boolean run(int[] cards) {
//		if(cards[2] == cards[1]+1 && cards[1] == cards[0]+1) return true;
		return cards[2] == cards[1]+1 && cards[1] == cards[0]+1;
	}
	
	//동일한 3개의 수 검사!!    3 3 3
	static boolean tri(int[] cards) {
		return cards[2] == cards[1] && cards[1] == cards[0];
	}
	
	//전체수가 베이비진을 만족하는지 검사
	static boolean isBabyGin() {
		int[]leftCards = new int[] {ans[0],ans[1],ans[2]}; //좌측 카드
		int[]rightCards = new int[] {ans[3],ans[4],ans[5]}; //우측 카드
		
		return (run(leftCards) || tri(leftCards)) && (run(rightCards) || tri(rightCards));
	}

	//순열을 뽑는 함수
	private static boolean go(int count) {
		if(count == N) { //순열의 조합이 끝났다면
//		   isBabyGin();
//			return true;
			if(isBabyGin()) return true;
		}
		
		for (int i = 0; i < N; i++) {
			if(!selected[i]) {
				selected[i] = true; //선택체크
				ans[count] = numbers[i];
				if(go(count+1)) return true;
				selected[i] = false;//선택 비체크
			}
		}
		return false;
	}
}
