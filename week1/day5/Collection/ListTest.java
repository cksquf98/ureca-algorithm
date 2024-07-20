package com.ureca.Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.awt.*;

class B{
	
	public void dataPrint(Vector<String> v) {
		System.out.println("==================");
	   	for(String str :v) {
	   		System.out.println(str);
	   	}
	}
	
	public void dataPrint2(List<String> v) {
		System.out.println("--------------------");
		for(String str :v) {
			System.out.println(str);
		}
	}
	
}


public class ListTest {
  public static void main(String[] args) {
	//ArrayList - Vector와 사용문법이 같다!!
	//          - 차이점: ArrayList가 처리 속도가 빠르다
	//                  (이유: Vector에는 동기화 코드가 추가되어있음)
	
	ArrayList<String> list = new ArrayList<>();
	
	List<String> list2 = new ArrayList<>();
	//자료에 대한 추가, 검색, 수정, 삭제
	
	List<String> list3 = new Vector<>();
	List<String> list4 = new LinkedList<>();
	
	
	Vector<String> v = new Vector<>();
	  v.add("길동");
	  v.add("라임");
	  v.add("주원");
	 
	 //벡터 toString() 오버라이딩을 구현해서 저장된 데이터를 보여줌!!
	 System.out.println("v="+ v); 
	  
	 B b = new B();
	   b.dataPrint(v);
	   
	 ArrayList<String> alist = new ArrayList<>();
	   alist.add("홍");
	   alist.add("길");
	   alist.add("김");
	   
	   alist.remove(2); //데이터 삭제 : 인덱스2 ->'김' 삭제
	   String str = alist.get(0);    //데이터 조회 : get(index) -> '홍' 조회
	   
	   System.out.println("str = " + str);
	   
	 LinkedList<String> linkList = new LinkedList<String>();
	   linkList.add("a");
	   linkList.add("b");
	   linkList.add("c");
	   
	   //b.dataPrint(alist);
	   b.dataPrint2(v);
	   b.dataPrint2(alist);
	   b.dataPrint2(linkList);
	   
	 //ArrayList와 LinkedList 속도 테스트
	   
	 ArrayList<Person>  list10 = new ArrayList<>();   
	 LinkedList<Person>  list20 = new LinkedList<>();
	 
	 //첫번째: 순차적인 입력!! 데이터를 뒤로 추가
	 long start,end;
	 
	 start = System.currentTimeMillis();
	 for(int i=0; i<10000000; i++) {
		 list20.add(new Person()); 
	 }
	 end = System.currentTimeMillis();
	 System.out.println("LinkedList 데이터입력시간(순차): "+ (end-start));
	 
	 
	 start = System.currentTimeMillis();
	 for(int i=0; i<10000000; i++) {
		list10.add(new Person()); 
	 }
	 end = System.currentTimeMillis();
	 System.out.println("ArrayList 데이터입력시간(순차): "+ (end-start));
	 
	 ///////////////////////////////////////////////////////
	 System.out.println("===========================");
	 //두번째: 중간 입력(ArrayList는 인덱스에 대한 재배열)!! 데이터를 앞에 추가
	 	 
	 start = System.currentTimeMillis();
	 for(int i=0; i<100000; i++) {
		 //list20.add(int index,Person element); 
		 list20.add(0, new Person()); 
	 }
	 end = System.currentTimeMillis();
	 System.out.println("LinkedList 데이터입력시간(중간입력): "+ (end-start));
	 
	 
	 start = System.currentTimeMillis();
	 for(int i=0; i<100000; i++) {
		 list10.add(0,new Person()); 
	 }
	 end = System.currentTimeMillis();
	 System.out.println("ArrayList 데이터입력시간(중간입력): "+ (end-start));
	 
	
  }//mai
}









