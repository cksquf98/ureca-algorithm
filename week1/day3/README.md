# Day3
### 배열 입력 실습

```java
NameMenu class파일

public class NameMenu {
		//데이터 저장소
		private String []names = new String[5];		// -> 멤버 필드 : 기본값(null)으로 자동 초기화
		
		public void addName(String name)
		{
			for (int i = 0; i < 5; i++) {
				if(names[i] == null)
				{
					names[i] = name;
					break;
				}
			}
		}
		
		public String[] search()
		{
			return names;
		}
		
		public void modify(String originName, String newName)
		{
			for(int i=0; i<5;i++) {
				if(names[i].equals(originName))
				{
					names[i] = newName;
					break;
				}
				else
					continue;
			}
		}
		
		public void delete(String input)
		{
			for(int i=0; i<5;i++) {
				if(names[i].equals(input))
				{
					names[i] = "";
					break;
				}
				else
					continue;
			}
		}
}
```

```java
NameMenuTest 사용자 View 화면

public class NameMenuTest {
	
	//화면출력 & 사용자 입력 View
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		NameMenu nameMenu = new NameMenu();
		
		String input;
		do {
			System.out.print("<이름메뉴>\n1.추가 2.검색 3.수정 4.삭제 5.종료\n번호입력 ==> ");
			input = br.readLine();
			
			
			switch(input) {
			case "1":
				System.out.print("이름 입력: ");
				input = br.readLine();
				
				nameMenu.addName(input);
				break;
				
			case "2":
				System.out.println("#이름목록");
				
				String[] names = nameMenu.search();
				
				for (String name : names) {
					if(name == null) continue;
					System.out.println(name);
				}
				System.out.println();
				break;
				
			case "3":
				System.out.print("기존이름입력: ");
				String originName = br.readLine();
				System.out.print("변경이름입력: ");
				String newName = br.readLine();
				
				nameMenu.modify(originName, newName);
				break;
				
			case "4":
				System.out.print("삭제이름입력: ");
				input = br.readLine();
				
				nameMenu.delete(input);
				break;
			}
		} while(input.equals("5") == false);

	System.out.println("--END--");
	}
}
```

- 문자열 비교
    - ‘ == ‘ : 메모리 주소값 비교
    - 문자열1.equals(문자열2) : 문자열 내용 비교

---

### 객체 지향

- JAVA는 객체 지향 언어 - OOP(Object Oriented Programming)

- 특징
    1. 캡슐화 : 클래스에 필드와 메서드를 묶어주는 것 
        
                             → 실제로 어떤 구성의 코드인지 알 필요 없게 해줌
        
        - 정보 은닉
        - 모듈성
        
    2. ★ **상속**  : 부모가 갖는 자원(필드, 메서드)을 자식도 사용할 수 있게 물려주는 것
        - extends 키워드
        - 단일 상속이 원칙
 


        <aside>
          <br>
        💡 자바API
        
        java.lang.Object                  상위, super, 부모클래스        
        java.lang.String                  하위, sub, 자식클래스
        
        ————————————————————————————
        
        ※ Object클래스 ---> 최상위클래스!!
        ---> 자바의 모든 클래스의 부모클래스
        ---> 사용자가 정의하는 클래스에도 자동 추가 extends Object
        
        </aside>
        
    2. 다형성
        - **오버라이딩** ★★  == 메서드 재정의
            - 부모가 물려준 메서드를 자식 클래스에서 재정의하는 것 (아래에서 나옴)
            - 부모 : 추상클래스 → 자식 : extends
            - 부모 : 인터페이스 → 자식 : implements
            
        - 오버로딩
            - 한 클래스 내에 동일한 이름의 메서드를 여러개 구현하는 것
                
                ※ 단, 파라미터 개수나 자료형 타입이 달라야 함
                
        
        ```java
        class A{
        
          void hello()
          {
            System.out.println("안녕~!!");
          }
        
          void hello(String name)  ---> 오버로딩 메소드
          {
            System.out.println("안녕,"+name+"!!");
          }
        }
        ```
        

### 생성자

- 클래스 멤버들을 초기화하는 메서드 (찐 메서드는 아님)
- 메모리 할당 직후 한 번 호출됨
- 생성자도 멤버임 → 접근 제한자 설정 가능

<aside>
💡  1.  생성자의 이름은 반드시 클래스명과 일치(대소문자 일치)

1. ***리턴자료형 X***

-------------- 1,2번 : 일반 메소드와의 차이점---------------

1. 객체생성시 자동으로 호출.
2. 클래스내에 생성자가 하나도 없다면
자바컴파일러가 컴파일시 자동으로 기본생성자를 추가.

---

 컴파일러가 자동으로 하는 일

1) import java.lang.*

2) 클래스 extends Object

3) 기본 생성자 className( ) {  } 추가

   ※ 주의) 만약, 클래스내에 한개 이상의 생성자가 정의 되어 있다면
   컴파일러는 소드코드에 관여하지 않는다!!

</aside>

```java
public class Constructor {
	
	int s; //멤버변수니까 알아서 0으로 초기화된 상태
	String str; //멤버변수 알아서 null 초기화
	
	//기본 생성자 : 초기화 메서드
	Constructor() {
		s = 1000;
	}
	
	//오버로딩 생성자
	Constructor(String str) {
		this.str = str;
		//str = str;  --> 가장 가까운 변수인 파라미터 지역변수 str로 인식됨
		// => 멤버변수에 str이 들어가지 않음.
	}
		
	void hello() {
		System.out.println("안뇽");
	}
}

-----------------------------------------------------------------

public static void main(String[] args) {
		
		Constructor c1 = new Constructor();
		Constructor c2 = new Constructor("Java"); 
		c1.hello();
		c2.hello();
		
		System.out.println("c1 str = " + c1.str);
		System.out.println("c2 str = " + c2.str);
	}
```

### This : 레퍼런스 변수

- 현재 클래스를 가리키는 참조 변수
- 메소드 내에서 사용
- 객체 생성자 내에서 다른 생성자를 호출 시 사용
- 매개변수( = 지역변수)와 멤버변수( = 필드)를 구분하기 위해 멤버변수 앞에 붙여서 사용

<aside>
💡

형식)

this.필드명
this.메소드명();
this(  );  

- 생성자가 다른 오버로딩 생성자 호출 시 사용
- 첫번째 문장에서만 호출 가능

참고) super : 부모 클래스를 가리키는 참조 변수

super.필드명
super.메소드명();
super(  );  //부모클래스 생성자 호출

</aside>

---

### 상속

- extends/implements  →  ***is a 관계*** ★★
    - 자식 = 부모 + a
        
        == 자식클래스는 부모클래스로 형변환이 가능하다!
        
    
    ```java
    //자식은 부모를 대신할 수 있음
    Parent p;
    p = new child; ( 부=자 O:정상 컴파일 )
    
    //부모는 자식을 대신할 수 없음
    Child c;
    c = new parent; ( X:정상 컴파일 여부 알 수 없음 )
    ```
    
    **①부모클래스 객체생성**                                           
    

![Untitled](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/bb479d04-5163-4c2d-b8bd-728a421416b6/Untitled.png?id=06ea30aa-fe53-46d7-bdd8-6954398c6993&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1721548800000&signature=pP2KgCzRYXOV6-mpDhpJQIIzti0xVh5HyQPxWnVR2CY&downloadName=Untitled.png)

<pre>
Parent p = new Parent( );
(참조)         (할당)
</pre>
<br>

**②자식클래스 객체생성**

![Parent p = new Child( );
(참조)                 (할당)](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/a7c56004-4beb-4c96-a9c5-8ca824eec252/Untitled.png?id=fa2eee32-2f45-455a-bf55-f0b6a76acbf8&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1721548800000&signature=nxykn7GUicIqYScaUUghQhi8qUrkKc5rIDikcIeGd5I&downloadName=Untitled.png)

<pre>
Child c = new Child( );
(참조)         (할당)

- 클래스 객체 생성 시 최상위 클래스까지 메모리에 할당됨
</pre>
<br>

**③자식클래스 객체생성(부모참조)**
![Untitled](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/4d0ac4e2-bb93-4f94-841a-d5cd57bc8378/Untitled.png?id=612a4444-6813-42ea-aac7-f256d8d4fab2&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1721548800000&signature=Fm-4-NpqJDI_321Ips1XgZ_1wpqRExuiPJcAh4zVea4&downloadName=Untitled.png)

<pre>
Parent p = new Child( );
(참조)                 (할당)

- 자식 클래스에서 메서드 오버라이딩할 경우. 부모 메서드는 은폐됨
    
    ※ 메서드만 해당됨. 필드는 참조변수가 가리키는 곳 기준
    
- p2.print( ); —> 자식 출력
- print(p2.su); —> 300 출력
</pre><br>

  
**④자식클래스 객체생성(부모참조) -** 자식클래스 참조를 하고 싶을때

![https://prod-files-secure.s3.us-west-2.amazonaws.com/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/0b785e02-4a94-435e-8a47-6110bc911346/Untitled.png](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/0b785e02-4a94-435e-8a47-6110bc911346/Untitled.png?id=96a8630d-4052-418d-857a-bb6d602924b2&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1721548800000&signature=iqA-9rTH0FmEsQaEky5tkPYyhBXOkDjKvUZhTRYD70k&downloadName=Untitled.png))

<pre>
Parent p2 = new Child();
Child c3 = (Child) p2;

- c3.sum;  —> 0 출력
- c3.goodbye();
</pre><br>
  
- 부 = 자 코드 실습

```java
클래스

public class Overriding {
	static void print(ArrayList<String> list2) {
		for (String str : list2) {
			System.out.println(str);
		}
	}
	
	static void print2(List<String> list2) {
		for (String str : list2) {
			System.out.println(str);
		}
	}
}
```

```java
자바

public static void main(String[] args) {
		//가변길이 Object 배열 : 다른 자료형 타입들을 한번에 담을 수 있지만 나중에 오류 발생할 가능성 높음
		ArrayList list1 = new ArrayList();
		
		list1.add("hong");
		list1.add("kim");
		list1.add("lee");
		list1.add(100);
		
		
		//<Generic>을 사용해서 특정 자료형만 담아두게 하자!
		ArrayList<String> list2 = new ArrayList<>();
		
		list2.add("hong");
		list2.add("kim");
		list2.add("lee");
//		list2.add(100); error-!
		
		Overriding.print(list2);
		
		
		//Vector
		Vector<String> list3 = new Vector<>();
		list3.add("hong");
		list3.add("kim");
		list3.add("lee");
//		list3.add(100); error-!
		
//		Overriding.print(list3); 상속관계도 아니고 자료형 아예 달라서 error-!
		Overriding.print2(list3); //Vector의 부모가 List이기 때문에 부=자 성립
	}
```

---

### Wrapper클래스

기본자료형        Wrapper클래스(기능 확장) : java.lang 패키지

byte                   Byte

short                  Short

int                      Integer

long                   Long

float                   Float

double               Double

char                   Character

boolean             Boolean

### (자습)Vector vs. ArrayList

1. 동기화(Synchronization)
    - ArrayList: 동기화를 제공하지 않습니다. 따라서 멀티스레드 환경에서 안전하지 않습니다. 그러나 동기화 오버헤드가 없기 때문에 단일 스레드 환경에서는 더 빠릅니다.
    - Vector: 모든 메서드가 동기화되어 있습니다. 즉, 멀티스레드 환경에서 안전합니다. 그러나 동기화로 인한 오버헤드가 있기 때문에 성능이 저하될 수 있습니다.
        - 동기화된 메서드 : synchronized 키워드를 통해 정의된 메서드로, 한 번에 하나의 스레드만 해당 메서드에 접근   ⇒  데이터의 일관성 보장
    
2. 성능
- ArrayList: 비동기화된 클래스이기 때문에 성능이 더 우수합니다. 멀티스레드 환경이 아니라면 ArrayList를 사용하는 것이 일반적으로 더 효율적입니다.
- Vector: 동기화 오버헤드 때문에 성능이 떨어질 수 있습니다. 동기화가 필요한 상황에서만 사용해야 합니다.

1. 확장성
- ArrayList: 기본적으로 크기가 1.5배로 증가합니다.
- Vector: 기본적으로 크기가 2배로 증가합니다. 이는 메모리 사용에 영향을 미칠 수 있습니다.
