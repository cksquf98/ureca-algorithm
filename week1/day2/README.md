### Static

- new 연산자로 객체 선언할 필요 없이 접근 가능함
- 참조 변수 접근XX ⇒ 클래스명으로 접근

```java
public class A {
	
	void Hello() {
		System.out.println("A클래스 안녕");
	}
	
	static void uplus() {
		System.out.println("UPLUS static");
	}
}

----------------------------------------------------
public class MethodCallTest {
	
	static void good() {
		System.out.println("Goooood");
	}
	
	public static void main(String[] args) {
		
		System.out.println("안녕 유플러스");
		
		A a = new A();
		a.Hello(); //클래스 멤버는 참조변수로 접근
		
		
		good();
		A.uplus(); //static멤버는 클래스명으로 접근
	}
}

----------------------------------------------------
출력)
안녕 유플러스
A클래스 안녕
Goooood
UPLUS static

```

---

6/11 수업 -1,2 차원 배열, 배열탐색

### 속성변수 vs. 참조변수

- 속성변수 : 데이터 값(value)을 담는 변수
    - int no = 300; ⇒ no에 정수를 담겠다

- 참조변수 : 데이터 주소를 담는 변수
    - A a = new A();  ⇒ a에 주소를 담겠다

- 차이점 :

<aside>
💡

</aside>

### 배열

- 자료형이 동일한 데이터들에 한개의 변수명을 정의한 자료들의 집합

```
int su1;     -----> 한 개의 정수를 저장하는 변수
int []su2;   -----> 여러개의 정수를 저장하는 배열의 참조변수
```

- 배열 선언시 []는 변수명 앞에 또는 뒤에 붙여도 상관이 없다.
int []su;
int su[];

- 주의
    
    int su1[],su2;   ---> su1은 int배열, su2는 int변수
    int [] su1,su2;  ---> su1,su2 둘다 int배열!!
    

- 선언과 동시에 초기화 가능 : 배열선언과 데이터 초기화하는 부분을 따로 작성할 수 없음!!
    - int [] su;              //배열선언
    su = {1,2,3,4,5};  //배열초기화   (X)
    
- 배열 == 객체
    - 객체는 필드와 메서드를 포함하지만, 자바에서의 배열은 length 필드만 가짐~
    
- 배열 생성
    ![Untitled](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/43457407-f27f-4ba6-9a36-be2b92189fd3/Untitled.png?id=f7cbb528-79a0-450d-9958-7c04551d5da6&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1721548800000&signature=3LwR9GoFEaeMyD7Em34i1r98jde2oezHyOE_sFkPfZU&downloadName=Untitled.png)
    ```
    자료형[] 배열명 = new 자료형[배열크기];
    
      ---> 프로그램 실행 도중 데이터 값을 입력할때(변경할때) 주로 사용.
            ==> 데이터가 정해지지 않고 앞으로 입력받을 데이터들이 저장될 방(공간)만 준비.  
      ---> 배열선언과 데이터 초기화하는 부분을 따로 작성하는 것이 가능.
      ---> 배열크기[]는 반드시 자료형 뒤에 위치해야 함.
      ---> 배열크기에 정수값이 반드시 입력되어야함.
      ---> 각 자료형의 기본값으로 초기화됨
    ```
    

- 배열 출력 : For문 or For Each문 사용 O

- 배열 복사 메서드
    
    1) dest = src.**clone()**
    
    2) **System.*arraycopy**(Object src, int srcPos, Object dest, int destPos, int length)*
    
    *int srcPos(복사 시작할 src의 인덱스)*
    
    *int destPos(복사된거 넣기 시작할 dest의 인덱스)*
    
    3) dest = **Arrays.copyOf**(Object src, int length)
    
        dest = **Arrays.copyOfRange**(Object src, 시작인덱스, 복사할 길이)
    

### 2차원 배열

- 실제 저장은 1차원 배열과 같으나 논리적으로 데이터를 행과 열의 형태로 저장하는 것처럼 표현
- 자료형 [ ][ ] 배열명 = new 자료형 [ 행크기 ] [열크기] ;
    - 행사이즈는 반드시 기술해야 함
    - 가변길이 열 : int [ ][ ] nums = new int [ 3 ] [  ];
    

### JAVA I/O

스트림 : 연속된 바이트의 흐름

- 읽기
    - 바이트 단위 : InputStream
    - 문자 단위 : Reader
    - 메서드 : read()

- 쓰기
    - 바이트 단위 : OutputStream
    - 문자 단위 : Writer
    - 메서드 : write()

### 공백 구분된 문자열 입력받기

- StringTokenizer tokens = new StringTokenizer(문자열, 구분자);
    - StringTokenizer는 단 한 문자의 구분자만 사용할 수 있기 때문에, 구분자 “+-*/=()” 전체가 하나의 구분자가 아니라 각각의 문자가 모두 구분자가 된다.
    (한 문자씩 잘라져서 + - * / = ( )가 각각 구분자가 된다.)
    - 만일 구분자가 두 문자 이상이라면, Scanner나 String 클래스의 split을 사용해야 한다.
    (예 : () → 이렇게 문자 두 개 이상이 붙어서 구분자 역할을 하게 할 경우)

```java
//<Mission>
//:앞쪽_화살표:입력값
//0 1 0 0 1
//1 3 5
//==> 8개의 정수데이터가 두줄에  입력된다.
//이 입력된 값을 arr[ ]배열에 저장하자.

-----------------------------------------------------------------------------------

1.Split함수 사용 -- 비추
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String str = br.readLine();
		
//정규 표현식을 사용하는 split 함수는 실행 시간이 오래 걸림
String[] strArr = str.split(" "); 
		
int[] arr = new int[strArr.length];
		
for (int i = 0; i < strArr.length; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}
		
System.out.println(Arrays.toString(arr));

-----------------------------------------------------------------------------------

2. StringTokenizer 클래스 사용 -- 굿
StringTokenizer tokens = new StringTokenizer(문자열, 구분자);
//tokens = [0,1,0,0,1]
		
//tokens.nextToken() --> 0 pop & token = [1,0,0,1]
for(int i=0; i<5; i++)  or   while(tokens.hasMoreTokens())
{
	System.out.print(tokens.nextToken() + " ");
}
```

### 라인 단위 입력 in JAVA

- 프로그램 실행 도중 필요한 시점에 데이터를 입력받는 것
    
    
- java.lang : 기본 패키지
    
    java.lang.String, java.lang.System 등 현클래스와 동일한 패키지에 있는 클래스 또는 기본 패키지 클래스는 바로 사용 가능 → 이외의 클래스는 import 필요
    

1. System.in.read()
    - 바이트 단위 입력 —> 아스키 코드로 인식
        - ‘0’ → 48
        - ‘a’ → 97
        - ‘A’ → 65
        - enter 키 → 13
    - 예외 처리 필수
    
2. Scanner
    - import java.util.Scanner
    - 짱느림 → 문제 풀 때 비권장
    - close()로 입력객체 반환 필요
    
    <aside>
    💡 Scanner sc = **new** Scanner(System.in);
    
    int num = sc.nextInt();              //정수 입력
    
    String str = sc.next()                  //whiteSpace 구분 문자열 입력
    String str = sc.nextLine();          //Enter 구분 문자열 입력
    
    * System.in : 키보드 입력을 의미함
    * whiteSpace : tab/space/enter 등 한 개 이상 공백의 조합
    
    </aside>
    
3. BufferedReader
    - Scanner보다 두 배 빠른 속도
    
    ![Untitled](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/703bae16-6d46-419a-87ee-44ac8e2f5766/Untitled.png?id=e897620c-c4d4-4d59-9263-58f26bd799a0&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1721548800000&signature=LeQGHDFYjN0kl7znhyHbPMyIfh7ZCIiT6cSheeAaoaw&downloadName=Untitled.png)
    
    - import java.io.BufferedReader
    - 문자열로 입력받아짐 ⇒ 변환 필요
        - **‘숫자’**를 나타내는 문자열 → 정수 변환 : Integer.parseInt(문자열)
        
        <aside>
        💡 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        
        </aside>
        
    
    ### 예외
    
    - 프로그램 실행 중 발생하는 예기치 않은 사건
    - 종류
        - 체크 예외 : 컴파일 시 에러가 발생하는 예외
            
               →  try ~ catch문으로 처리해줘야 함
            
        - 언체크 예외 : 컴파일 시 에러 발생하지 않는 예외
            
               →  개발자 실수 or 사용자 입력데이터 예외 
            
               →  if-else문으로 보통 처리하면 됨
            
    
    ### 예외처리
    
    1. Throw : 예외처리 전가 to **호출하는 메소드**
    2. try ~ catch문 : try문에서 발생할 수 있는 예외들을 catch문에서 잡아서 처리
        
        +finally문 : 무조건 실행
