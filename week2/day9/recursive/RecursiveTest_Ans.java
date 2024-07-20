package recursive;

public class RecursiveTest_Ans {

public class RecursiveTest {
		static int[] arr = {10, 20, 30};
		
		static void recursive(int i) {
			//기저 조건
			if(i >= arr.length) return;
			System.out.println(arr[i]);	//유도부분
			//recursive(++i); 일반적으로 사용하지 않음 -> 
			//i = i+1을 의미하므로 i값이 저장되어서 전체 프로그램에 영향을 줌 
			recursive(i+1); 
		}

		public static void main(String[] args) {
			recursive(arr.length);
		}
	}
}