package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		
		int V = Integer.parseInt(st.nextToken()); //정점 갯수
		st = new StringTokenizer(in.readLine().trim()); //공백 제거
		
		int start = Integer.parseInt(st.nextToken());	//시작점 인덱스
		int end =  Integer.parseInt(st.nextToken()); 	//도착점 인덱스
		
		final int INF = Integer.MAX_VALUE;
		
		int[][] matrix = new int[V][V];
		
		//가중치 입력받기
		for(int i=0; i<V; ++i){
			st = new StringTokenizer(in.readLine().trim(), " ");
			for(int j=0; j<V; ++j){
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] distance = new int[V];	// **** 최소 비용을 저장하는 배열 ****
		boolean[] visited = new boolean[V]; //방문 체크리스트
		Arrays.fill(distance, INF);
		distance[start] = 0; //distance = [0, inf,inf, ..]
		
		int min=0, current=0;
		for(int i=0; i<V; ++i){
			//1단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
			
			current = -1;
			min = INF;
			
			
			for(int j=0; j<V; ++j){
				if(!visited[j] && distance[j] < min){//방문하지 않고 min보다 더 작은 값이라면 갱신
					min = distance[j]; //min = 0 (distance[0])
					current = j;
				}
			}
			if(current == -1) break; // current == -1 : 갈 수 있는 인접 노드가 없을 경우
			
			visited[current] = true; // 선택 정점 방문 처리
			
			if(current == end) break; // 선택 정점이 도착정점이면 탈출.
			
			
			
			//2단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
			for(int c=0; c<V; ++c){
				if(!visited[c] && matrix[current][c] != 0				//matrix[current][c] == 0 : 자기자신
						&&  distance[c] > min+matrix[current][c]){
					distance[c] = min+matrix[current][c];
				}
			}
		}
		System.out.println(Arrays.toString(distance));
		System.out.println(distance[end] != INF ? distance[end] : -1);
		
	}

}