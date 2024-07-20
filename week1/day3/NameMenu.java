package com.uplus;

//데이터에 대한 비즈니스 로직 처리
//CRUD
public class NameMenu {
		//데이터 저장소
		private String []names = new String[5];		// -> 멤버 필드 : 기본값(null)으로 자동 초기화
		
		
		public void addName(String name)
		{
			for (int i = 0; i < 5; i++) {
				if(names[i] == null)
				{
					names[i] = name;
					break;
				}
			}
		}
		
		
		public String[] search()
		{
			return names;
		}
		
		
		//파라미터로 넘어오는 변수들은 새로 복사된다고 했던 기억이- => originName/newName 새로 메모리 할당됨
		public void modify(String originName, String newName)
		{
			for(int i=0; i<5;i++) {
				if(names[i].equals(originName))  // => ' == ' 연산자를 통해 비교하면 다른 결과가 나옴
				{
					names[i] = newName;
					break;
				}
				else
					continue;
			}
		}
		
		
		public void delete(String input)
		{
			for(int i=0; i<5;i++) {
				if(names[i].equals(input))
				{
					names[i] = "";
					break;
				}
				else
					continue;
			}
		}
}