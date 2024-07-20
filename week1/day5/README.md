### 생성자 실습

```java
class Parent {
	public Parent() {
		System.out.println("Parent 기본 생성자");
	}
	
	void good() {
		System.out.println("굿");
	}
}

class Child extends Parent {
	public Child() {
		System.out.println("Child 기본 생성자");
	}
}

public class ConstructorCallTest {

	public static void main(String[] args) {
		Child c = new Child();
		c.good();
		//부모 먼저 메모리 할당 -> 부모  생성자 호출 -> 자식 메모리 할당 -> 자식 생성자 호출
	}
}
```

### 오버라이딩

```java
Car class
	
	@Override
	public String toString() {//to~()메소드: 변환메소드
		                      //toString()메소드 : 객체의 상태를 표현하는 메소드
		String str="이 차는 "+ this.carName +"이고 바퀴수는 "+ wheelNum+", 속도는 "+ velocity+"입니다!!";
		return str;
	}
	
	@Override
	public boolean equals(Object ob) {
		Car c = ((Car) ob);
		
		if(
//		  carName == c.carName : X
		  carName.equals(c.carName)  && //String은 클래스이므로 equals로 비교
		   wheelNum == c.wheelNum  &&
		   velocity == c.velocity) {
			return true;
		}
		return false;
	}
	
------------------------------------------------------------------
main

public static void main(String[] args) {
		// Car - 클래스 객체(인스턴스)  :  ★인스턴스 비교법!!   1.내용 비교: equals   2.메모리(주소) 비교: '=='
		
		Car c1 = new Car("소나타", 4, 100);
		System.out.println(c1.toString());
		
//		Car c2 = new Car("아반떼", 4, 100);
		Car c2 = new Car("소나타", 4, 100);
//		Car c2 = c1;  //메모리 주소 복사 -> 동일 인스턴스 가리킴
		
		//레퍼런스비교, 메모리비교(같은 메모리를 사용하는지?)
		if(c1==c2) {
			System.out.println("객체(메모리)주소 같음!!");
		}else {
			System.out.println("객체(메모리)주소 다름!!");
		}
		
//		c1.equals(c2)	
//		: 객체 내용비교, 속성(필드)비교, 누구 메서드지?: Car class 탐색 -> 없으면 Object class
		if(c1.equals(c2)) {
			System.out.println("객체내용 같음!!");
		}else {
			System.out.println("객체내용 다름!!");
		}
		
	}
```

### 정렬실습

<미션1>

int[]su= {13, 8, 7, 10, 100, 5};

정수 배열을 오름차순 정렬하시오.

```java
int temp;
	   for(int i=0; i<su.length-1; i++) {//기준: 비교왼쪽 번지데이터  (0~4)
		  for(int j=i+1; j<su.length; j++) {//비교오른쪽 번지데이터  (i+1 ~ 5)
			  //교환
			 if(su[i] > su[j]) { //오름차순 또는 내림차순
			  temp = su[i];
			  su[i] = su[j];
			  su[j] = temp;
			 }
		  }
	   }
	   
	   //정렬된 배열의 값을 확인  ===> Arrays.toString(1차원배열명);
	   System.out.println(Arrays.toString(su));
```

- 오름차순 정렬
- 내림차순 정렬

<미션2>

char[]ch= {'J','a','v','A'};

String[]names= {"홍길동","길라임","김주원"};

문자,문자열 배열을 오름차순 정렬하시오.

```java
char[] ch = {'J','a','v','A'};
	   String[]names= {"홍길동","길라임","김주원"};
	   
	   Arrays.sort(ch);
	   Arrays.sort(names);
	   
	   System.out.println(Arrays.toString(ch));
	   System.out.println(Arrays.toString(names));
	   
	   //내림차순 -> Wrapper 클래스여야하네
	   Character[] ch2 = {'J','a','v','A'};
	   Arrays.sort(ch2,Collections.reverseOrder());
	   System.out.println(Arrays.toString(ch2));
```

<미션3>

Person p = new Person("갓길동",11,"학생",95);

person객체 이름 기준으로 오름차순 정렬

```java
Person p = new Person("갓길동",11,"학생",95);
	   Person[] persons= {p ,
		   	            new Person("빛길동",19,"학생",80),
			            new Person("남길동",14,"학생",100),
			            new Person("여길동",17,"학생",99),
			            new Person("킹길동",15,"학생",56)};
	 
	   Arrays.sort(persons);
	   System.out.println(Arrays.toString(persons));
	   
	}
}

class Person implements Comparable<Person>{
	String name;
	int age;
	String job;
	int score;
	
	
	public Person(String name, int age, String job, int score) {
		this.name = name;
		this.age = age;
		this.job = job;
		this.score = score;
	}

//	@Override
//	public String toString() {
//		return "\n[ " + name + ", " + age + ", " + job + ", " + score + " ]";
//	}
	
// 더 빠른 시간 효율 ~.~
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n[name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", job=");
		builder.append(job);
		builder.append(", score=");
		builder.append(score);
		builder.append("]");
		return builder.toString();
	}

	//Person 정렬 기준 설정하는 메서드
	@Override
	public int compareTo(Person o) {
		//나이 오름차순
//		return this.age - o.age;
		
		//이름 오름차순
//		return this.name - o.name; 문자열은 빼기 못하니까 에러
		return this.name.compareTo(o.name);
	}
}
```

- Arrays.sort(클래스 객체) : cannot be cast to class java.lang.Comparable 에러 발생
    - Comparable : 인터페이스 ⇒ implements 필요
    - **implements** Comparable
    - **implements** Comparable<Person> : Person 객체를 비교하겠다고 명시
    
- compareTo 메소드 오버라이딩

---

### String 클래스

- 문자열 비교
    - 주소 비교 : ==
    - 내용 비교 : str1.equals(str2)
    - 대소문자 무시하고 비교 : str1.equalsIgnoreCase(str2)
    - toUpperCase(), toLowerCase()
    - 특정문자열로 시작하는지 체크 : str.startsWith(String prefix)
    - 특정문자열로 끝나는지 체크 : str.endsWith(String suffix)
    
    ```java
    String s1="java";
    String s2="java";
    
    ==> 문자열 상수 취급!! (기본자료형처럼 저장,비교)
       
    💡    s1==s2         true  ==> 값비교
    💡    s1.equals(s2)  true  ==> 권장 (내용비교)
       
    =====================================
    
    String s3 = new String("java");
    String s4 = new String("java");
    
    ==> 두 문자열의 내용 비교~!!
    
    💡 	  s3==s4         false    ==> 주소비교
    💡    s3.equals(s4)  true     ==> 권장 (내용비교)
    ```
    

- 문자열 길이 : str.length()
    
    ※ 배열 길이 : arr.length
    
- 문자열 슬라이싱 : str.substring(beginIndex, endIndex)
    - beginIndex: 포함,   endIndex: 비포함

- 특정인덱스의 문자 얻어오기 : char c = str.charAt(int index)

- 특정문자의 인덱스 얻어오기 : int i = str.indexOf(int ch)

- 문자열 치환(대체) : str.replace(char oldChar , char newChar)
    
                                   str.replace(CharSequence target, CharSequence replacement)
    
    - CharSequence : 인터페이스 → String, charBuffer, …

- 문자열 제거 : str.trim()
    - 문자열 좌우 연속된 WhiteSpace 제거
    - 문자열 내 공백은 제거 X ← WhiteSpace 아닌 애가 나오면 제거 멈춤

💡 문자열 변환 시

- String클래스: 고정문자열!!
    
    ```
    1. String클래스 객체 생성
    2. 문자열변환을 위해서 임시로 StringBuffer클래스 객체 생성
    3. append()메소드 호출
    4. StringBuffer객체를 String객체로 변환
    5. 임시생성된 StringBuffer객체를 소멸.
    ```
    

---

### StringBuilder 클래스

- StringBuffer = StringBuilder + 스레드 동기화 기능 추가
    
        ⇒ StringBuilder보다 좀 느림
    

💡 문자열 변환 시

- StringBuilder클래스: 가변문자열
    - String 클래스보다 훨씬 빠름!!
    
    ```
    1. StringBuilder클래스 객체 생성
    2. append()메소드 실행.
    ```
    

```
//	@Override
//	public String toString() {
//		return "Person [ " + name + ", " + age + ", " + job + ", " + score + " ]";
//	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", job=");
		builder.append(job);
		builder.append(", score=");
		builder.append(score);
		builder.append("]");
		return builder.toString();
	}
```

---

### StringTokenizer 클래스

- 문자열 데이터를 특정 구분자(delimiter)로 분리해주는 클래스
- StringTokenizer(String 기준문자열 , String 구분자)
- nextToken() : 토큰 데이터 pop → 삭제
    - 마지막 데이터가 삭제된 후 nextToken() 실행 시 에러남 ⇒ **while**(st.hasMoreTokens()) {  } 사용
    
    ```java
    String tel="010-1234-4567"; 
    StringTokenizer st = new StringTokenizer(tel, "-");
    
    while(st.hasMoreTokens()) {
    //hasMoreTokens() : st에 토큰데이터를 가지고 있다면 true 리턴
    		 System.out.println(st.nextToken()); //토큰 데이터 뽑아오기
    ```
    

- String클래스의 Split()메서드와 비교
    - Split 메서드는 호출하는 다른 메서드들이 많아서 대빵 느림
    
    ```java
    String [] strs = str.split(구분자);
    for(int i=0; i<strs.length; i++) {
    		 System.out.println(strs[i]);
    }
    ```
    

---

### Collection

- Array vs. Collection Framework
    
    <Array>
    
    ▶️ 고정길이배열
    
    - 가장 기본적인 자료구조
    - 동일한 데이터 타입만 관리 가능
    - 타입이 다른 객체를 관리하기  위해 매번 다른 배열 필요
    
    <Collection Framework>
    
    ▶️ 가변길이배열
    
    - 객체의 참조를 담는 그릇
    - 여러 타입의 데이터를 담을 때는 편리하지만, 빼낼 때 Object로만 가져올 수 있음.
        
        > cf ) primitive 데이터 타입의 경우 ***Wrapper 클래스***로 변환되어 저장
        
    - Generic을 이용하여 타입을 한정하면 형변환의 번거로움을 제거 할 수 있음.
        
        > ArrayList <클래스> 한정 ⇒ 따로 캐스팅할 필요 없음 
        
    
    ![Untitled](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/f63bd01d-5178-4d1a-82c3-f46ffa242f7c/Untitled.png?id=3b12fb5d-4dbe-4685-b699-dc2d430b728b&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1721548800000&signature=oM-pZDhJM1qRDk7RvaktpDXfycGhb2Z2gMKVnMWhPy0&downloadName=Untitled.png)

    ![Untitled](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/6333ec0a-9049-4167-a769-53523ddb4fc1/Untitled.png?id=5778f967-e303-4296-9e2a-4fdeebfcb0c1&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1721548800000&signature=Pyw7ogyoFLV-Cqci6uy66EgIqCfdhAnUxsNZ0myMx0o&downloadName=Untitled.png)
    <pre>
    실선: Extends (인터페이스 → 인터페이스 or 클래스 → 클래스)   
    점선: implements (클래스 → 인터페이스)

    - Stack 대빵 느림
    - 삽입 삭제 등의 변경 : LinkedList 굿
    - 조회 : ArrayList 굿
    - 덱 : ArrayDeque 낫밷
    </pre><br>
    

    

---

### 실습 문제

> <<행운의 로또번호 생성기>>
> 
> 1. 서로 겹치지 않는 (중복되지 않는) 숫자 6개 생성
> 2. 각 숫자는 1~45 범위내의 숫자
> 3. 매번 실행시 다른 숫자 출력
> ---> 랜덤수 : java.util.Random클래스 - nextInt(int bound)사용
> 4. 다섯회 출력
> 5. 각 번호는 오름차순 정렬
> ---> java.util.Arrays클래스의 sort()메소드 사용.
> => LottoTest.java
> 출력형태)
> ★★ 금주 행운의 로또번호 ★★
> 1회: 2, 12, 15, 34, 36, 42
> 2회: 1, 2, 9, 33, 42, 45
> 3회: 9, 12, 14, 19, 34, 40
> 4회: 5, 10, 15, 18, 19, 22
> 5회: 7, 9, 15, 19, 39, 41

```java
내가 한 거
--------------------------------------------------------------------

public class LottoTest {

	public static void main(String[] args) {
		Random random = new Random();
		ArrayList<int[]> week = new ArrayList<>();

		int index = 0;
		while (index < 5) {
			int[] lottoNum = new int[6];
			
			
			// 중복없는 번호 추출
			for (int i = 0; i < 6; i++) {
				boolean flag = true;
				
				int num = random.nextInt(45) + 1;

				for (int j = 0; j < i; j++) {
					if (lottoNum[j] == num) {
						i-=1;
						flag = false;
						break;
					}
				}

				if (flag)
					lottoNum[i] = num;
				
//				System.out.println(num);
			}
			Arrays.sort(lottoNum);
			week.add(lottoNum);
			index++;
		}
		
		
		int i = 0;
		//출력
		for (int[] w : week) {
			i++;
			System.out.println(i + "회 " + Arrays.toString(w));
		}
	}
}
```

- 난수 생성 방법
    - java.lang.Math 클래스의 random() 메서드 사용
        
        → 별도의 import 필요없음
        
        → 0.0 ~ 0.999999.. 사이의 난수 생성됨
        
        → (int) Math.random() ⇒ 0만 나옴
        
        (int) (Math.random()) * 100 ⇒ 0 ~ 99
        
        (int) (Math.random()) * 100 + 1 ⇒ 1 ~ 100
        
    - java.util.Random 클래스 사용
        
        → 범위 지정 O : random.nextInt(N) ⇒ 0~N-1 사이의 정수 생성
        
        → 여러 데이터 타입의 난수를 생성하는 메서드들 사용 가넝

- 답안 코드
    - 애초에 중복이 안되는 로또 난수 배열을 만드는 방식으로-
    - Mission폴더 파일 참고
