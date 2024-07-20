# Day10
### 입출력 시간

- 버퍼에 모아서 한번에 입력을 받거나 한번에 출력하는게 훨 빠름
    - BufferedReader
    - BufferedWriter
- 고정문자열 String 클래스말고 가변문자열 클래스 사용하기
    - StringBuilder : 젤 편함

```java
	public static void main(String[] args) {
		// 출력되는 시간 체크해보기
		long start = System.currentTimeMillis();
		System.out.println("유레카!");
		long end = System.currentTimeMillis();

		System.out.println("1번 걸린시간 : " + (end - start));

		// 출력되는 시간 체크해보기
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			System.out.println("유레카!");
		}
		end = System.currentTimeMillis();

		System.out.println("2번 걸린시간 : " + (end - start)); //0.1초쯤 나오는군

		
		// 출력되는 시간 체크해보기
//		long start = System.currentTimeMillis();
		start = System.nanoTime();
		System.out.println("유레카!");
//		long end = System.currentTimeMillis();
		end = System.nanoTime();
		
//		System.out.println("3번 걸린시간 : " + (end - start));
		
		
		//일일이 프린트하면 시간이 많이 걸림 => BufferedWriter 사용하자
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//String 고정문자열 : 값을 직접 바꾸지 않고 복사본 객체를 가지고 수정등의 연산을 수행 -> 시간 꽤 걸림
		// => StringBuilder
		StringBuilder sb = new StringBuilder();
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			//출력 버퍼에 추가하는 방법 3가지
			sb.append("유레카!\n");
			
			sb.append("유레카!");
			sb.append('\n');
			
			sb.append("유레카!").append('\n'); //개행문자 따로
			
			
		}
		end = System.currentTimeMillis();

		System.out.println("4번 걸린시간 : " + (end - start)); //0.1초쯤 나오는군
	}
}
```

---

### 중복조합

- 같은 수를 또 뽑을 수 있도록 조합
- 중복제거조합에서 int start의 값을 조정하면 중복의 제거를 없애줄 수 있음

```java
	public class Combination {
		static int N, R, totalCount;
		static int[] numbers = {3,5,7,8,9},ans;
	
		public static void main(String[] args) {
			N = numbers.length;
			R = 3;
			ans = new int[R];
			combination(0,0);
			System.out.println("===> "+totalCount);
		}

		private static void combination(int index,int start) {
		//start : 시작 인덱스의 의미 -> ans(뽑은 조합) 배열의 인덱스!
			if(index == R) {
				totalCount++;
				System.out.println(Arrays.toString(ans));
				return;
			}
			
			for (int i = start; i < N; i++) {
				ans[index] = numbers[i];
				combination(index+1, start+1);
			}
	}
```

### 부분집합
- 공집합 포함 부분집합의 수 = 2^n개
- 비트연산자
    - << >> & | ^ ~
    - << N : 왼쪽 shift → 2^N 곱
    - \>> N : 오른쪽 shift → 나누기
    - shift 연산자가 우선순위 더 높음
- & 와 | 비교
    - 10 & 1 << 3 :
        1. 10 = 기준 데이터
        2. 1 << 1 
            
            → 1 << 2 
            
            → 1 << 3 
            
            → ***1 << 4까지 이동하면서 기준데이터에 1이 어디있는지 확인 == 1을 검사!!***
            
    - 10 | 1 << 3:
        1. 10 = 기준 데이터
        2. 1 << 1 
            
            → 1 << 2 
            
            → 1 << 3 
            
            → ***1 << 4까지 이동하면서 기준데이터 자리를 1로 변경 == 1을 입력!!***
            

- 바이너리 카운팅을 통한 사전적 순서 생성
    - 부분집합 생성 방법임
    - Arr배열: [4] [3] [2] [1]  오른쪽 → 왼쪽 순서
        
    
    ![Untitled](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/ca4c7d25-498d-4ba6-8be4-3301e067c4f6/Untitled.png?id=d7f10693-274d-4a7d-b9b2-a566d5173db5&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1721570400000&signature=SglqlqBA0a60pupmLNIYu2JZspfd3yWZHuKRP6c378A&downloadName=Untitled.png)
    - 첫번째 for문 : 0 ~ 0111111
    - 두번째 for문 : 비트가 1이라는게 해당 원소 포함된다는거고 j는 그 포함 여부를 체크하는 비트임**

- 파이썬 부분집합 :
    
    ```python
    from itertools import combinations
    
    # 무조건 M개 뽑힘
    comb_list = combinations(뽑을 리스트, pick_cnt)
    for comb in comb_list:
    	print(comb)
    
    # 최대 N개의 원소를 가지는 부분집합만 추출하고 싶어
    for n in range(N):
    	for comb in combinations(뽑을 리스트, n)
    		print(comb)
    ```
    

### 알고리즘 문제

백준 2798 - 블랙잭 ✅

https://www.acmicpc.net/problem/2798

백준 3040 - 백설공주와 일곱난쟁이 ✅

https://www.acmicpc.net/problem/3040

```python
#아홉 개의 수 중 합이 100이 되는 일곱 개의 수를 찾으시오
from itertools import combinations

import sys
input = sys.stdin.readline

hats = [int(input().rstrip()) for _ in range(9)]
hats_dic = {}
for k in range(9):
    hats_dic[k] = hats[k]

combination_list = list(combinations(hats,7))
ans = []

for combi in combination_list:
    total = 0
    for num in combi:
        total += num
    # print(total)
    if(total == 100):
        ans = combi
        break
    
# print(ans)

for num in ans:
    print(num)
```

백준 15686 - 치킨배달 🔺

https://www.acmicpc.net/problem/15686

```python
import sys
input = sys.stdin.readline

N, M = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]
houses = []
chickenAll = []

#입력받기
for i in range(N):
    for j in range(N):
        if(arr[i][j] == 1):
            houses.append([i,j])
        elif(arr[i][j] == 2):
            chickenAll.append([i,j])

#최소 도시 치킨거리를 구해야 함
def MinDistance():
    min_total_distance = 100000 #최소 도시 치킨거리

    #부분집합 만들기
    c_len = len(chickenAll)
    for i in range(1, 1 << c_len):
        res = []
        for j in range(c_len):
            if(i & (1 << j)):
                res.append(chickenAll[j])
        
        # M개보다 많은 개수의 부분집합은 패스
        if(len(res) != M): continue

        #선택된 치킨집에 대한 치킨거리
        chicken_distance = chickenDistance(res)

        #최소의 도시 치킨거리
        if(min_total_distance > chicken_distance):
            min_total_distance = chicken_distance
    
    return min_total_distance

#집에 대한 치킨거리 계산 함수
def chickenDistance(res):
    chicken_distance = 0

    for house in houses:
        MIN_DISTANCE = 100000  #집에서 더 가까운 치킨집을 저장할 변수
        
        for selectedChicken in res:
            dis = abs(house[0] - selectedChicken[0])\
                    +abs(house[1] - selectedChicken[1])

            if(MIN_DISTANCE > dis):
                MIN_DISTANCE = dis

        chicken_distance += MIN_DISTANCE  #더 가까운 치킨집과의 거리를 총합에 추가
    return chicken_distance

print(MinDistance())
```

백준 2961 - 도영이가 만든 맛있는 음식 ✅

https://www.acmicpc.net/problem/2961

```python
#수정사항 반영
#부분집합 맞는경우 바로 신맛/쓴맛 계산되도록

import sys
input = sys.stdin.readline

N = int(input())

ingredients = []

min_diff = 1000000000

# 재료의 신맛과 쓴맛 입력받기
for _ in range(N):
    S, B = map(int, input().split())
    ingredients.append((S, B))

# 부분집합을 생성하여 신맛과 쓴맛의 차이를 계산하는 함수
def findMin():
    global min_diff
    # 1부터 2^N-1 까지의 수로 부분집합을 표현 (공집합 제외)
    for subset_mask in range(1, 1 << N):
        total_sour = 1
        total_bitter = 0
        for i in range(N):
            if subset_mask & (1 << i):  # i번째 재료가 부분집합에 포함되는 경우
                total_sour *= ingredients[i][0]
                total_bitter += ingredients[i][1]
        min_diff = min(min_diff,abs(total_sour - total_bitter))

# 최소 차이를 찾는 함수 호출
findMin()

# 결과 출력
print(min_diff)
```

---

### 트리

- 비선형구조
- 원소들간 1:N 관계를 가지는 계층형 자료구조
    - 상위 → 하위 노드로 내려가면서 확장되는 트리 모양의 구조
    - ex. html


트리의 크기가 N개일때, 간선은 N-1개

- 최상위노드 = 루트
- 하위 노드 = 서브트리
- 같은 부모를 가지는 노드 = 형제 노드
- 마지막(자식 없는) 노드 = 단말 노드(leaf)
- 자기 부모 노드부터 루트까지 가는데 있는 모든 노드 = 조상 노드
- 노드 개수 = 2^(높이+1)  - 1

- 차수
    - 노드의 Degree : 노드에 연결된 자식 노드 수 = 자식 개수
    - 트리의 Degree : 트리의 노드의 차수중에서 가장 큰 차수 값

- 높이
    - 노드의 높이 : 루트부터 본인까지의 간선 수
    - 트리의 높이 : 루트부터 리프 노드까지의 최대 레벨
        
                                → 루트 노드만 있으면 트리의 높이 = 0
        

---

### 이진트리

- 자식 노드 : 0,1,2개까지만 가능 (left / right node)
- 종류
    - Perfect Binary Tree :  리프를 제외한 노드들의 자식 노드가 2개로 꽉차있는 트리
        - 노드 개수 = 2^n  -1개
    - Full Binary Tree : 리프를 제외한 노드들의 자식 노드가 없거나 모두 2개씩 차있는 트리
    - 완전이진트리(Complete Binary Tree) : 노드 번호 1~n번까지 빈자리가 없는 이진트리
        
                                → 포화 이진트리에서 오른쪽 하단 리프노드부터 착착 없앤 형태 == 완전 이진트리
                                  마지막 리프 노드들이 왼쪽부터 차있으면 됨
        
    
- 배열을 이용한 **이진트리**의 표현
    - 부모 노드 = 본인 인덱스 / 2    ← (정수 나누기)
    - 왼쪽 자식 노드 = 본인 인덱스 * 2
    - 오른쪽 자식 노드 = 본인 인덱스 * 2 + 1
