package com.uplus;

public class Parent {
   int su = 300;
   void hello() {
	   System.out.println("안녕");
   }
   void hello(String name) {//오버로딩
	   System.out.println("안녕,"+name);
   }
   void print() {
	   System.out.println("부모");
   }
}
