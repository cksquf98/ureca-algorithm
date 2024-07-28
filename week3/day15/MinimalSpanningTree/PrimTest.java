package MinimalSpanningTree;

import java.util.Arrays;
import java.util.Scanner;

public class PrimTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //정점 개수
		int[][] matrix = new int[N][N]; //입력정보 저장(인접 배열) : 가중치값 저장
		
		boolean[] visited = new boolean[N];	
		int[] minEdge = new int[N]; //각 정점에 도달하는 최소 가중치를 저장
		
		
		
		//데이터 입력
		for (int i=0; i<N; i++) {
			for(int j=0; j<N;j++) {
				matrix[i][j] = sc.nextInt(); //가중치 저장
			}
		}
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		
		int minVertex, min, result = 0;
		minEdge[0] = 0; //임의의 시작점 비용 0 세팅
		
		
		for(int c=0; c<N; c++) {//모든 정점 수만큼 반복
			min = Integer.MAX_VALUE;
			minVertex = 0;
			
			
			for(int i=0; i<N; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i; //최소 비용을 가지는 정점을 기준으로 바꾸기-
				}
			} //최소 비용을 갖는 간선을 찾았다면 
			
			System.out.println("minEdge: "+Arrays.toString(minEdge));
			
			result += min;
			visited[minVertex] = true; //최소 비용을 갖는 정점을 방문 체크
			
			//최소 비용 정점의 인접노드
			for(int i=0; i<N; i++) {
				if(!visited[i] && matrix[minVertex][i] != 0 &&
						minEdge[i] > matrix[minVertex][i]) {
					
					//기존의 최소비용보다 작은 값이 발견되면 최소 비용으로 갱신
					minEdge[i] = matrix[minVertex][i];
					
				}
			}
			System.out.println(+minVertex+"번 노드 기준 >>>>>"+Arrays.toString(minEdge));
		}
		System.out.println(result);
		
		
		sc.close();
	}
}
