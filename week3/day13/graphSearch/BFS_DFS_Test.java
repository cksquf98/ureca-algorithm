package graphSearch;

import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BFS_DFS_Test {
	
	static int N;
	static boolean adjMatrix[][];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input2.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	//정점 수
		int C = sc.nextInt();	//간선 수
		
		adjMatrix = new boolean[N][N];
		
		for (int i = 0; i < C; i++) {
			int from = sc.nextInt();	//출발 정점
			int to = sc.nextInt();		//도착 정점
			
			adjMatrix[from][to] = adjMatrix[to][from] = true;	
		
		System.out.println("-------------너비우선탐색---------------");
		BFS();
		
		System.out.println("-------------깊이우선탐색---------------");
		
		DFS(0, new boolean[N]);
	}

}

	
	
	
	private static void DFS(int current, boolean[] visited) {
		visited[current] = true;
		System.out.println((char)(current + 'A'));
		for (int i = 0; i< N; i++) {
			if(adjMatrix[current][i] && !(visited[i]))
				DFS(current, visited);
		}
	}
	
	
	

	private static void BFS() {
		int current = 0;	//시작 정점의 인덱스
		
		
		//1. 큐 생성
		Queue<Integer> queue = new ArrayDeque<>();
		
		//2.큐에 시작 노드 삽입
		queue.offer(current);
		
		//3. 노드 방문 여부를 체크하는 boolean 배열
		boolean visited[] = new boolean[N];
		
		//4. 큐 대기열의 정점 방문 => 큐가 빈 상태일때까지 (==인접 노드가 더이상 없을때까지)
		while(!queue.isEmpty()) {
			
			current = queue.poll();	  //가장 먼저 입력된 정점 뽑아내기(FIFO)
			visited[current] = true;  //해당 노드 방문 처리		
			
			System.out.println((char)(current+'A'));
			
			//5. current와 연결된 인접 정점 i가 방문되지 않은 곳이면 큐에 삽입
			for (int i = 0; i < N; i++) {
				
				if(adjMatrix[current][i] && !(visited[i])) {
					queue.offer(i);
					visited[i] = true;	//방문한 인접 노드들 True 체크
				}
			}
		}
	}
	
	
	
}
