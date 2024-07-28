package tree;

public class BinarySearchTest {

	public static void main(String[] args) {
		int size = 9;
		
		BinarySearch<Character> tree = new BinarySearch<Character>(size);
		
		//'A'부터 9개의 문자를 저장
		for (int i = 0; i < size; i++) {
			tree.add((char)('A'+i));
		}
		
		tree.bfs(); //이진트리에 대한 너비우선탐색
	}

}
