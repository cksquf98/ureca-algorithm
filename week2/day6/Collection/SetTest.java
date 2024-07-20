package com.ureca.Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
   public static void main(String[] args) {
	  //Set : 중복데이터 제거, 순서가 일정치 않다(인덱스가 없다) 
	   
	  Set<String> set = new HashSet<>();
	    set.add("홍길동");
	    set.add("길라임");
	    set.add("김주원");
	    set.add("홍길동");
	    set.add("이순신");
	    set.add(null);
	    set.add(null);
	 
	  //단순히 요소의 값이 궁금해?? ==> 오버라이딩 toString()을 통해 확인 가능!!
	  System.out.println(set.toString());  
	  System.out.println(set);
	  System.out.println("요소개수: "+set.size());
	  
	  //모든 요소를 출력하고 싶다!!
	  System.out.println("====================");
	  for(String str :set) {
		  System.out.println(str);
	  }
	  
	  System.out.println("===================");
	  //모든 요소를 출력2
	  Iterator<String> it = set.iterator();
	  //==> 열거형 인터페이스
	  
	  while(it.hasNext()) {   //존재하는 데이터 유무
	    System.out.println(it.next());
	  }
	  
	  //배열 변환하기
	  Object[]ob = set.toArray();
	  //==> Object배열이기 때문에 추가적인 캐스팅(형변환)이 필요할 수 있다.
	  
	  String[] strArr = new String[set.size()];
	  set.toArray(strArr);
	  
	  for (int i = 0; i < strArr.length; i++) {
		System.out.println(i+":"+strArr[i]);
	  }
   }
}
