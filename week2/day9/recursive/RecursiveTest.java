package recursive;

public class RecursiveTest {
	static int[] arr = {10, 20, 30};
	
	static int printArray(int index) {
		if(index > 0)
		{
			printArray(index-1);
		}
		else
		{
			System.out.println(arr[index]);
		}
		return index+1;	
	}

	public static void main(String[] args) {
		printArray(arr.length);
	}

}
