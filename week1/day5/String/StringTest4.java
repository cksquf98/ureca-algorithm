package com.ureca.String;

public class StringTest4 {
  public static void main(String[] args) {
	
	 String s1="java";
	 String s2="JAVA";
	 
	 //char ch1='a';  char ch2='A';  int su1=10; int su2=20;
	 //===> ch1==ch2        su1==su2
	 
	 //s1과 s2문자열 (내용, 데이터 값)비교 ★
	 //===> s1==s2 (X)  -------> 메모리 비교!!
	 //===> s1==null (O)  -------> 메모리 비교!!
	 //===> s1.equals(s2) (O)
	 
	 if(s1.equals(s2)) {
		 System.out.println("문자열 같음!!");
	 }else {
		 System.out.println("문자열 다름!!");		 
	 }
	 
	 if(s1.equalsIgnoreCase(s2) ) {//대소문자 구분없이 철자비교
		 System.out.println("문자열 같음(대소문자 구분X)");
	 }else {
		 System.out.println("문자열 다름(대소문자 구분X)");		 
	 }
	 
	 String str="JavaProgramming";
	 
	 System.out.println("STR="+ str);
	 System.out.println("STR(전체대문자)="+ str.toUpperCase());
	 System.out.println("STR(전체소문자)="+ str.toLowerCase());
	 
	 //특정문자열로 시작하는지 체크 str.startsWith(String prefix)
	 System.out.println(str.startsWith("av"));
	 
	 //특정문자열로 끝나는지 체크 str.endsWith(String suffix)
	 System.out.println(str.endsWith("ing"));
	  
  }
}













