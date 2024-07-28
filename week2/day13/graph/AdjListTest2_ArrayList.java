package graph;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdjListTest2_ArrayList {// 인접리스트 그래프 구조 저장
	
	static ArrayList<Integer>[] adjList; //각 인덱스에 저장된 노드에 대해, 그 노드와 연결된 노드들의 정보를 저장
	static int Vertexs;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		Vertexs = sc.nextInt();			//정점 개수
		int Edges = sc.nextInt();		//입력되는 간선정보의 개수
		
		//ArrayList를 담아두는 배열
		adjList = new ArrayList[Vertexs];
		
		
		
		//배열 각 번지에 List바구니 생성
		//각각의 List바구니엔 배열 인덱스에 인접한 노드(정점)의 번호가 저장됨
		for (int i=0; i<adjList.length; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		
		
		for(int i=0; i< Edges; i++) {
			
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			adjList[from].add(to);		//방향 그래프 
			adjList[to].add(from);	//무방향 그래프
			
		}
		
		print();
		sc.close();
	
	}

	
	//저장 데이터 확인
	private static void print() {
		
		//요소 하나씩 꺼내서 출력
		for (int i=0; i < adjList.length; i++ ) {
			System.out.println(i + " : " + adjList[i]);
		}
	}

}
