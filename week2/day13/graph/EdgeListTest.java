package graph;

import java.io.FileInputStream;
import java.util.Scanner;

public class EdgeListTest {
	
	static class Edge{
		public int from, to; 	//정점 정보 저장

		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + "]";
		}
		
	}
	
	static int N;
	static Edge[] edgeList;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt(); // 정점수
		int C = scan.nextInt(); // 간선수
		
		edgeList = new Edge[C];
		for(int i=0; i<C; ++i) {
			int from = scan.nextInt();
			int to = scan.nextInt();
			edgeList[i] = new Edge(from,to);
		}
		print();
		scan.close();
	}
	
	private static void print() {
		for (Edge edge : edgeList) {
			System.out.println(edge);
		}
	}
}