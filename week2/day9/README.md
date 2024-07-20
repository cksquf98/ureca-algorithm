# Day9
### 재귀 호출

- 주어진 문제의 해를 구하기 위해 동일한 함수 호출을 통해  더 작은 문제의 해를 이용하는 방법
- **중첩된 for문**을 재귀함수로 간결하게 표현
    - 재귀함수 = 기본 부분 + 유도 부분
    - 기본 부분: 호출의 끝 (return)  == 반복문 종료 조건
    - 유도 부분: 공통적으로 처리하고 싶은 반복 구조
- 순열과 조합 알고리즘에서 주로 사용됨

- 코드

```java
재귀함수 - 1차원 배열 출력
-----------------------------------------------------------------------------------

기본부분 = 반복 기저 조건(끝나는 조건) : 0부터 arr.length보다 작을때까지 반복
for(int  i=0; i < arr.length; i++)

유도부분 = 실행 문장(서비스핵심코드) : 출력
println(arr[i])

재귀함수호출
//recursive(++i); 일반적으로 사용하지 않음 -> 
//i = i+1을 의미하므로 i값이 저장되어서 전체 프로그램에 영향을 줌 recursive(i+1); 
recursive(i+1);
```

```java
N = [1,2,3,4,5,6,7,8]

def printArr_ascending(index):
    if(index == len(N)):
        return
    
    print(N[index])
    printArr_ascending(index+1)
    

def printArr_descending(index):
    if(index == len(N)):
        return

    printArr_descending(index+1)
    print(N[index])

printArr_ascending(0)
print("==================================")
printArr_descending(0)
```

---

### 완전탐색

- 모든 경우의 수를 나열하고 확인하여 해답 도출
- 경우의 수가 작을 때 유용함
    - 경우의 수 도출 ⇒ 순열, 조합, 부분집합
- 해답을 찾지 못할 확률이 낮다
- 우선 완전탐색으로 접근해서 해답을 도출한 후, 다른 알고리즘 사용해서 최적화하기


- Baby-Gin
    - 배열 정렬 → run / triplet 검사하면 되지 않을까? (X) : {1,2,3,1,2,3} 정렬해버리면 run+run인데  {1,1,2,2,3,3} 베이비진 체크가 안됨
    - 나올 수 있는 모든 카드 조합 경우의 수를 만들어두기
        
        → 3개씩 끊어가면서 run, triplet 체크 
        
        → BabyGin 체크
        

- 실습

```java
1. 순열 생성 함수
2. Run 체크 함수 : 연속된 세개의 수
3. Triplet 체크 함수 : 동일한 세개의 수
4. BabyGin 체크 함수 : Run & Triplet 만족하는지 체크
```

*** 파이썬 숫자 자리 분리

```python
#입력 : 123456
cards_number = input().rstrip()
cards = list(map(int, cards_number))
```

---

### 순열 (nPr) - 핵심 : 체크리스트 유무 + 원상복구

- **의미있는 순서**의 나열
- 서로 다른 n개 중 r개를 뽑아서 나열하는 것
- nPr = n * n-1 * n-2 * … * n-r+1
- nPn = 다 뽑는거 = n!
- 다수의 알고리즘 문제들은 순서화된 요소들의 집합에서 최선의 방법을 찾는 것 (ex. TSP)

```java
{1,2,3}을 포함하는 모든 순열
-------------------------------
1. 반복문을 통한 순열 생성
-------------------------------

for i <- 1~3
	for j <- 1~3
		if( j != i )
			for k <- 1~3
				if(k != i and k != j)
					i,j,k 순열 출력 
					
(--> for문 개수 = 뽑을 요소 개수)
(--> if문 없애면 중복 순열)

-------------------------------
2. 재귀 호출을 통한 순열 생성
-------------------------------

순열 저장 배열 : numbers[]
현재 for문에서 사용중인지 체크하는 배열 : isSelected[]
int count : 뽑은 순열 요소 개수

P(int count):
	if( count == 3 ) --> return
	
	for i <- 1~3
		if(isSelected[i]) continue
		else
			numbers[count] = i //순열 요소로 pick
			isSelected[i] = true
			P(count+1)
			isSelected[i] = false
```
- 노션 파일 참고

  
---

### 조합 (nCr) - 핵심 : start 인덱스 !

- 순서 의미 없는 순열
- [0, 1]과 [1, 0] → 같은 경우의 수 중복으로 봄
- 노션 파일 참고

---

### 부분집합 - 체크리스트

- 노션 파일 참고
- 집합 내 원소를 for문에서 선택했는지 안했는지 여부가 중요
- 2 ^ (요소의  수) = 부분 집합의 수 <br>
    -> boolean 배열로 관리
- 비트연산으로 부분집합을 표현할 수 있다는 점**
> 1 = 부분집합 포함
> 0 = 부분집함 미포함

---

### 알고리즘 문제 - 순열

- https://www.acmicpc.net/problem/15649 - **N과 M (1)** ✅
    - 중복 없는 순열
    - 입출력을 버퍼에 모아서 저장하고 입출력하는게 더 빠름
    - 그냥 일일이 print하는 것이 아니라 결과값을 모아서 한 번에 출력하도록 해야함
    - 파이썬은 훨씬 쉬움
    
    ```python
    import sys
    input = sys.stdin.readline
    
    def P(index):
        if(index == r):
            for l in range(len(result)):
                print(result[l], end=' ')
            print()
            return
        for i in range(n):
            if(checklist[i] == False):
    
                result[index] = number[i] #첨 뽑은 애를 result r자리에 저장
                checklist[i] = True
                
                P(index+1)
                #체크리스트 원상복귀
                checklist[i] = False
    
    #수열 : nPr -> n개의 수 중에서 r만큼 뽑는다
    n, r = map(int, input().split())
    number = [i for i in range(1,n+1)]
    
    #중복없는 수열 -> 체크리스트 필요
    checklist = [False]*n
    
    #r개 뽑은 결과리스트
    result = [0] * r
    
    P(0)
    ```
    

- https://www.acmicpc.net/problem/15651 - **N과 M (3)** ✅
    - 중복 허용 순열
    
    ```python
    import sys
    input = sys.stdin.readline
    
    def P(depth):
        #종료조건
        if(depth == r):
            for i in range(len(result)):
                print(result[i], end=' ')
            print()
            return
    
        for i in range(n):
            result[depth] = number[i]
            P(depth+1)
    
    n,r = map(int, input().split())
    
    number = [i for i in range(1,n+1)] #체크리스트 필요 없음!!
    result = [0] * r
    P(0)
    ```
    
- https://www.acmicpc.net/problem/14888 - **연산자 끼워넣기** ❌
    - 우씨.. 검색함
    
    ```python
    import sys
    input = sys.stdin.readline
    
    N = int(input())
    number = list(map(int, input().split()))
    
    add,minus,multi,div = map(int, input().split())
    
    result = []
    
    def operator(add, minus, multi, div, total, numberIndex):
        if(add == 0 and minus == 0 and multi == 0 and div == 0):
            result.append(total)
            return
        
        if(add > 0):
            # total += number[numberIndex]이케 해버리면 total값이 아예 저장이 되어버려서 이상하게 변경됨
            operator(add-1, minus, multi, div, total+number[numberIndex], numberIndex+1)
        
        if(minus > 0):
            operator(add, minus-1, multi, div, total-number[numberIndex], numberIndex+1)
    
        if(multi > 0):
            operator(add, minus, multi-1, div, total*number[numberIndex], numberIndex+1)
        
        if(div > 0):
            #total이 음수면 (-total)/num
            if(total < 0):
                operator(add, minus, multi, div-1, -((-total)//number[numberIndex]), numberIndex+1)
            else:
                operator(add, minus, multi, div-1, total//number[numberIndex], numberIndex+1)
    
    #첫번째 원소를 total에 넣고 시작
    operator(add, minus, multi, div, number[0], 1)
    
    #최댓값 최솟값 출력
    # print(result)
    print(max(result))
    print(min(result))
    ```
