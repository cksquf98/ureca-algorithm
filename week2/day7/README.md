### 이클립스 - module

![- 모듈 생성 시 패키지 생성할 필요 없음](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/502472c7-3515-4215-855c-763bb7b5c4e2/Untitled.png?id=94015084-5383-40f9-b2ef-04731dc07a51&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1721548800000&signature=8egJCa_63w7k1Xmk3kd735j_pm2hAo1lQYD9n0osNXQ&downloadName=Untitled.png)

- 모듈 생성 시 패키지 생성할 필요 없음

![- 워크스페이스 관리 폴더](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/2869a26d-282f-4ac7-b13f-50adddfed96e/Untitled.png?id=9281f4bf-0bc6-4c70-99b0-216cdf0ac7ff&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1721548800000&signature=ULQkcTtMbV1hMH4hCWQQLZ0fMCBtxb9QmJGXNk7Aoik&downloadName=Untitled.png)

- 워크스페이스 관리 폴더

---

### import 주의점

```java
import java.util.*;
import java.awt.*;

public class Test {
	public static void main(String[] args) {
	
		List list; <== 에러발생 : Ambiguous
	
		}
	}
```

### 알고리즘 문제

- 입력 일일이 드래그 귀찮으니까 미리 입력 파일 만들어서 추가해도 됨
- 코드 제출할 때는 코드 변경 필요 : SetIn코드 주석처리
1. 프로젝트 바로 하위에 텍스트 파일 추가 (src 하위 아님)
    
    ![추가 후 입력값 복붙 후 저장](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/a80a9376-ce23-4062-bfa9-b09c00ca76cc/Untitled.png?id=27433e96-c29c-4b91-85d4-2d50e56c0e75&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1721548800000&signature=5J-GaLCdNTcc3KttdDtLKFy0lJXBLcbFGCRVRNGXZ10&downloadName=Untitled.png)
    
    추가 후 입력값 복붙 후 저장
    

1. System.setIn( new InputStream(“ “) )
    - 자바 4대 입출력 클래스
        - InputStream
        - OutputStream
        - Reader
        - Writer
    
    ```java
    public static void main(String[] args) throws Exception {
    		
    	System.setIn(new FileInputStream("input.txt"));
    	Scanner sc = new Scanner(System.in);
    	
    	sc.close();
    ```
    

---

### 스택 Stack

- 접시를 쌓듯이 자료를 쌓아 올리는 자료구조
- 선형구조 : 자료간의 관계가 1:1의 관계
- LIFO : Last-In-First-Out
- 마지막에 삽입한 자료를 가장 먼저 POP!

![Untitled](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/4e41991e-0984-4c61-a4ec-fa8791dd275e/Untitled.png?id=a7b048fd-bdf7-457c-a496-444cadcdd9ca&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1721548800000&signature=PzHqkBBIw4i5Qb0KHRlf_zrkd1DJwlssmd7gvL8wna8&downloadName=Untitled.png)
- 메서드
    - push( )
    - **pop( ) : 삭제되는애 리턴!!**
    - peek( )
    - isEmpty( )
    - size( )
    

- 실습코드

```java
	public static void main(String[] args) {

		Stack<String> stack = new Stack<>();

		System.out.println("stack size :" + stack.size() + ", empty : " + stack.isEmpty());
	
		
		//push : 데이터 입력
		stack.push("A");
		stack.push("B");
		stack.push("C");
	
		System.out.println("stack size :" + stack.size() + ", empty : " + stack.isEmpty());
		
		
		
		//pop : 데이터 삭제
		//peek : 데이터 조회
		System.out.println(stack.pop() + " is deleted");
		System.out.println("TOP : " + stack.peek());
		System.out.println("stack size :" + stack.size() + ", empty : " + stack.isEmpty());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
//		System.out.println(stack.pop());  <== EmptyStackException
//		System.out.println(stack.peek());  <== EmptyStackException
	}
```

- pop, peek 메서드는 예외 발생 시 호출한 클래스로 EmptyStackException 던짐
    - 에러메세지 데이터를 던지는 것임 = 함수 종료
    - 조건문으로 필터링해서 사용하기

- [백준 9012](https://www.acmicpc.net/problem/9012)

---

### 큐 Queue - (Interface)

![Untitled](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/ce6ef213-1003-42b7-98e0-9f89154a1c05/Untitled.png?id=4664f8d5-0a20-47f3-87a6-b9a95cd09a26&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1721548800000&signature=XgBUbqS4ttBJRxAw671mdCUAcbtooOH5sQYfOG31_0I&downloadName=Untitled.png)

- 나-중에 너비우선탐색(BFS)에서 또 나옴
- PriorityQueue 등 활용
- 가장 먼저 넣은 데이터를 가장 먼저 Deque!
- FIFO : First-In-First-Out
- 메서드
    - ***offer( )*** : enQueue
    - ***poll( )*** : deQueue
    - isEmpty( )
    - size( )
- Queue는 인터페이스이기 때문에 LinkedList 또는 ***ArrayDeque***로 구현
    
    ![ArrayDeque - 빠르고 좋음! Stack + Queue](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/ed7eeb2f-428f-430d-9ff1-b4fef7be50c6/img1.daumcdn.png?id=bbcd7b06-0b13-446f-ae87-fa9d27386688&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1721548800000&signature=gr7nZGCzD7h0bsK2CJZeUfi304mBG33zk2R2Q7ckpuA&downloadName=img1.daumcdn.png)
    <pre>ArrayDeque - 빠르고 좋음! Stack + Queue
    
    - offerFirst( )
    - offerLast( )
    - pollFirst( )
    - pollLast( )
    </pre><br>
    
- 실습코드

<aside>
💡 <Queue 를 이용한 다시줘 캔디~♬ 시뮬레이션을 해 보자>

1번이 줄을 선다.

1번이  한 개의 캔디를받는다.

========================

1번이 다시 줄을선다.

새로 2번이 들어와 줄을선다.

========================

1번이 두 개의 캔디를 받는다.

1번 다시 줄을 선다.

새로 3번이 들어와 줄을 선다.

========================

2번이 한 개의 캔디를 받는다.

2번이 다시 줄을선다.

새로 4번이 들어와줄을선다.

========================

1번이 세 개의 캔디를 받는다.

1번이 다시 줄을 선다

새로 5번이 들어와 줄을선다.

========================

3번이 한 개의 캔디를 받는다.

 …..

========================

20개의  캔디가 있을때 마지막 것을누가

가져갈까?

</aside>

- 답안 코드
    - 대기자에 대해 [ 대기자의 번호, 지급받을 사탕 개수 ] 정보가 같이 있도록
        
        ![image_720.png](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/267a48d5-ab9f-4ac8-bbf4-a9f6019ab3ab/image_720.png?id=62c9f3b4-99f3-467f-8f7f-993e6fa32e9e&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1721548800000&signature=8YWemWXGqthbv9KjGV3ckmfYbZC3kScRu35aHZP4gcs&downloadName=image_720.png)
        
         ⇒ int[ 2 ] or 클래스  활용할 수 있음 - ( or Map )
        
         ⇒ 둘이 시간 차이 별로 안남 (new연산 써야하는게 동일해서)
        
    - Queue.toString() 오버라이딩 : 큐의 필드 상태를 설명해주는 toString()함수
    
    ```java
    1. int 배열 사용
    
    2. Person 클래스 사용
    ```
    

 ※  배열 주의

```java
	int[] peopleCandy;
	peopleCandy = { 사람 번호, 받을 사탕 수 }  --> 에러: 배열 선언과 동시에 할당되어야 함
	
	int[] peopleCandy;
	peopleCandy = new int[N]  --> O

	int[] peopleCandy;
	peopleCandy = new int[} { 사람 번호, 받을 사탕 수 } --> O
```
