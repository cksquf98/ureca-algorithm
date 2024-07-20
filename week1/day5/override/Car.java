package com.ureca.override;

public class Car {
	//멤버변수 == 필드  ==> 초기값이 존재   ( 정수: 0, 실수: 0.0,  논리: false, 문자: '\u0000', 문자열: null)
    String carName;  //null
    int wheelNum;    //0
    int velocity;    //0
    
    
    //기본생성자
    public Car() { 	}


	//오버로딩 생성자
	public Car(String carName, int wheelNum, int velocity) { 
		super();	//자기 클래스 기본 생성자 확인 -> 없음 -> 부모(Object) 클래스 기본 생성자 호출
		this.carName = carName;
		this.wheelNum = wheelNum;
		this.velocity = velocity;
	}

	
	@Override
	public String toString() {//to~()메소드: 변환메소드
		                      //toString()메소드 : 객체의 상태를 표현하는 메소드
		String str="이 차는 "+ this.carName +"이고 바퀴수는 "+ wheelNum+", 속도는 "+ velocity+"입니다!!";
		return str;
	}
	
	
	//alt + shift + s (= 오른쪽 클릭 > Source > Generate toString)
//	@Override
//	public String toString() {
//		return "Car [carName=" + carName + ", wheelNum=" + wheelNum + ", velocity=" + velocity + "]";
//	}
	
	
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
}