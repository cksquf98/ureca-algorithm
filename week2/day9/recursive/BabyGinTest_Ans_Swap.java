package recursive;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BabyGinTest_Ans_Swap {

	private static int[] numbers;
	private static int N = 6;

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("babygin.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		numbers = new int[N];
		
		for(int t=1; t<=T; ++t) {
			char[] data = sc.next().toCharArray();
			for(int i=0; i<N; ++i) {
				numbers[i] = data[i]-'0';// '5'-'0'
			}
			System.out.println("#"+t+" is "+(go(0)?"IS BABYGIN":"IS NOT BABYGIN"));
		}
	}
	
	public static boolean run(int[] cards) {
		return cards[2]==(cards[1]+1)&&cards[1]==(cards[0]+1);
	}
	public static boolean tri(int[] cards) {
		return cards[0]==cards[1]&&cards[1]==cards[2];
	}
	
	public static boolean isGin() { //순열 받는거..
		int[] cards1 = new int[] {numbers[0],numbers[1],numbers[2]};
		int[] cards2 = new int[] {numbers[3],numbers[4],numbers[5]};
		if( (run(cards1)||tri(cards1)) &&(run(cards2)||tri(cards2)) ){
			return true;
		}
		return false;
	}
	
	private static boolean go(int index) {
		if(index == N) {
//			System.out.println(Arrays.toString(numbers));
			if(isGin()) return true;
		}
		for (int i = index; i < N; i++) {
			swap(index,i);
			if(go(index+1)) {
				return true;
			}
			swap(index,i);
		}
		return false;
	}
	private static void swap(int i,int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	


}
