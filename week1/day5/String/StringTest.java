package com.ureca.String;

public class StringTest {
  public static void main(String[] args) {
   
	 //String 문자열 : 문자들의 나열!!
	 String str="JavaProgramming";
	 //인덱스      012345678901234
	 
	 //str.~   String클래스에 있는~
	 //문자열 길이  
	 System.out.println("str문자열길이(문자갯수): "+ str.length() );
	 
	 //부분문자열 ---> "Pro"문자열 얻기
     System.out.println("str.substring(4,7)="+str.substring(4,7));//인덱스 4~6	
     //str.substring(beginIndex, endIndex)
     //beginIndex: 포함,   endIndex: 비포함
     
     //부분문자열 ---> "Programming"문자열 얻기
     System.out.println("str.substring(4)="+str.substring(4));
   //str.substring(beginIndex) ---> beginIndex부터 끝까지 부분문자열 얻기
     
     
     //String str="JavaProgramming";
	 //인덱스        012345678901234
     
     //특정인덱스의 문자 얻어오기 :char str.charAt(int index)
     System.out.println("str.charAt(4)="+str.charAt(4));
     
     //특정문자의 인덱스 얻어오기 :int str.indexOf(int ch)
     System.out.println("str.indexOf('P')="+ str.indexOf('P'));//(97));
     
     
     System.out.println("str.indexOf(\"am\")="+ str.indexOf("am"));
     
     //String str="JavaProgramming";
     
     //문자열 치환(대체)
     //replace(char oldChar, char newChar) 
     System.out.println("str.replace('a', 'o')="+ str.replace('a', 'o'));
     //str = str.replace('a', 'o');
     System.out.println("STR="+ str);
     
     //replace(CharSequence target, CharSequence replacement)
     //"Java" ---> "자바" 변경하시오.
     System.out.println("str.replace(\"Java\", \"자바\")="
                       + str.replace("Java", "자바"));
     
     //문자열에 공백 추가!!
     str="      "+str+" aa a ";
     
     System.out.println("STR="+str);
     System.out.println("STR문자열길이="+str.length());
     //문자열 제거!!
     str=str.trim();//좌우 연속되는 공백(white space --> space,tab,enter)을 제거
     System.out.println("공백제거후 STR문자열길이="+str.length());
     System.out.println(str);
	 
  }
}
