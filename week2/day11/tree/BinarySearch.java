package tree;

import java.util.LinkedList;
import java.util.Queue;

//제네릭 => 이 안에서 사용될 수 있는 자료형 명시
public class BinarySearch<T> {

	private Object[] nodes; // 입력 데이터 저장하는 배열
	private int lastIndex; // 마지막 인덱스
	private final int SIZE; // 배열 크기

	// final 변수는 상수이므로 빈드시 초기화해서 사용
	// 1. 선언과 동시에 초기값 설정 2. 생성자에서 초기화 V
	public BinarySearch(int size) {
		SIZE = size;
		nodes = new Object[size + 1]; // 0인덱스 사용 안함(루트 = 1)
	}

	// T 자료형 명시
	public void add(T e) {
		if (isFull()) { // ArrayIndexOutOfBounds Exception을 막기 위함
			System.out.println("포화상태");
			return;
		}

		nodes[++lastIndex] = e;

	}

	public boolean isEmpty() {
		return (lastIndex == 0);
	}

	public boolean isFull() {
		return (lastIndex == SIZE);
	}

	public void bfs() {
		// 1. 큐 생성 = 대기열(FIFO): LinkedList or ArrayDeque
		Queue<Integer> queue = new LinkedList<>();

		// 2. 큐에 루트 노드(배열 상에서의 인덱스) 삽입 :
		queue.offer(1);

		int current;
		// 3. 반복문: 큐가 비어있으면 끝나게
		while (!queue.isEmpty()) {

			// 1> Queue.poll()
			current = queue.poll();

			// 2> 데이터에 대한 처리 = 출력
			System.out.println(nodes[current]);

			// 3> 자식노드 찾고 큐에 삽입 = 이진트리 : current*2 / current*2 + 1
			if (current * 2 <= lastIndex)
				queue.offer(current * 2);

			if (current * 2 + 1 <= lastIndex)
				queue.offer(current * 2);

		}

	}

	public void PreOrder(int current) {
		System.out.print(nodes[current] + " ");
		if (current * 2 <= lastIndex)
			PreOrder(current * 2);
		if (current * 2 + 1 <= lastIndex)
			PreOrder(current * 2 + 1);
	}

	public void InOrder(int current) {
		if (current > lastIndex)
			return;

		InOrder(current * 2); 					// 왼쪽 자식노드 방문처리
		System.out.print(nodes[current] + " "); // 현재 노드 방문처리
		InOrder(current * 2 + 1); 				// 오른쪽 자식노드 방문처리
	}
	
	public void PostOrder(int current){
		if(current > lastIndex) return;
		
		PostOrder(current*2);					// 왼쪽 자식노드 방문처리
		PostOrder(current*2+1);					// 오른쪽 자식노드 방문처리
		System.out.print(nodes[current]+" ");	// 현재 노드 방문처리
		
	}

}
