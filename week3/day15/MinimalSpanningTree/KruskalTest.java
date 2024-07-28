package MinimalSpanningTree;

import java.util.Arrays;
import java.util.Scanner;

public class KruskalTest {

	static class Edge implements Comparable<Edge> {// 간선에 연결된 두 정점과 가중치를 저장
		int start;
		int end;
		int weight;

		Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Edge [start=");
			builder.append(start);
			builder.append(", end=");
			builder.append(end);
			builder.append(", weight=");
			builder.append(weight);
			builder.append("]");
			return builder.toString();
		}

		@Override
		public int compareTo(Edge o) {

			return this.weight - o.weight; // 오름차순
		}
	}

	static int V; // 정점 수
	static int E; // 간선 수
	static int[] parents;
	static Edge[] edgeList;

	public static void main(String[] args) {
		// 입력값 첫 행: 노드수, 간선정보 수
		// 입력값 두번째행 이후 : 노드1, 노드2, 가중치
		// 출력값 : 최소 스패닝 트리를 구성하고 그 트리의 가중치 합을 구하시오

		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();

		// 부모(대표자) 인덱스 저장 배열
		parents = new int[V];

		// 간선 정보 저장 배열
		edgeList = new Edge[E];

		// 데이터 입력
		for (int i = 0; i < E; i++) {
			edgeList[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

		// 각 정점의 집합 만들기
		make();

		// 최소신장트리의 가중치 합 구하기
		// 가중치 sorting
		Arrays.sort(edgeList);

		int sum = 0;
		int countEdge = 0;
		for (Edge edge : edgeList) {
			// 사이클 체크
			if (union(edge.start, edge.end)) {// 사이클이 발생하지 않는다면
				sum += edge.weight;
				// 최소 신장 트리를 만족하는 간선(V - 1개)을 전부 찾았다면 break
				if (++countEdge == V - 1) break;
			}
		}

		sc.close();
	}

	static void make() {// 각 집합을 생성

		for (int i = 0; i < V; i++) {
			parents[i] = i;
			// parents[i]의 i = 각 노드 식별자
			// 오른쪽 int i값 = 노드의 부모 인덱스
		}
	}

	static int find(int a) {// 대표자 찾기
		if (parents[a] == a)
			return a;
		else
			return find(parents[a]);
	}

	static boolean union(int a, int b) {// 집합 합치기 (= 대표자 일치시키기)

		// 대표자가 일치한다면 return false => 합칠 필요 없음을 의미
		// 대표자가 불일치한다면 return true => 대표자를 일치시켰음을 의미
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		// 합치기 작업
		parents[bRoot] = aRoot;

		return true;
	}

}
