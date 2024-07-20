package com.uplus;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NameMenuTest {
	
	//화면출력 & 사용자 입력 View
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		NameMenu nameMenu = new NameMenu();
		
		String input;
		do {
			System.out.print("<이름메뉴>\n1.추가 2.검색 3.수정 4.삭제 5.종료\n번호입력 ==> ");
			input = br.readLine();
			
			
			switch(input) {
			case "1":
				System.out.print("이름입력: ");
				input = br.readLine();
				
				nameMenu.addName(input);
				break;
				
			case "2":
				System.out.println("#이름목록");
				
				String[] names = nameMenu.search();
				
				for (String name : names) {
					if(name == null) continue;
					System.out.println(name);
				}
				System.out.println();
				break;
				
			case "3":
				System.out.print("기존이름입력: ");
				String originName = br.readLine();
				System.out.print("변경이름입력: ");
				String newName = br.readLine();
				
				nameMenu.modify(originName, newName);
				break;
				
			case "4":
				System.out.print("삭제이름입력: ");
				input = br.readLine();
				
				nameMenu.delete(input);
				break;
			}
		} while(input.equals("5") == false);

	System.out.println("--END--");
	}
}
