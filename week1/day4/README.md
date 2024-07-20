# Day4

### 접근 제한자 : Access Control

- public           - 서로 다른 패키지에서도 접근가능
- protected      - 서로 같은 패키지에서 접근가능
    
                            ※ 만약 상속관계를 갖는다면 다른 패키지라도 자식이 부모를 참조!!
    
- default(생략)   - 서로 같은 패키지에서 접근가능
- private          - 같은 클래스 내에서만 (멤버끼리만) 접근가능

<aside>
💡 접근 제한자 위치

1. 필드
[접근지정자 4개] 자료형 변수명;
2. 메소드
[접근지정자 4개] 리턴자료형 메소드명( ) {   }
3. 클래스
[***public/default***] class 클래스명{   } + final abstract
4. 내부클래스
    
    외부 클래스의 멤버이기 때문에 [***private/protected]***까지 가능   ++ static
    
</aside>

- 기준 클래스

```java
package com.ureca.pack1;

public class Parent { //기준 클래스 (자원 정의)
	//필드,메소드 전부 access modifier의 개념은 같음!!
	
	public    void m1() {}               //다른 패키지
	protected void m2() {}               //같은 패키지,다른패키지 자식
	          void m3() { m4();  }       //같은 패키지
	private   void m4() {}               //같은 클래스
}
```

- 다른 클래스에서의 접근

```java
package com.ureca.pack1;

public class Other { 
    void callTest() {
    	Parent p = new Parent();
    	  p.m1();
    	  p.m2();
    	  p.m3();
//    	p.m4();  error: Private 접근 제한자 -> 동일 클래스에서만 접근 가능
    }
}
```

- 상속받은 자식 클래스에서의 접근
    - 오버라이딩
        
        💡 접근 제한자는 ***부모와 같거나 더 넓은 범위***로 확장되어야 함
        
        부모: 디폴트             ==> 자식: 디폴트,protected,public
        부모: protected        ==> 자식: protected,public
        부모: public              ==> 자식: public
        

```java
public class Child extends Parent{
	void callTest() {
		m1(); // = this 생략되어 있음 : 현재 클래스에서 탐색 -> 부모 클래스에서 탐색 -> ..
		m2();
		m3();
//	m4();      error!
	}
}
```

- 다른 패키지 클래스에서의 접근

```java
package com.ureca.pack2;

import com.ureca.pack1.Parent;

public class Other {
	void callTest() {
		Parent p = new Parent();
		parent.m1();
//		p.m2(); error: Protected -> 동일 패키지 or 상속받은 자식에서만 접근 가능
//		p.m3(); error: Default -> 동일 패키지에서만 접근 가능
//		p.m4(); error: Private 접근 제한자 -> 동일 클래스에서만 접근 가능
	}
}

package com.ureca.pack2;

import com.ureca.pack1.Parent;

public class Child extends Parent{
	void callTest() {
		m1(); 
		m2();	 //상속받은 자식클래스라서 에러 안남
		m3();	 //다른 패키지라서 에러 남
//	m4();      error!
	}
}
```

---

### final

- constant로 만들어주는 키워드
    
    final 변수 - 초기화 후 변경 불가
    
    final 메서드 - 오버라이딩 불가
    
    final 클래스 - 상속 불가
    
    ```java
    1. final 필드 : 상수표현 (변수와 구분하기 위하여 전체 대문자로 표기)
       
       
       final int MAX=100;
       MAX=200; ==> 에러발생
       
       
       class My{
          final int MAX;  ==> 에러발생
          
          방법1) 선언과 동시에 초기화
          final int MAX = 200;  
          
          방법2) 필드에서 선언된 값을 생성자에서 초기화
          My(){
             MAX=100;
          }
       }
       
       
    2. final 메소드 정의  ==> 메소드 재정의 불가!!
       final void hello(){}
       
       
    3. final 클래스  ==> 서브클래스를 갖지 않는 클래스!!
                     ==> 보안, 설계  
                     ==> extends 불가능
       final class 클래스명{}
    ```
    

---

### 인터페이스

- 인터페이스는 객체화 불가능 (new 메모리 할당 불가!)
- 형식
    
    ```java
    💡 interface 인터페이스명
    {
    	//필드
    	[public static final 고정] int su;
    
    	//선언된 메서드 - body 구현X
    	[public abstract 고정] void print();
    }
    ```
    
- <손님의 입장> = 메뉴판
    - 서로 다른 제품에 연결할 수 있는 공통 연결 모듈을 의미.
    
- <요리사의 입장(객체를 생성하는 곳)>
    - 클래스에 다중 상속을 구현할 수 있다.
    - ★ 인터페이스는 어떻게 사용? 클래스에 구현해서 사용!!
    
- 클래스에 구현하려면?   →  키워드 : implements

```java
class     클래스명     implements     인터페이스명   {   }
         ----------   -----------    -------------
            주방        구현약속         메뉴판
```

- 코드

```java
public interface Menupan {
	
	void 짜장면();	//메서드: public abstract 생략되어있음
	abstract void 짬뽕();
	public abstract void 볶음밥();
}

------------------------------------------------------------------
public class Restaurant implements Menupan {

	@Override
	public void 짜장면() {
		System.out.println("짜장면");
	}

	@Override
	public void 짬뽕() {
		System.out.println("짬뽕");
	}

	@Override
	public void 볶음밥() {
		System.out.println("볶음밥");
	}
	
	void 초밥() {
		System.out.println("초밥");
	}
}

------------------------------------------------------------------
public class InterfaceTest {
	public static void main(String[] args) {
//		Menupan menu = new Menupan(); error! 인터페이스는 직접 객체 할당 불가
		
		Menupan menu;  
		menu = new Restaurant();
		menu.짜장면();
		
//		menu.초밥(); error! 초밥은 자식 클래스에만 있는 메서드임
		((Restaurant) menu).초밥();
	}
}
```

- 상속 문법 : extends → implements
    - 클래스와 인터페이스를 동시에 상속할 때는 클래스 먼저, 인터페이스 나중
    - 부모 : interface A, class B
    - 자식 : class C
    
    ```java
    💡 class C implements A  extends  B  --> 에러
    //extends가 먼저 우선순위여서 extends Object를 자동으로 추가한 후 implements 수행
    
    💡 class C extends  B  implements A  --> (O)
    ```
    
    - 인터페이스끼리 상속은 extends X → implements O
    
    ```java
    interface A { void hello(); }
    interface B { void hi(); }
    
    interface C  extends  A,B { //extends XXXX -> implements (O) 
       void good();
    }
    ```
    

---

### 추상클래스 : Abstract Class

- 후손 class를 제어할 목적으로 사용
- 객체화 불가(new 메모리 할당 불가)
    
         → 후손 class 객체 생성해서 사용(자식은 부모를 대신할 수 있다! 부=자)
    
- 구현된 메서드와 선언된 메서드(후손이 body 구현)로 구성
    
      ※ 주의: 선언된 메서드의 경우 반드시 abstract 명시!!
    
    ex) InputStream/OutputStream/Reader/Writer : 입출력 추상클래스
    
          BufferedReader(Reader reader) 들어가야 하는데, Reader는 추상클래스임 new 불가
    
          BufferedReader(new InputStreamReader) 자식은 부모를 대신한다!
    
- 오버라이딩
    
    💡 접근 제한자는 부모와 같거나 더 넓은 범위로 확장되어야 함
    
    부모: 디폴트             ==> 자식: 디폴트,protected,public
    부모: protected        ==> 자식: protected,public
    부모: public              ==> 자식: public
    

---

### 내부 클래스 : Inner(Nested) Class

- 클래스 내에 다른 클래스를 정의하는 것
- 클래스 내에 정의되면 멤버의 성질을 띄기 때문에 static class로 선언될 수 있음
- 종류
    - 정적 중첩클래스 - static이 선언된 내부클래스
    외부의 자원을 사용할 때 static붙는 인스턴스만 접근가능.
    - 비정적 중첩클래스 - static이 선언되지 않은 내부클래스 (inner클래스!!)

```java
class A{ //외부클래스, Outer클래스, Top-level클래스
     //1차 자원 정의 ( 필드 -> 생성자 -> 메서드 )
    
     int i=11;
     
     void hello(){
         print(); (X: 내부 클래스 메서드 호출 불가능)
         
         B b = new B();
         b.print();  (O)    
     }
    
     class B{ //내부클래스, Inner클래스
     //2차 자원 정의
        void callTest(){
           hello();  (O)
        }
        
        void print(){
        
        }     
     }//B class  
 }//A class    
```

---

### 익명 클래스

- 정렬에서 자주 사용된다고 하심 ㅇ0ㅇ
- 클래스 파일을 따로 만들 필요가 없을 때 사용하는 일회성 클래스
- 형식
    - 클래스 참조변수 = new 클래스() {  //오버라이딩 구현  };
- 예시

```java
package com.ureca;
//익명 내부 클래스 테스트

class A {
	public void happy() {
		System.out.println("happy!");
	}
}

class ChildOfA extends A {
	@Override
	public void happy() {
		System.out.println("행복한!");
	}
}

------------------------------------------------------------

interface Ureca {
	void good();
}

class My {
	public static void go (Ureca u) {
		u.good();
	}
}

class ChildOfUreca implements Ureca {

	@Override
	public void good() {
		System.out.println("Ureca!");
	}
}

-------------------------------------------------------------

public class AnonymousInnerClassTest {
	
	public static void main(String[] args) {
//		A a = new A();
		
//		A a = new ChildOfA(); //따로 클래스 파일 만들기 귀찮아 -> 익명 내부 클래스 이용하자
		A a = new A() { // (중괄호의 의미 = extends A)
			public void happy() {
				System.out.println("익명 행복한!");
			}
		};
		a.happy();
		
		
		
//		My.go(new Ureca());  interface: new 객체할당 불가 => 자식 생성 필요
//		My.go(new ChildOfUreca());
		
//		자식클래스 없이 구현 객체를 익명 내부 클래스로 정의할 수 있음  
		My.go(new Ureca() { // (중괄호의 의미 = implements Ureca)
			
			@Override
			public void good() {
				System.out.println("익명 Ureca!");
			}	
		});
	}
}
```
