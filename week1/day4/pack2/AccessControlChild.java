package com.ureca.pack2;

import com.ureca.pack1.AccessControl;

public class AccessControlChild extends AccessControl{
	void callTest() {
		m1(); 
		m2();	 //상속받은 자식클래스라서 에러 안남
//		m3();	 error: 다른 패키지라서 에러 남
//		m4();    error!
	}
}
