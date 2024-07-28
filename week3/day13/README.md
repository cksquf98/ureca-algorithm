# Day13
  ### 그래프

= 정점들의 집합 + 간선들의 집합

- 정점: 그래프의 구성요소로 하나의 연결점을 의미 (=노드)
- 간선: 두 정점을 연결하는 선
- 차수: 정점에 연결된 간선의 수

$$
V개의 정점을 가지는 그래프의 최대 간선 = V(V-1) / 2
$$

   → 5개의 정점이 있는 그래프의 최대 간선 수 = 10

- 선형(1:1) or 트리(1:N) 자료구조로 표현하기 어려운 N:N관계를 가지는 원소들을 표현할 수 있음
    - 트리는 그래프로 표현 가능함. 반대는 불가

- 종류
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/5a628009-7e00-4440-8f7a-92dc4515ce95/Untitled.png)
    
    - 무향 그래프 : 정점 간 연결되는 방향 없음 ⇒ 결국 **양방향**이라는 말임
    - 유향 그래프 : 정점 간 연결되는 방향 있음 ⇒ 단방향
    - 가중치 그래프 : 연결된 간선마다 가중치가 다름
    - 사이클 없는 방향 그래프 : 시작 지점으로 되돌아오는 구조
    - 완전 그래프 : 정점들에 대해 가능한 모든 간선을 가진 그래프
    - 부분 그래프
    
- 그래프 정보를 저장하는 방법
    1. 인접행렬
        
        ![무방향 그래프: 인접 행렬이 대각선 대칭 → (1,2)연결 저장 시 (2,1)도 같이 저장
        유향 그래프: 나가는 방향에만 정수를 채움으로써 방향 표현 가능](https://prod-files-secure.s3.us-west-2.amazonaws.com/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/b522c1f9-60de-4fe5-beee-3bef745a5351/Untitled.png)
        
        무방향 그래프: 인접 행렬이 대각선 대칭 → (1,2)연결 저장 시 (2,1)도 같이 저장
        유향 그래프: 나가는 방향에만 정수를 채움으로써 방향 표현 가능
        
        - V * V크기의 2차원 배열을 이용해서 간선 정보를 저장
        
        - 정점 개수가 많아지면 비효율적임 ⇒ 인접 리스트 사용
        
        - 두 정점의 인접 여부를 int로 저장
        
               ex. 인접 여부, 가중치 등 표현 가능
        
        - 연결여부 정보만 필요하면 boolean 배열도 ㄱㅊ
        
    2. 인접리스트
        
        ![정점은 1차원 배열로 표현
        그 정점 배열에 노드를 저장하고, 각 인덱스에 저장된 노드마다 연결된 다른 노드들을 연결해나가면 됨](https://prod-files-secure.s3.us-west-2.amazonaws.com/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/1eceaeec-4356-4c62-864f-d4692f619608/Untitled.png)
        
        정점은 1차원 배열로 표현
        그 정점 배열에 노드를 저장하고, 각 인덱스에 저장된 노드마다 연결된 다른 노드들을 연결해나가면 됨
        
    
    - 각 정점마다 다른 정점으로 나가는 간선 정보를 저장
    
    -연결된 정점이 많아질수록 복잡해짐
    
    1. 간선리스트
        
        - 간선을 객체로 표현해서 리스트로 저장
        
        - 잘 쓰이진 않음
        
    
- 구현 코드
    1. 인접행렬
    
    ```java
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
    ```
    
    1. 인접리스트
    
    ```java
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
    		
    		
    		for(int i=0; i< Vertexs; i++) {
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
    
    --------------------------------------------------------------------------------
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
    ```
    

### 그래프 순회 💫💫💫

1. **BFS**
    
    ***Queue + 방문 체크리스트***
    
    - 탐색 시작점의 인접한 정점들을 먼저 모두 차례로 방문한 후, 방문했던 정점을 시작점으로 다시 인접한 정점들을 차례로 방문
    - 방문했음을 체크해줘야 함
    
    ```java
    BFS(탐색 시작 정점 V)
    	1. Queue 생성
    	
    	2. queue.offer(V)
    	
    	3. V를 방문한걸로 표시 <- boolean 배열
    	
    	4. while(!queue.isEmpty())
    				T <- queue.poll()
    				for(T와 연결된 모든 정점에 대해)
    						방문되지 않은곳이면 큐에 삽입
    						-> 삽입된 인접 노드 : **방문 True 체크**
    ```
    
2. **DFS**
    
    ***Stack(ArrayDeque) or Recursive + 방문 체크리스트***
    
    - 시작 정점의 한 방향으로 쭈욱 깊이 탐색해서 갈 곳이 없게 되면, 이전 갈림길 정점으로 되돌아오고, 다른 정점으로 탐색을 반복
    - 방문했음을 체크해줘야 함
    
    ```java
    DFS(탐색 시작 정점 V, 체크리스트)
    	1. V를 방문한걸로 표시 <- boolean 배열
    	
    	2. for(V와 인접한 모든 정점에 대해)
    			방문되지 않은 곳이면 DFS(인접정점 W, 변경된 체크리스트)
    ```
    

---

### 알고리즘 문제

백준 1260 - DFS와 BFS 에바 파이썬 🔺

- https://www.acmicpc.net/problem/1260

https://ebbnflow.tistory.com/173

[1260.py](https://prod-files-secure.s3.us-west-2.amazonaws.com/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/3f5ca41a-fdc3-41a8-931f-6173e2a09b73/1260.py)

백준 7576 - 토마토 ❌

- https://www.acmicpc.net/problem/7576
- 2차원 배열의 칸을 그래프 정점으로 생각하는 문제 **
- 확산 → BFS → 확산 시작점 찾는 for문을 메인에 두는게 아니라 BFS함수에 둬서 큐에 집어넣어야 했음

백준 1987 - 알파벳 ✅

- https://www.acmicpc.net/problem/1987
- 딕셔너리 키 제거 : 딕셔너리.pop(key)
