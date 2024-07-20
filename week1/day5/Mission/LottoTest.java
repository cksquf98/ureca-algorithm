package com.ureca.Mission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
 <<행운의 로또번호 생성기>>
1. 서로 겹치지 않는 (중복되지 않는) 숫자 6개 생성
2. 각 숫자는 1~45 범위내의 숫자
3. 매번 실행시 다른 숫자 출력
   ---> 랜덤수 : java.util.Random클래스 - nextInt(int bound)사용
4. 다섯회 출력
5. 각 번호는 오름차순 정렬
   ---> java.util.Arrays클래스의 sort()메소드 사용.
=> LottoTest.java
출력형태)
  ★★ 금주 행운의 로또번호 ★★
 1회: 2, 12, 15, 34, 36, 42
 2회: 1, 2, 9, 33, 42, 45
 3회: 9, 12, 14, 19, 34, 40
 4회: 5, 10, 15, 18, 19, 22
 5회: 7, 9, 15, 19, 39, 41
*/

public class LottoTest {

	public static void main(String[] args) {

		Random random = new Random();
		
		ArrayList<int[]> week = new ArrayList<>();

		int index = 0;
		while (index < 5) {
			int[] lottoNum = new int[6];
			
			
			// 중복없는 번호 추출
			for (int i = 0; i < 6; i++) {
				boolean flag = true;
				
				int num = random.nextInt(45) + 1;

				for (int j = 0; j < i; j++) {
					if (lottoNum[j] == num) {
						i-=1;
						flag = false;
						break;
					}
				}

				if (flag)
					lottoNum[i] = num;
			}
			Arrays.sort(lottoNum);
			week.add(lottoNum);
			index++;
		}
		
		
		int i = 0;
		//출력
		for (int[] w : week) {
			i++;
			System.out.println(i + "회 " + Arrays.toString(w));
		}
	}
}
