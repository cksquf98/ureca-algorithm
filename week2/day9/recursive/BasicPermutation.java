package recursive;

import java.util.Arrays;

public class BasicPermutation {

	static int N, totalCount;
	static int[] numbers = {3,5,7};
	static boolean[] selected; //중복 제거를 위한 boolean 배열
	static int[] ans; //순열 저장할 곳
	
	public static void main(String[] args) {
		N = numbers.length;
		ans = new int[N];
		selected = new boolean[N];
		go(0);
		System.out.println("===> "+totalCount);
	}

	private static void go(int count) {
		if(count == N) {
			totalCount++;
			System.out.println(Arrays.toString(ans));
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!selected[i]) {
				selected[i] = true;
				ans[count] = numbers[i];
				go(count+1);
				selected[i] = false; //다음 턴에 다시 뽑히도록
			}
		}
	}
}
