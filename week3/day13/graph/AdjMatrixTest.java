package graph;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class AdjMatrixTest {// 인접행렬(V * V배열) 그래프 구조 저장
	
	static int adjMatrix[][];

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int Vertexs = sc.nextInt();		//정점 개수
		int Edges = sc.nextInt();		//입력되는 간선정보의 개수
		
		adjMatrix = new int[Vertexs][Vertexs];
		
		for (int i = 0; i < Edges; i++) {
			int from = sc.nextInt();	//출발 정점
			int to = sc.nextInt();		//도착 정점
			
			adjMatrix[from][to] = 1;	//방향 그래프
//			adjMatrix[to][from] = 1; 	//무방향 그래프 => 행렬 대칭	
//			adjMatrix[from][to] = adjMatrix[to][from] = 1;	
			
			
		}
		
		print();
		sc.close();
	
	}

	
	//저장 데이터 확인
	private static void print() {
		
//		System.out.println(Arrays.toString(adjMatrix)); Arrays.toString() : 1차원 배열만
		
		//요소 하나씩 꺼내서 출력
		for (int i=0; i<adjMatrix.length; i++) {
			System.out.println(Arrays.toString(adjMatrix[i]));
		}
		
		System.out.println("\n=========================\n");
		
		for (int[] element : adjMatrix) {
			System.out.println(Arrays.toString(element));
		}
	}

}
