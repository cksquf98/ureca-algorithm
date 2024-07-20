package com.ureca.Collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class MapTest {
   public static void main(String[] args) {
	  /*
	    Map<K,V>
	    - 신발장 클래스 (신발:데이터, 열쇠:키)
	    - Key, Value(데이터!!)
	    - Key는 보통 문자열 사용, Value는 Object
	    - Key값은 중복X(유일한 값을 갖는다)
	   */
	  Map<String, Object> map = new HashMap<>();
	    //데이터 입력("홍길동",13,"학생")
	    //map.put(String key,String value);
	     map.put("name", "홍길동");
	     map.put("age",  13);//+"");
	     map.put("job",  "학생");
	     
	  Map<String, String> map2 = new HashMap<>();
	    //데이터 입력("홍길동","길라임","김주원","김유신","이순신")
	    map2.put("k1", "홍길동");
	    map2.put("k2", "길라임");
	    map2.put("k3", "김주원");
	    map2.put("k4", "김유신");
	    map2.put("k3", "이순신");//중복 키값 존재: 덮어쓰기
	    
	  //데이터 출력 (k3키에 저장된 데이터를 출력!!)
	    //map2.get(Object key)
	  System.out.println("k3키에 저장된 값: "+ map2.get("k3"));
	  
	  //특정 키삭제
	  map2.remove("k4");
	  
	  //특정 키에 저장된 데이터 수정
	  map2.replace("k3", "하순신");	  
	  
	  //전체 데이터 출력?
	  System.out.println("map2.toString()="+ map2);
	  
	  Collection<String> col =map2.values();
	  
	  Iterator<String> it =  col.iterator();
      while(it.hasNext()) {
        System.out.println(it.next());
      }
      
      //map2의  key값만 따로 얻어오기!!
      Set<String> set = map2.keySet();
      Iterator<String>  keyset = set.iterator();
      while(keyset.hasNext()) {
    	  String key = keyset.next();
    	  System.out.println(key+"==>"+ map2.get(key));
      }
      
   }
}















