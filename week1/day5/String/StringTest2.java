package com.ureca.String;

public class StringTest2 {
  public static void main(String[] args) {
	String str="Java3Pro7gra9mm0ing";
	
	//문제) 문자열 str안의 숫자의 갯수를 출력하시오.
	
	//1. char문자 하나하나 받아오기
	int cnt=0;
	for(int i=0; i<str.length(); i++) {//문자열 인덱스를 표현
		char ch=str.charAt(i);
	  if(ch>='0' && ch<='9') {
		  cnt++;
	  }
	}//for
	System.out.println("str의 숫자 개수: "+ cnt);
	
	/*
	    '0' ---> 48
	    '1' ---> 49
	    '2' ---> 50
	    ...
	    '9' ---> 57
	    
	    char ch = str.charAt(0);     ch >= '0'
	                                 ch <= '9'
	 */

	/*
	         st.getBytes();               st.toCharArray();
	          <-----------                 ------------->
        byte b[]           String st="abc";             char ch[]
	    ={97,98,99};                                  ={'a','b','c'};                    
	           ----------->                <-------------
	           new String(b);               new String(ch);
	           
	 
	  byte b2[]={65,67,69};                char ch[]={'a','c','e'};
	           //'A'
	             
	  String s1=new String(b2);            String s2=new String(ch);
	    //s1="ACE";                          //s2="ace";	                          
	                          
	 */
	
	//2. byte배열로 한 번에 받아와서 아스키 코드 비교
	byte b[]=str.getBytes();
	//숫자0 아스키코드 : 48,    숫자9 아스키코드: 57
	
	int count=0;
	for (int i = 0; i < b.length; i++) {
		if(b[i] >=48 &&  b[i] <=57) { //숫자로 구성된 문자라면
			count++;
		}
	}//for
	System.out.println("str의 숫자 개수: "+ count);
	
	
	
	//3. char 배열로 한 번에 받아와서 문자 비교
	char ch[]=str.toCharArray();
	count=0;
	for (int i = 0; i < ch.length; i++) {
		if(ch[i] >='0' &&  ch[i] <='9') { //숫자로 구성된 문자라면
			count++;
		}
	}//for
	System.out.println("str의 숫자 개수: "+ count);
	
  }//main
}





