### 서로소 집합

- 서로 교집합이 없는 집합들
- 대표자를 통해 각 집합들을 구분
    - 대표자 : 집합에 속한 하나의 특정 멤버

- 서로소 집합 연산
    - Make-Set(x) : x를 대표자로 하는 하나의 집합 생성
    
    ```java
    static void make() {//각 집합을 생성
    		parents = new int[N];  //노드의 부모 인덱스 저장
    		
    		for(int i=0; i<N; i++) {
    			parents[i] = i;
    			// parents[i]의 i = 각 노드 식별자
    			// 오른쪽 int i값 = 노드의 부모 인덱스
    		}
    	}
    ```
    
    - Find-Set(x) : 해당 집합의 대표자를 리턴
    
    ```java
    static int find(int a) {//대표자 찾기
    		if(parents[a] != a)
    			parents[a] = find(parents[a]);   // x의 대표자를 재귀적으로 찾아서 리턴
    			return parents[a]
    		}
    }         
    ```
    
    - Union(x, y) : 대표자가 같으면 같은 집합이니까 pass, 대표자가 다르면 x,y집합을 합치는 연산
    
    ```java
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
    ```
    

![Untitled](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/e6187bc4-9467-4672-941c-951b9f913a3f/Untitled.png?id=08cc47ce-77c6-41a6-921b-08cd9ee7a2f9&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1722225600000&signature=Fxt8DBzneSWmTm1cLUuG3q8HLfDaMr9mK1op6xGyKJk&downloadName=Untitled.png)
- 같은 집합의 원소들은 하나의 연결리스트로 관리함.
- 맨 앞 원소 = 대표원소 = 트리의 루트
- 각 원소는 대표자를 가리키는 포인터를 가짐

- 서로소 집합의 원소들을 트리로 표현할 수 있음

![Untitled](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/eacef229-3b17-42cb-87a6-2706c321bf0d/Untitled.png?id=0b7e8aa3-2384-4413-95d1-9cbeac942afc&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1722225600000&signature=rBXfzOxDWF9_Vv70fbAubHOoWIDwJe1WquLtoWhKTFA&downloadName=Untitled.png)
### 최소신장트리(Minimum Spanning Tree)

- 그래프에서의 최소 비용 문제 : 모든 정점을 연결하는 간선들의 가중치의 합이 최소가 되는 트리
- 최소 신장 트리 : ***n-1개의 간선***으로 이루어진 트리 + ***사이클이 없어야 함***

1. **Kruskal 알고리즘 →** *Union*
    - 간선을 하나씩 선택해서 MST를 찾는 알고리즘
        
        1> ***모든 간선을 가중치에 따라 오름차순 정렬***
        
        2> 가중치가 가장 낮은 간선부터 선택하면서 트리를 증가시킴 - 사이클이 존재하면 다음으로 가중치가 낮은 간선 선택
        
        3> n-1개의 간선이 선택될때까지 반복
        
    - 사이클을 어떻게 찾지?  ⇒  같은 집합에 속하는지 여부를 판단

```java
Kruskal.java
-------------------------------------------------------------------------------------
Node class 생성
static class Edge implements Comparable**<Edge>** {// 간선에 연결된 두 정점과 가중치를 저장
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
			return **this.weight - o.weight**; //오름차순 정렬
		}
	}
	
	
-------------------------------------------------------------------------------------

1. 각 정점의 집합 만들기

2. 가중치에 따라 정렬

3. 최소 신장 트리를 만족하는 간선 찾고 가중치 합 구하기
	-> 사이클 체크
	
	
	
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
```

1. **Prim 알고리즘 →** *Visited 배열= 사이클 체크*
- 하나의 정점에서 연결된 간선들 중 하나씩 선택하면서  MST를 만들어나감
    
    1> 임의 정점 선택
    
    2> 인접 노드 중 최소비용의 간선을 가지는 정점 선택 → 방문 boolean 배열 체크 ( ⇒ 사이클 체크)
    
    3> 모든 정점이 선택될때까지 반복
    
- 서로소인 2개의 집합 정보를 유지 : 선택된 정점들 ↔ 선택되지 않은 정점들

```java
Prim.java
-------------------------------------------------------------------------------------

1. 초기 세팅:
		임의의 시작점 0 -> minEdge[0] = 0으로 세팅 
		0번 노드 방문 체크

2. 방문하지 않은 정점에서 최소 비용을 가지는 정점 찾기 -> 모든 정점이 다 연결되었으면 MST 완성
		1> 가장먼저 minEdge값들을 Integer.MAX_VALUE로 설정 (최댓값)
		2> 인접 노드의 방문 여부, 가중치 비용 확인해서 minEdge값 갱신
		3> 인접노드 중 최소 비용을 가지는 간선을 가지는 노드 방문 -> 해당 노드 기준으로 2번 반복
				

3. 방문 처리 후 비용 누적

4. for 최소 비용 정점 u의 모든 인접 정점
	-> (u -> v) 비용이 minEdge[v]보다 작다면 갱신
```

---

### 최단 경로 - 다익스트라 알고리즘

- 두 정점사이의 경로들 중 가중치 합이 최소인 경로
- 시작점과 도착점이 정해져있는 경우
    - 시작 정점에서 다른 모든 정점으로의 최단 경로를 구함
- 그리디 알고리즘을 사용한 기법으로 Prim알고리즘과 유사

![Visited 체크리스트, 인접 노드까지 가는데의 최소 간선을 담아둘 배열 필요
D[i] : i 정점까지 가는데 드는 최소 비용
](https://prod-files-secure.s3.us-west-2.amazonaws.com/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/c8aff67e-e70d-4d40-9ec5-933b5a659178/Untitled.png)

Visited 체크리스트, 인접 노드까지 가는데의 최소 간선을 담아둘 배열 필요
D[i] : i 정점까지 가는데 드는 최소 비용

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/c4109b2e-833a-4805-8978-ac28c472dd02/Untitled.png)

- 예를 들어 e정점을 가려고 함
    1. 그냥 a에서는 못가고 인접행렬 보면 d를 통해서 갈 수 있음을 확인
    2. D[d] 값을 보니까 d까지 가는 최단 거리는 9
    3. D[e] = D[d] + 인접행렬[d][e] = 9 + 2 = 11 임을 알 수 있음
    4. D[e] = 11 갱신 
    
          ⇒ 가는 길이 여러가지면 min으로 비교해서 그 중 최단거리로 갱신
    
    [DisjointSetTest.java](https://prod-files-secure.s3.us-west-2.amazonaws.com/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/b33d8242-b068-4bb8-b8fc-cfc5aba15f7e/DisjointSetTest.java)
    
    [KruskalTest.java](https://prod-files-secure.s3.us-west-2.amazonaws.com/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/b5df2286-b34f-46e4-9cc6-48d26991064e/KruskalTest.java)
    
    [PrimTest.java](https://prod-files-secure.s3.us-west-2.amazonaws.com/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/961987a3-49dd-492d-a97d-60a43f862a68/PrimTest.java)
    
    [DijkstraTest.java](https://prod-files-secure.s3.us-west-2.amazonaws.com/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/dd629459-3afa-4e91-a006-22641dc5e1b0/DijkstraTest.java)
    
    백준 1753 - 최단경로 ❌
    
    https://www.acmicpc.net/problem/1753
    

### 쪽지시험 전 정리

---

자바

---

<Switch>

- main 내 break : for / while / do-while / switch
- continue : 반복문에서만 가능 switch에선 XX

<상속>

```java
- Parent p = new Child(); (O)
- Child c = new Child();
- Parent p = c; (O)
- p.자식메서드() -> 에러
- p.기존부모에도있는메서드() -> 자식에 있는 메서드로 호출됨
```

```java
c = new Ureca();
Ureca u = c;  => 이미 메모리에 할당되어있는 Ureca객체를 참조하는 u
new Ureca -> 새로 메모리에 올림
```

<Modifier>

- public int su; (O)
- public static int su (O)
- static public int su (O)
- static int public su (X)

<접근제한자>

- 클래스 앞에는 public or 생략(default)만 가능
- Inner 클래스 : Outer클래스의 멤버이기 때문에 protected, static 모두 쓸 수 있음
    
    ```java
    [public /default] class 클래스명 {
    	class 내부클래스 {    }
    }
    ```
    

<중첩 for문 - 레이블을 사용하여 원하는 위치로 이동하기>
=> flag 변수를 따로 지정할 필요 없게 해줌

```java
ureca: //ureca 레이블
	for( ){
		good: //good레이블
		for( ){
			for(){
					break;         //1번으로 이동
					break good; //2번으로 이동 = good 레이블 for문 벗어나기
					break ureca; //3번으로 이동 = 전체 for문 벗어나기
				}
				==> 1번 위치

		}
		==> 2번 위치

}
==> 3번 위치
```

```java
 ureca: //ureca 레이블
for( ){

	good: //good레이블
	for( ){
 
		 for(){
		    break;         //1번으로 이동
		    break good; //2번으로 이동 = good 레이블 for문 벗어나기

		    if ( 조건 ) continue ureca; //ureca 반복문에 컨티뉴 적용

		  }
			 ==> 1번 위치
			 
	}
	==> 2번 위치

}
==> 3번 위치
```

---

알고리즘

---

<시간복잡도>

- 주어진 문제를 해결하기 위한 연산 횟수
- 1억번의 연산을 1초의 시간으로 간주
1> 빅오메가 : 최선의 경우 연산 횟수
2> 빅세타 : 평균 연산 횟수
3> 빅오 : 최악의 경우 연산 횟수
- 시간복잡도 순서: n! > 2^n > n^2 > n log n > n > log n
    - log n 알고리즘 = 2를 몇번 곱해야 n이 되는지 알려줌 => 이진탐색
    - n^2 알고리즘 = 삽입정렬 등의 이중 for문
    - 2^n 알고리즘 = 부분집합
    - n! 알고리즘 = 순열, 조합
    - n^n 알고리즘 = 중복 허용 순열

<투포인터와 슬라이딩 윈도우의 차이점>

- 슬라이딩 윈도우는 *** 구간 범위가 변하지 않는닷 ***

<스택>			                         <큐>

- LIFO	                                           - FIFO
- push / pop / peek	                   - offer ((ENQUEUE)) / poll ((DEQUEUE)) / peek
- 예시들 **	                                   - 예시들 **

<링크드리스트>

- 데이터가 많아질때마다 포인터도 같이 늘어나니까 오버헤드 가능성 높아짐
- 하지만 데이터 중간에서 삽입 삭제가 빠르다는 이점이 있음 **

<정렬알고리즘>

- 버블정렬 : 끝부터 옆에 애랑 비교해서 swap
- 선택정렬 : 아직 정렬안된 부분에서 최솟값을 찾아서 선택되어있는 자리에 넣기
- 삽입정렬 : 선택한 요소에 대해 그보다 앞쪽의 알맞은 위치에 삽입하는 작업을 반복하여 정렬.
**** 최선의 상황에서 O(n) 시간복잡도를 가짐 ****

==> n^2 알고리즘

- 퀵 정렬 : pivot(기준점)을 설정 -> 기준점 보다 낮으면 좌측, 크면 우측으로 정렬
-> 나눈 부분에 대해 pivot 설정 반복

==> **** 기본 시간복잡도 n log n / 최악의 경우 n^2 ****

분할정복 알고리즘 : 퀵정렬, 이진탐색

Arrays.sort()에서의 정렬은 ***Tim-Sort*** **
