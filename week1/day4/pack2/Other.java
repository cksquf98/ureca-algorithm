package com.ureca.pack2;

import com.ureca.pack1.AccessControl;

public class Other {
	void callTest() {
		AccessControl parent = new AccessControl();
		parent.m1();
//		parent.m2(); error: Protected -> 동일 패키지 or 상속받은 자식에서만 접근 가능
//		parent.m3(); error: Default -> 동일 패키지에서만 접근 가능
//		parent.m4(); error: Private 접근 제한자 -> 동일 클래스에서만 접근 가능
	}
}
