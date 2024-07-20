package InputOutput;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class PrintSpeedTest {

	public static void main(String[] args) {
		// 출력되는 시간 체크해보기
		long start = System.currentTimeMillis();
		System.out.println("유레카!");
		long end = System.currentTimeMillis();

		System.out.println("1번 걸린시간 : " + (end - start));

		// 출력되는 시간 체크해보기
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			System.out.println("유레카!");
		}
		end = System.currentTimeMillis();

		System.out.println("2번 걸린시간 : " + (end - start)); //0.1초쯤 나오는군

		
		// 출력되는 시간 체크해보기
//		long start = System.currentTimeMillis();
		start = System.nanoTime();
		System.out.println("유레카!");
//		long end = System.currentTimeMillis();
		end = System.nanoTime();
		
//		System.out.println("3번 걸린시간 : " + (end - start));
		
		
		//일일이 프린트하면 시간이 많이 걸림 => BufferedWriter 사용하자
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//String 고정문자열 : 값을 직접 바꾸지 않고 복사본 객체를 가지고 수정등의 연산을 수행 -> 시간 꽤 걸림
		// => StringBuilder
		StringBuilder sb = new StringBuilder();
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			//출력 버퍼에 추가하는 방법 3가지
			sb.append("유레카!\n");
			
			sb.append("유레카!");
			sb.append('\n');
			
			sb.append("유레카!").append('\n'); //개행문자 따로
			
			
		}
		end = System.currentTimeMillis();

		System.out.println("4번 걸린시간 : " + (end - start)); //0.1초쯤 나오는군

		
	}

}
