package 순열조합부분집합;

import java.util.Arrays;


public class Combination {
	
	static int N, R, totalCount;
	static int[] numbers = {3,5,7,8,9},ans;
	
	public static void main(String[] args) {
		N = numbers.length;
		R = 3;
		ans = new int[R];
		combination(0,0);
		System.out.println("===> "+totalCount);
	}

	private static void combination(int index,int cnt) {
		//cnt : 시작 인덱스의 의미
		if(cnt == R) {
			totalCount++;
			System.out.println(Arrays.toString(ans));
			return;
		}
		for (int i = index; i < N; i++) {
			ans[cnt] = numbers[i];
			combination(i+1, cnt+1);
		}
	}
}
