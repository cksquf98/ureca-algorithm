package com.ureca.Mission;

import java.util.Arrays;
import java.util.Random;

public class Answer1 {

	static int[] lotto = new int[6];// [0]번지~[5]번지 생성

	public static boolean isDuplicateNum(int index) {// 중복된 수가 발생한다면 리턴 true
		for (int i = index - 1; i >= 0; i--) {
			if (lotto[index] == lotto[i])
				return true;
		}
		return false;
	} //근데 애초에 중복되지 않도록 만들면 이 함수는 필요없는뎅. => Answer2,3 참고

	
	
	
	
	public static void main(String[] args) {

		Random r = new Random(); // r.nextDouble(); ==> Math.random()과 동일한 메서드
		
		System.out.println("★★ 금주 행운의 로또번호 ★★");
		
		for (int no = 1; no <= 5; no++) {
			for (int i = 0; i < lotto.length; i++) {
				
				lotto[i] = r.nextInt(45) + 1; // 0~44 +1 ==> 1~45
				
				if (isDuplicateNum(i))
					i--;
			}

			Arrays.sort(lotto);
			
			System.out.print(no + "회: ");
			
			for (int i = 0; i < lotto.length; i++) {
				System.out.print(lotto[i]);
				
				if (i < lotto.length - 1)
					System.out.print(", ");
			}
			System.out.println();
		}
	}
}
