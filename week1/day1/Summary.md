# Day1
### 자바 설치

1. JDK17 다운로드 (bellsw에서 설치함 for spring 프레임워크)

https://bell-sw.com/pages/downloads/#jdk-17-lts

1. cmd > 자바 버전 체크
- javac -version    ⇒  컴파일 명령어
javac 17.0.11

- java -version      ⇒  인터프리터(실행) 명령어
    
    openjdk version "17.0.11" 2024-04-16 LTS
    OpenJDK Runtime Environment (build 17.0.11+12-LTS)
    OpenJDK 64-Bit Server VM (build 17.0.11+12-LTS, mixed mode, sharing)
    

1. 자바파일 생성

```java
소스코드(HelloTest.java) 작성
     ----> 사람이 읽을 수 있는 파일을 Source File이라고 함.

 public class HelloTest
 {
    public static void main(String args[]) //main함수가 있어야 애플리케이션으로써 실행됨
     {
        System.out.println("안녕, 자바~!!");
     }
 }
```

1. cmd > javac 컴파일하고자 하는 자바파일명(.java확장자 포함)
    - javac HelloTest.java -encoding utf8
        - 메모장에 저장한건 utf-8, cmd에선  x-windows-949로 encoding하기 때문에 -encoding utf8 추가
    - 컴파일
    
2. java 실행하고자 하는 자바파일명(.class확장자 포함하지 않음!!)
    - java HelloTest
    안녕, 자바~!!
    
    ---
    
    ### 이클립스 설치
    
    - 이클립스 - Eclipse IDE for Java Developers 다운로드
        - IDE : 통합 개발 환경
    - ~~STS - 나중에 사용 예정~~
    
    1. eclipse.ini파일 > 메모장으로 열기 > 맨 하단에 -Dfile.encoding=UTF-8 추가 (인코딩 설정)
   ![Untitled](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/d0649d4b-8c3e-4acf-8a8f-d19f1fcea19b/Untitled.png?id=a7dfa749-4b05-498c-a1b0-df40ca8c5100&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1721541600000&signature=2z-y0BTlIssYya1nrRTDip03HkMJQSwYcZYl2AXE3FI&downloadName=Untitled.png)
   
    2. Workspace 설정 후 프로젝트 생성
    ![Untitled](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/8efaedf7-816b-4807-9bc2-d99c6b886bb0/Untitled.png?id=54375534-cdf3-47d1-86b2-1244916a0929&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1721548800000&signature=jMBcuOsXM1U2Wx0DEADQgE73GGdOgIgFFWFCW8syePY&downloadName=Untitled.png)
   
    3. 단축키
        - ctrl + 1 : 제안사항
        - ctrl + space : 자동완성
        - ctrl + / : 주석
        - ctrl + F11 : Run
    
    4. src : 우리가 실행하는 자바 파일 저장됨
        
        bin 폴더에는 그 파일이 컴파일 된 class파일 저장됨
        

---

### 자바

1. 프로그램의 구성요소
    - 필드(field, 변수) : 데이터 속성, 자료구조, 데이터를 담는 **그릇** (2번 이상 사용 시 변수로)
    - 메서드(method, 함수) : 기능, 행위
    - 클래스(class) : 자바프로그램 기본단위(파일)
                           필드와 메서드를 담는 울타리(template)
    
2. 구성요소 구분
    - 변수, 필드 : 첫글자 소문자, 단어뒤에 ( )소괄호가 포함X
    - 메서드 : 첫글자 소문자, 단어뒤에 ( )소괄호가 포함O
    - 클래스 : 첫글자 대문자
        
        System.           out.              println("안녕");
        클래스             필드                 메서드
        

    - 자료형
    
    <aside>
    💡 자료형 정리
    
    문자 - char (2 byte)
    
    ```
    char ch;  //변수 선언: ch변수에 문자데이터를 받겠음
    ch='a'; //변수 초기화(값을 할당)
    ch='가';
    ch='3';
    
    ch='길동'; (X) ---> 작은 따옴표에는 두개 이상의 문자가 올 수 없음!!
    ```
    
    문자열
    
    ```
    String ----> 문자열 (문자의 나열: 0개 이상의 문자를 표현할 때 사용)
    
    	String str;
           str="홍길동"; (O)
           str="홍";    (O)
           str="";      (O)
           str='길';     (X)
    ```
    
    숫자
    
    ```
       - 정수
    	byte (1byte)
      1byte == 8bit == 2의 8승 == 256개
    	(-128 ~ 0 ~ 127)
    		  byte b;
    			b=123;
    			b=127;
    			b=0;
    			b=128; (X)
    			b=-129; (X)
      
      short(2byte)
      
      int  (4byte)  : 가장 많이 사용
         int i = 345;
      
      long (8byte)
    
       - 실수
    	float (4byte)
    	
    	double (8byte) :  많이 사용
         double d = 3.14;
    ```
    
    논리 - boolean (반복문,제어문과 함께 많이 사용)
    (참 또는 거짓을 담는 자료형)
    
    ```
     boolean b1;
    		b1=true; (O)
    		b1=false; (O)
     
     boolean b2;
        b2='true';  (X)
    		b2="false"; (X)
    ```
    
    </aside>
    

1. 구성요소들의 형식
    - 식별자 for 변수명, 메서드명, 클래스명
        - 숫자로 시작 불가
        - 특수문자 사용 불가 (예외 : _ , $)
        - 한글 사용 비권장
        - 예약어 사용 금지 (class, public, …)
    - 기본 자료형(8개) : char, byte, short, int, long, float, double ,boolean
        - 변수에 데이터 값이 저장됨
    - 클래스 자료형 : String, 배열, 사용자 정의 클래스 등등
        - 변수에 해당 데이터를 가리키는 메모리 주소값이 저장됨 (= 참조변수)

- 메서드

```java
형식)

리턴자료형  메서드명 ( 매개변수 )
{//메서드 시작
	    
	 
}//메서드 끝

==> 매개변수의 다른 용어: 인수, 인자, argument, 파라미터(전달 데이터)

------------------------------------------------------------------------------

void 함수1()
{
	   1. 문앞으로 이동;
	   2. 문열기;
	   3. 되돌아오기;
	   //return 생략됨
}

Coffee 함수2()
{
	   1. 자판기앞으로 이동;
	   2. 동전투입;
	   3. 커피버튼클릭;
	   4. 커피를 뽑아서 되돌아오기; 
	   
	   return 커피; //생략불가
}

Cola 함수3 (int coin)
{
	   1. 자판기앞으로 이동;
	   2. 동전투입;
	   3. 콜라버튼클릭;
	   4. 콜라를 뽑아서 되돌아오기; 
	   
	   return 콜라; //생략불가
}

//호출 방식
Cola c = 함수3( 2000 );
```

1. 구성요소 사용법
    - 클래스
        - 한 파일 내 클래스 여러개 정의 가능
        - but 한 클래스만 public class로 선언
        - 멤버 변수는 기본값 존재함 (초기화 안해도 ㄱㅊ음)
            - 로컬 변수는 초기화 필수 ***
    
    ```java
    class 클래스명
    {
       1. 멤버변수(=필드) 선언  //변수 선언 시 초기화하는건 ㄱㅊ은데, 선언된 변수에 수 할당 시 error!
           
       2. 메서드정의
       리턴자료형 메서드명(매개변수 선언)
       {
          1> 지역변수 (!= 필드) 선언
          2> 변수초기화
          3> 메서드호출
          4> 조건문, 반복문     
       }
    }
    
    사용 방법 - [동적할당 vs. 정적할당] 둘 중 하나의 메모리 할당 방식을 사용
    ```
    
    - new 연산자를 통해 객체 생성 후 사용 ← **동적 메모리 할당**
        
        ★ 객체생성식
             A            obj    =        new                   A();
        클래스명  변수명   객체생성키워드    클래스명
        
    - static 정적 클래스로 선언하여 사용  ← **정적 메모리 할당**

1. 자바 에러 구분
    - 컴파일 에러 : 문법 에러 → 애초에 컴파일이 안됨
    - 실행 에러(runtime error) : 프로그램 실행 중 에러 발생

### 연산자

1. 산술 연산자 : + - * /(몫)  %(나머지)
    - 10 / 3 = 3
    - 10 % 3 = 1
    
2. 증감 연산자 : ++ --
    - 변수++ : 후위 연산
    - ++변수 : 전위 연산
    
    ```java
    int s1 = 10;
    int s2 = 10;
    
    System.out.println(s1++); //s값 출력된 후 s1 = s1 + 1 수행 : 10
    
    System.out.println(++s2); //s2 = s2 + 1 수행된 후 출력 : 11
    ```
    
3. 비교 연산자 : > ≥ < ≤ == ≠
    - 결과값이 항상 boolean!
    
4. 논리 연산자 : && (and),   || (or)
    - 결과값이 항상 boolean!
    
    <aside>
    💡 A && B : 모든 조건을 만족했을 때 true
    A || B : 하나라도 만족 시 true
    
    </aside>
    

### 조건문

- 조건(boolean data)에 따라 실행할 문장들을 제어하는 역할
- 반드시 메서드 내에 기술

1. If문
2. If ~ else문
3. switch (수식) ~ case문
    - 수식 : 정수(byte / short / int), 문자(char), 문자열
    - c++에서는 string 스위치문 안됐는데 자바 JDK7 이후부터 된다고 함

### 제어문

1. break문
    - ***switch블럭 또는 loop블럭***에서 사용
    - 빠져나가는 역할
    
2. continue문
    - ***반드시 loop 영역 내***에서 사용
    - loop영역의 끝괄호 역할 → 다음 loop로 넘어가도록 함

### 반복문

1. For문
    - 일정 횟수 반복할 때
    - 규칙적인 수를 표현할 때
    - 배열의 인덱스를 표현할 때
    
    ```java
     for(초기화1;  조건식2;  증감연산자3)
     {   반복적으로 실행될 문장4   }
     
     --------------------------------------
     
     실행 순서)
     초기화1 - 조건식2(true) - 4실행 - 증감연산3
    	    - 2(true) - 4 - 3
    	    - 2(true) - 4 - 3
    	    - 2(true) - 4 - 3
    	    - 2(false) : for문 탈출!!
    ```
    
    1-1. For Each문
    
    - 인덱스는 불필요하지만 데이터 요소가 필요할 때
    
    ```java
    for (자료형 변수명 : 배열명) {  }
    ```
    
2. While문
    - 조건이 true인 동안 반복실행
    - 조건에 따라 실행 횟수가 0~무한대까지 될 수 있음
    - 반복되는 횟수가 일정치 않을 때
    - 무한반복할 때

1. Do-While문
    - 차이점: 실행횟수(1~무한대)  ⇒  조건식 결과와 상관없이 무조건 한 번은 실행됨!

---

Scanner 어케 쓰는지 가물가물했는데 확인 완료 ~.~
Scanner sc = new Scanner(System.in)
int i = sc.nextInt();
** 입력 시 Scanner를 사용하는 경우 비효율적임 - 권장XX
