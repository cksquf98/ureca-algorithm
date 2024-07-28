package graph;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Node {//현재 정점과, 현재 정점에 연결된 다른 정점의 정보를 표현하는 객체
	int vertex;
	Node next;
	
	public Node(int vertex, Node next) {
		this.vertex = vertex;
		this.next = next;	//null or Node를 통해 없음 있음이 표현됨
	}

	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [vertex=");
		builder.append(vertex);
		builder.append(", next=");
		builder.append(next);
		builder.append("]");
		return builder.toString();
	}
}

public class AdjListTest {// 인접리스트 그래프 구조 저장
	
	static Node[] adjList; //각 인덱스에 저장된 노드에 대해, 그 노드와 연결된 노드들의 정보를 저장
	static int Vertexs;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		Vertexs = sc.nextInt();			//정점 개수
		int Edges = sc.nextInt();		//입력되는 간선정보의 개수
		
		adjList = new Node[Vertexs];
		
		
		for(int i=0; i< Edges; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from] = new Node(to, adjList[from]);	//방향 그래프, 
			//Node(to, adjList[from]) => 기존 링크드리스트 앞에 삽입되네 next에 이전 노드를 저장
			
			adjList[to] = new Node(from, adjList[to]);		//무방향 그래프
			
		}
		
		print();
		sc.close();
	
	}

	
	//저장 데이터 확인
	private static void print() {
		
		Node head = null;
		
		//요소 하나씩 꺼내서 출력
		for (int i=0; i<Vertexs;i++ ) {
			head = adjList[i]; //i = 정점번호
			
			
			System.out.println(i + " : " + head);
		}
	}

}
