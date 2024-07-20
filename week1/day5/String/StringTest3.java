package com.ureca.String;

public class StringTest3 {
  public static void main(String[] args) {
	  String tel="02-123-4567";
	  //          012345678901
	  
	  int idx = tel.indexOf('-');
	  
	  String tel1= tel.substring(0, idx);
	  
	  int lastIdx = tel.lastIndexOf('-');
	  String tel2= tel.substring(idx+1, lastIdx);
	  
	  String tel3= tel.substring(8);
	  
	  System.out.println("tel1 = "+ tel1);
	  System.out.println("tel2 = "+ tel2);
	  System.out.println("tel3 = "+ tel3);
	  
	  //일일이 인덱스 찾기 귀차나  ==> StringTokenizer 파일 참고
  }
}
