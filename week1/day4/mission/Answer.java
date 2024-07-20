package com.ureca.mission;

import java.util.Arrays;
import java.util.Collections;

public class Answer {
	public static void main(String[] args) {
		
	//1. 오름차순 정렬
	int[]su = {13, 8, 7, 10, 100, 5};
	
	   /*
	   
    i[0   1  2   3   4]           비교대상 왼쪽 데이터(인덱스)
    j    [1  2   3   4   5]       비교대상 오른쪽 데이터(인덱스)
    
	int[]su= {13, 8, 7, 10, 100, 5};
       		  ↑ > ↑
              8   13 7  10  100 5  
      		  ↑      ↑
      		  7   13 8  10  100 5
      		  ↑          ↑ 
      		  7   13 8  10  100 5
      	 	  ↑              ↑                 
      		  7   13 8  10  100 5
      		  ↑                 ↑                   
      		  5   13 8  10  100 7
      ==> 한 사이클 (i=0일때 j값 변경하며 비교한 결과)   : 최소값을 맨 좌측으로 이동!!
  
	  */
	
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
	   
	   
	   
	   
	   //2. 문자,문자열 배열 오름차순 정렬
	   // 1번 해결 방식으로 정렬할 수 있긴함
	   // ===> api를 통해 정렬하자!
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
	   
	   
	   
	   
	   
	   
	   //3.Person객체에 대해 name 필드로 정렬
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