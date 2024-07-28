# Day11
<3주차>

- 그리디 알고리즘,분할 정복 알고리즘, 이진 검색
- 인접 행렬, 인접 리스트
- 그래프 탐색 알고리즘, BFS와 DFS
- 최소 신장 트리, 최소 스패닝 트리
- HTML Markup

---

https://cyc1am3n.github.io/2019/04/26/bfs_dfs_with_python.html

### 트리 탐색 방법

![Untitled](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/a0fa8f0c-c122-46ce-b656-2765a2e65aec/Untitled.png?id=8f834ec3-1903-4d86-8cfb-586179b3984f&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1722218400000&signature=e7J6T70ERXxdheOY9lQ9KZuPRK69-IREbMllSoa_x9U&downloadName=Untitled.png)
- DFS (깊이우선탐색) : ***Stack or Recursive***
    - 루트에서 시작해서 한 방향으로 리프노드까지 갔다가 가장 마지막 갈림길 노드로 돌아가서 다른 방향으로 순회
    - 재귀 or Stack으로 구현
    
    ```java
    DFS() - Recursive
    
    1. T 방문
    
    2. for ( T의 모든 자식 노드 U ) {
    		 DFS(U)
    	 }
    	 
    	 
    --------------------------------
    반복문 = for문 개수 = 레벨
    ```
    
- BFS (너비우선탐색) : ***Queue***
    - 루트노드의 자식노드들을 먼저 모두 방문
    - 방문했던 자식 노드들의 자식 노드들을 차례로 방문
    - 같은 레벨의 노드들을 쭉 탐색 → 다음 레벨 쭉
    
    ```java
    BFS()
    
    1. 큐 생성 - LinkedList or ArrayDeque  == 대기열
    
    2. 루트 노드의 배열 인덱스(1)를 큐에 삽입
    
    3. while(!Queue.isEmpty()) {
    		 Queue.poll() <- 큐의 첫번째 원소 T 반환
    		 T 방문
    		 for( T와 연결된 모든 자식 노드 ) { //이진트리면 left, right의 인덱스와 노드 수를 비교하고 넣으면 됨
    			 U <- T의 자식노드
    			 Queue.offer(U)
    	 }
    ```
    
- 실습코드

```java
BinarySearchTree 만들기
-------------------------------------------------------------------------------------
	public void bfs() {
		//1. 큐 생성 = 대기열(FIFO): LinkedList or ArrayDeque
		Queue <Integer> queue = new LinkedList<>();

		//2. 큐에 루트 노드(배열 상에서의 인덱스) 삽입 : 
		queue.offer(1);
		
		
		
		int current;
		
		//3. 반복문: 큐가 비어있으면 끝나게
		while(!queue.isEmpty()) {
			
			//1> Queue.poll()
			current = queue.poll();
			
			//2> 데이터에 대한 처리 = 출력
			System.out.println(nodes[current]);
			
			//3> 자식노드 찾고 큐에 삽입 = 이진트리 : current*2 / current*2 + 1
			if(current*2 <= lastIndex) queue.offer(current*2);
			
			if(current*2+1 <= lastIndex) queue.offer(current*2);
			}
		}
```

---

### 이진트리순회

- **if**(current > lastIndex) **return**; 이 조건을 앞에 꼭 붙여야 인덱스 초과 안함

1. Pre-order Traversal : 부모(나) → Left → Right
2. In-order Traversal : Left → 부모(나) → Right
3. Post-order Traversal : Left → Right → 부모(나)

![image_720.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/d4655bbe-4527-43a4-9b21-58e9974331b0/image_720.png)

---

### 그리디알고리즘

- 일반적으로 머리에 떠오르는 생각을 검증 없이 바로 구현하는 접근 방식
- 여러 경우 중 하나의 선택을 할 때, 그 순간에 최적이라고 생각되는 것을 선택하는 방식
    - 최적화 문제 = 가능한 해들 중 가장 최적(최대 or 최소)의 해를 찾는 문제
- 최종적으로 최적의 선택이라는 보장은 없다
- 선택을 번복하지 않을 것

[탐색 알고리즘](https://www.notion.so/6a5d21eab9724ff19d5bda3aa7d37e65?pvs=21) 

- **문제**

백준 11047 - 동전0 : 동전 화폐가 서로의 배수임 ⇒ 그리디 가능 ✅

https://www.acmicpc.net/problem/11047

백준 2294 - 동전2 ❌

https://www.acmicpc.net/problem/2294

-DP로 풀어야함

백준 2839 - 설탕배달 ✅

https://www.acmicpc.net/problem/2839

백준 1931 - 회의실 배정 ❌

https://www.acmicpc.net/problem/1931

*** 파이썬 정렬 : key 2개

```python
데이터 = sorted(데이터, key = lambda x :(x[0], x[1])) 
```

*** 파이썬 딕셔너리 value 기준 정렬

```python
딕셔너리 = dict(sorted(딕셔너리.items(), key = lambda x: x[1]))
```

[그리디 보충공부중…]

백준11399 - ATM ✅

https://www.acmicpc.net/problem/11399

백준 1541- 잃어버린 괄호 ✅

https://www.acmicpc.net/problem/1541

---

### 분할정복 : Top-Down

- Divide : 문제를 작게 나눔
- Conquer : 나눈 문제를 해결
- Combine : 해결된 해답을 모음

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/049d80ea-5a5d-4dc1-b9f8-d956cca86e5f/Untitled.png)

```python
기본적인 반복 알고리즘
Iterative_power(x,n)
	result = 1
	
	for i in 1 -> n  // n번 반복              ==> O(n)
		result <- result * x
		
		
------------------------------------------------------------
분할정복 알고리즘
Recursive_power(x,n)
	
	if(n == 1):
		return x
		
	if n이 짝수:
		y <- Recursive(x, n/2)
		return y * y
	
	else n이 홀수:
		y <- Recursive_power(x, (n-1)/2)
		return y * y * x
```

분할정복

백준 2630 - 색종이 만들기 🔺

https://www.acmicpc.net/problem/2630
