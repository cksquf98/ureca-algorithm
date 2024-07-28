### 이진탐색

- 전제조건: **정렬된 상태**
- 목적 키를 찾을때까지 이진 검색을 반복 수행
- 방법
    
    ![Untitled](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/ab4abf6c-0eaa-40c9-903e-15dc53ff55c0/Untitled.png?id=5d561635-a715-463d-9412-99f64c04f40c&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1722218400000&signature=-HanTqDSjw74a57OAL6VK13Q9MFxZ5mPTNuo7TWl_WM&downloadName=Untitled.png)
    1. 자료 중앙 원소를 선택
    2. 해당 값과 목표값 비교
    3. 일치하면 탐색 끝
    4. 목표값 < 비교값 ⇒ 자료의 왼쪽 반에 대해 새로 탐색 수행
        
        목표값 > 비교값 ⇒ 자료의 오른쪽 반에 대해 새로 탐색 수행
        
        - start, end 인덱스가 계속 변하기 때문에 같이 전달해야함
        - 중앙 원소 mid = (start+end) / 2
    

```java
//찾으려는 key값은 따로 static으로 빼줘도 되긴 함
1.반복문 사용

binarySearch(배열Arr, n, 목표값)
	start = 0
	end = n-1
	
	while(start <= end)
		mid = (start + end) / 2
		if(Arr[mid] == key)
			return mid
		elif (Arr[mid] < key)
			start = mid+1  => 앞부분 버리기
		elif (Arr[mid] > key)
			end = mid - 1  => 뒷부분 버리기
	
	return -1 //못찾음을 의미
			
-------------------------------------------------
2. 재귀 사용

binarySearch(배열Arr, start, end, key)
	//종료조건
	if(start > end)
		return -1
	
	//수행부분	
	else
		mid = (start + end) / 2
		if(Arr[mid] == key)
			return mid
		elif (Arr[mid] < key)
			return Binary(Arr, mid+1, end, key)
		elif (Arr[mid] > key)
			return Binary(Arr, start, mid-1, key)
```

- Arrays 클래스의 이진탐색 메서드 사용 가능
    - ***Arrays.binarySearch(배열, key)***
    - 찾지 못한 경우 음수 반환 → - N
        
        이때 N은 = (해당 값을 삽입할 경우 들어갈 인덱스 자리+1)
        
        <aside>
        💡 arr = { 3, 11, 15 }
        
        Arrays.binarySearch(arr, 1);      ⇒  -1 반환됨 
        = 해당값은 찾지 못했지만 첫번째 자리에 들어갈 수 있다
        
        ```
            Arrays.binarySearch(검색배열, 찾을키값)
            ==> 이진탐색을 통해 키값이 들아갈 위치(인덱스)를 찾는 기능
            ==> 단, 배열은 정렬된 상태를 유지
            ==> 존재하는 데이터가 있다면 데이터 인덱스를 리턴
            ==> 존재하는 데이터가 없다면  (키값보다 큰 최초위치*-1) -1
            ==> 내가 원하는 인덱스 값으로 변환 시키려면 |위에서 구한 절대값| -1
        ```
        
        </aside>
        

---

### 백트래킹

- 모든 가능성은 하나의 트리처럼 구성할 수 있으며. 가지 중 해결책이 있다
    - 순열/조합/완전탐색으로 구현하기엔 경우의 수가 너무 많아짐 ⇒ 보통 ***재귀함수***로 구현
    - 여러 선택지들이 존재하는 상황에서 하나의 가지를 선택 → 새로운 선택지의 집합 생성 → 해답 아니면back → 반복 → 최종 상태에 도달
    - 루트 → 리프까지의 경로는 해답 후보가 되는데, 모든 후보를 검사한다면 매우 비효율적임
- DFS와의 차이점 : 어떤 노드의 유망성을 점검한 후. 유망하지 않다고 결정되면 그 노드의 부모로 되돌아가(=backtracking) 다음 자식노드로 이동
    
    유망하면 쭉쭉 진행
    
    - 유망하지 않을 경우 다시는 이 루트를 가지 않겠다는 flag가 필요함**

- 퀸 배치 문제
백트래킹조건 = 첫번째if문 : 유망하지 않은 노드인 경우 종료 → 가지치기

백준 9663 - N-Queen 🚨🚨🚨 

- https://www.acmicpc.net/problem/9663
- (1 ≤ N < 15) 조건이 있기 때문에 순열 조합은 경우의 수가 넘 많아짐
- 백트래킹DFS함수랑 자리 체크해주는 함수 2개 필요
- **2차원배열 XX → 1차원으로 줄이기**
    - 퀸을 배치할 수 있으면 chesspan[row] = col 상태로 저장
    
     
    
    어려버 gpt한테 틀린거 물어봐서 if문 조건 고쳤음 ㅡ.,ㅡ
    
    [9663.py](https://prod-files-secure.s3.us-west-2.amazonaws.com/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/45048f7d-cec4-485f-b694-e9580290aae7/9663.py)
    
    ```java
    같은 행 / 같은 열 / 대각선은 제외조건
    -------------------------------------------
    퀸 자리 체크하는 1차원 배열 : 
    	해당 배열의 인덱스 = 행
    	해당 행의 원소값   = 열
    ```
    

백준 1182 - 부분수열의 합 ✅

- https://www.acmicpc.net/problem/1182
    
    [1182.py](https://prod-files-secure.s3.us-west-2.amazonaws.com/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/e4458c15-3c43-4dce-9d3a-60de9f752afe/1182.py)
    
    정답이긴 한데 백트래킹 아닌거가튼데
    
    백트랙킹 가지치기 코드 추가 - GPT **
    
    [1182_가지치기_백트래킹.py](https://prod-files-secure.s3.us-west-2.amazonaws.com/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/db12495c-ba63-47ad-b0d2-144ed93101f0/1182_%EA%B0%80%EC%A7%80%EC%B9%98%EA%B8%B0_%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9.py)
    

백준 3109 - 빵집 🚨🚨🚨

- https://www.acmicpc.net/problem/3109
- 흠.. 어렵당 그리디 알고리즘에도 속하넴
    
    [3109_빵집.py](https://prod-files-secure.s3.us-west-2.amazonaws.com/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/1e0bfe3c-74c2-45a4-94c0-0a8eb07ee265/3109_%EB%B9%B5%EC%A7%91.py)
    

파이썬 문자열 한글자씩 리스트에 쪼개기

```java
roadMap = [[char for char in input().rstrip()] for _ in range(R)]
```
