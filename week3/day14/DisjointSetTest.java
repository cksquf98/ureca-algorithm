package DisjointSet;

import java.util.Arrays;

public class DisjointSetTest {
	static int N;
	static int[] parents; //노드의 부모 인덱스 저장
	
	static void make() {//각 집합을 생성
		parents = new int[N];
		
		for(int i=0; i<N; i++) {
			parents[i] = i;
			// parents[i]의 i = 각 노드 식별자
			// 오른쪽 int i값 = 노드의 부모 인덱스
		}
	}
	
	static int find(int a) {//대표자 찾기
		if(parents[a] == a) return a;
		else return find(parents[a]);
	}
	
	static boolean union(int a, int b) {//집합 합치기 (= 대표자 일치시키기)
		
		//대표자가 일치한다면 return false => 합칠 필요 없음을 의미
		//대표자가 불일치한다면 return true => 대표자를 일치시켰음을 의미
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		//합치기 작업 : a집합을 b집합으로 합치기
		parents[aRoot] = bRoot;
		
		//b집합을 a집합으로 합치려면
//		parents[bRoot] = aRoot;
		
		return true;
	}
	
	
	
	public static void main(String[] args) {
		N = 5; 
		
		make(); 	// ==> 0,1,2,3,4 노드가 만들어짐
		
		System.out.println(union(0,1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(1,2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(3,4));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0,2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0,4));
		System.out.println(Arrays.toString(parents));
		
	}
}
