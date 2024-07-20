package com.ureca.pack1;

public class AccessControlChild extends AccessControl{
	void callTest() {
		m1(); // = this 생략되어 있음 : 현재 클래스에서 탐색 -> 부모 클래스에서 탐색 -> ..
		m2();
		m3();
//		m4();      error!
	}
}
