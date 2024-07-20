package com.ureca.pack1;

public class Other {
	void callTest() {
		AccessControl parent = new AccessControl();
		parent.m1();
		parent.m2();
		parent.m3();
//		parent.m4(); error: Private 접근 제한자 -> 동일 클래스에서만 접근 가능
	}
}
