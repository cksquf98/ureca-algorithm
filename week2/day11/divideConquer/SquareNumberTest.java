package divideConquer;

import java.util.Scanner;

public class SquareNumberTest {
	static int callCnt; //재귀호출된 횟수 == 몇번 연산되었는가?

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int n = sc.nextInt();
		
		System.out.println(BasicExp(x,n));
		
		System.out.println("연산횟수 : " + callCnt);
		callCnt = 0;
		
		System.out.println(DivideConquerExp(x, n));
		
		System.out.println("연산횟수 : " + callCnt);
	}

	//정수타입 : byte short int(4) long(8)
	//int : 4byte = 32bit = 2^32 = -21억 ~ 21억
	//곱셈같은 경우엔 long 써주는게 나음
	private static int BasicExp(int x, int n) {
		++callCnt;
		
		if(n == 1) {
			return x;
		}
		
		return x * BasicExp(x, n-1);
	}
	
	private static long DivideConquerExp(int x, int n) {
		++callCnt;
		
		if(n == 1) {
			return x;
		}
		
		long y = DivideConquerExp(x, n/2);
		
		return (n % 2 == 0)? y*y : y*y*x;
	}

}
