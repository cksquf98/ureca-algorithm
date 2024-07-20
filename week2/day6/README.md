# Day6
### Collection 실습

- Set Interface
    - 중복 제거
    - 순서 보장X
    
    ```java
    Set<String> set = new HashSet<>();
    
    set.add("element1");
    set.add("element1"); //중복데이터
    set.add("element2");
    set.add(null);
    set.add(null);
    
    //요소 출력
    System.out.println(set.toString());
    
    //요소 하나하나 출력
     1. for(String str :set) { System.out.println(str); }
    	  
     2. Iterator<String> it = set.iterator();
    	  while(it.hasNext()) { System.out.println(it.next()); }
    
    //배열로 변환
    String[] strArr = new String[set.size()];
    set.toArray(strArr);
    ```
    
- Map Interface
    - Key, Value 저장
    - Key : 유일한 값 → 중복X, 중복 키값 들어오면 데이터 덮어씌워짐
    - Value : 데이터 → 중복O
    
    ```java
    Map<String, Object> map = new HashMap<>();
    
    map.put("name", "홍길동");  --> String Object
    map.put("age",  13);  --> Integer Object
    map.put("job",  "학생"); --> String Object
    
    //데이터 출력
    System.out.println(map.get("keyName"));
    
    //키 삭제
    map.remove("keyName");
    
    //데이터 수정
    map.replace("keyName", "수정할데이터");
    
    //전체 데이터 출력
    1. System.out.println("map.toString()="+ map);  --> { 키=데이터 } 출력
    
    2. Collection<String> col = map.values();
    	 Iterator<String> it =  col.iterator();
    	 while(it.hasNext()) { System.out.println(it.next()); }
    	 
    3. // forEach        
    	  map.forEach((key, value) -> {
    		  System.out.println(key + " : " + value);        
    		 });
    ```
    

---

## 알고리즘 문제

### 백준 1244

- 나는 입력 받은 숫자 -1 을 인덱스로 쓰려했는데 이러니까 헷갈렸음

```java
내가 푼 거
public static void main(String[] args) throws Exception {
		
		//남학생 : 배수 스위치를 반대로
		//여학생 : 좌우 대칭 체크 -> 대칭인 구간 전부 반대로 스위치
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int switchNum = Integer.parseInt(br.readLine());
		
		int[] switchArr = new int[switchNum];
		
		String s = br.readLine();
		StringTokenizer tokens = new StringTokenizer(s, " ");
		
		
		//스위치 상태 배열에 넣기
		int i = 0;
		while(tokens.hasMoreTokens()) {
			switchArr[i] = Integer.parseInt(tokens.nextToken());
			i++;
		}
		
		//===========================================================
		int studentNum = Integer.parseInt(br.readLine());
		for(int j=0; j<studentNum;j++) {
			s = br.readLine();
			tokens = new StringTokenizer(s, " ");
			
			int gender = 0;
			int num = 0;
			while(tokens.hasMoreTokens()) {
				gender = Integer.parseInt(tokens.nextToken());
				num = Integer.parseInt(tokens.nextToken())-1;
			}
			
			//남학생
			if(gender == 1)
			{
				for (int k = num; k < switchNum; k += num+1) {
					if(switchArr[k] == 0) 
						switchArr[k] = 1;
					else
						switchArr[k] = 0;
				}
			}
			
			//여학생
			else
			{
				int k = 0; //대칭 비교 인덱스
				while(true) {
					if(num-k < 0 || num+k > switchNum-1)	break;
					
					if(switchArr[num-k] == switchArr[num+k]) {
						if(switchArr[num-k] == 0) {
							switchArr[num-k] = 1;
							switchArr[num+k] = 1;
							k++;
						}
						else {
							switchArr[num-k] = 0;
							switchArr[num+k] = 0;
							k++;
						}
					}
					else
						break;
				}
			}
		}
		
		// 출력 - 20개씩 출력
        for (int p = 0; p < switchNum; p++) {
            System.out.print(switchArr[p] + " ");
            if ((p + 1) % 20 == 0) { 
                System.out.println();
            }
        }
        System.out.println(); // 마지막 줄
	}
}
```

```java
class Answer - Scanner 버전 {
	//시간제한 2초쯤 되면 Scanner ㄱㅊ긴 함
	public static void main(String[] args) {
		
	
	Scanner sc = new Scanner(System.in);
	
	//스위치 개수 입력
	int N = sc.nextInt();
	
//	int[] switchArr = new int[N];
	int[] switchArr = new int[N+1]; //1 ~ N번 스위치를 사용하기 때문에 N+1 배열로 만들기
	
	for(int i=1; i<=N; i++) {
		switchArr[i] = sc.nextInt();
	}
	
	
	//학생 수 입력
	int studentNum = sc.nextInt();
	
	for (int i = 0; i < studentNum; i++) {
		int gender = sc.nextInt();
		int startNum = sc.nextInt(); //스위치 시작번호
		
		if(gender == 1)
		{
			//남학생: 시작번호 기준으로 배수를 스위치
			for (int j = startNum; j <= N; j += startNum) {
				switchArr[j] = (switchArr[j] == 0)? 1 : 0;
			}
		}
		else
		{
			//여학생: 시작번호 기준으로 대칭 확인 후 스위치 -> 대칭아니거나 배열 끝이면 break
			//좌우 비교할 길이가 다를 수 있으므로 최소 비교 길이를 구하자!
			int limit = startNum;
			
			if(N - startNum +1 < startNum) limit = N - startNum +1; 
			// <-------------------->
			// <-------><----------->
			// startNum  N-startNum+1
			
			
			//1.선택된 스위치는 무조건 변경
			if(switchArr[startNum]==0) switchArr[startNum] = 1;
			else switchArr[startNum] = 0;
			
			//2.대칭 비교
			//전체 비교횟수: j, 왼쪽으로 이동하는 애: left, 오른쪽으로 이동하는 애: right
			for (int j = 0, left = startNum-1, right = startNum+1;
					j < limit; j++,left--,right++) {
				
				if(switchArr[left] != switchArr[right]) break;
				
				switchArr[left] = (switchArr[left] == 0)? 1 : 0;
						
				switchArr[right] = (switchArr[right] == 0)? 1 : 0;
			}
		}
	}
	
	//3.출력 - 20개씩
	for (int i = 1; i <= N; i++) {
		System.out.print(switchArr[i] + " ");
		
		if(i % 20 == 0)
			System.out.println();
	}
	
	sc.close();
	}
}
```

### 입력

- BufferedReader - Scanner  동시사용 금지 : 둘다 System.in에서 입력을 받아와야 하기 때문

- Integer.parseInt(**”1 2”**)  ⇒  NumberFormatException!
    
                                         ⇒  ***StringTokenizer*** 사용해서 공백 구분
    

- ***StringTokenizer***
    - 구분자로 구분된 문자열을 배열에 저장
    - 구분자 default = 공백
    
    <aside>
    💡 StringTokenizer tokens = **new** StringTokenizer(문자열, 구분자);
    
    </aside>
    

### 출력

- StringBuilder : 다음 수업에서 등장

---

### [백준 12891](https://www.acmicpc.net/problem/12891)

- **슬라이딩 윈도우 : 고정된 너비**
- **투포인터 : 가변 너비의 윈도우**

[![Untitled](https://file.notion.so/f/f/90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09/127d1bfe-0f4c-49a4-a345-c042fdd5fd0b/Untitled.png?id=723db8f5-6944-43d8-9c7d-28965b5138b5&table=block&spaceId=90f0cea1-2c0a-45ef-8fdd-d99b6da3fa09&expirationTimestamp=1721548800000&signature=yxPzumol7sqWlUl8gZLA-m0X9xCY_gbliHB_s2LXe0g&downloadName=Untitled.png)

- 크기 100 배열
    - if 연속된 10개의 숫자를 더해서 가장 큰 합계 구하기
    
           ⇒  윈도우 이동하면서 겹치는 덧셈식이 있음 ( 9개 그대로  - 맨앞 + 맨뒤 )
    

- 나는 해쉬맵 생각해서 풀긴 했는데 좋은 방법인진 몰겠음 - 푸는데도 오래걸림 -__-

```java
class Main_BJ_12891_DNA비밀번호 {
 static Map<String, Integer> check = new HashMap<>();
    static int countCheck() {
        String[] alphabet = {"A", "C", "G", "T"};
        for(String s : alphabet) {
            if(check.get(s+s) > check.get(s)) return 0;
        }
        return 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");

        int totalLength = Integer.parseInt(tokens.nextToken());
        int windowLength = Integer.parseInt(tokens.nextToken());
        int count = 0;

        String str = br.readLine();
        char[] DNA = str.toCharArray();

        tokens = new StringTokenizer(br.readLine(), " ");

        //알파벳 조건
        check.put("AA", Integer.parseInt(tokens.nextToken())); //얘가 조건
        check.put("A", 0); //얘가 count

        check.put("CC", Integer.parseInt(tokens.nextToken()));
        check.put("C", 0);

        check.put("GG", Integer.parseInt(tokens.nextToken()));
        check.put("G",0);

        check.put("TT", Integer.parseInt(tokens.nextToken()));
        check.put("T", 0);

//        System.out.println("* check = "+ check.toString());

        for (int i = 0; i < windowLength; i++) {
            String c = String.valueOf(DNA[i]);
            check.put(c, check.get(c)+1);
        }
        count += countCheck();

//        System.out.println("First check = "+ check.toString());

        //윈도우 움직이기
        for (int i = 1; i+windowLength <= totalLength; i++) {
            String origin = String.valueOf(DNA[i - 1]);
            check.put(origin, check.get(origin)-1);

            String newChar = String.valueOf(DNA[i+windowLength-1]);
            check.put(newChar, check.get(newChar)+1);

//            System.out.println(i+"번째 check = "+ check.toString());
            count += countCheck();
        }
        System.out.println(count);
    }
  }
}
```

- 답안 - 실제 카운팅에 Map을 사용
    - ((내꺼랑 구조는 대충 비슷한데 메모리랑 시간 훨씬 효율성 있는듯 → int배열 쓰는게 낫군))
    - 3대 인터페이스 **List, Set, Map** : ***Wrapper 클래스*** (= 값이 아니라 주소값을 참조)사용!!
    - 함수 간 변수 공유하는 방법 :
        1. 자원을 멤버변수로 선언( 전제조건: 두 함수가 한 클래스 안에 있어야 함 )
        2. 파라미터로 변수 전달
        
    
    ※ Static : 식구끼리 자원 공유  ⇒ 
    
        main 함수가 static이기 때문에 얘가 사용하는 리소스들도 static이여야 함!!
    

```java
class Answer12891 {
	static int[] ACGT;
	
	static boolean check(Map<Character, Integer> ACGT_count) {
		for (Character key : ACGT_count.keySet()) {
			if(key == 'A')
			{
				if(ACGT[0] > ACGT_count.get(key)) return false;
			}
			if(key == 'C')
			{
				if(ACGT[1] > ACGT_count.get(key)) return false;
			}
			if(key == 'G')
			{
				if(ACGT[2] > ACGT_count.get(key)) return false;
			}
			if(key == 'T')
			{
				if(ACGT[3] > ACGT_count.get(key)) return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		
	System.setIn(new FileInputStream("input.txt"));
	Scanner sc = new Scanner(System.in);
	
	int strLength = sc.nextInt(); //DNA 문자열길이
	int sublength = sc.nextInt(); //부분문자열 길이
	
	String dna = sc.nextLine();   //DNA 문자열
	
	ACGT = new int[4];	  //최소 출현 횟수 저장
	for (int i = 0; i < 4; i++) {
		ACGT[i] = sc.nextInt();
	}
	
	Map<Character, Integer> ACGT_count= new HashMap<>();  //실제 출현 횟수 저장
	ACGT_count.put('A', 0);
	ACGT_count.put('C', 0);
	ACGT_count.put('G', 0);
	ACGT_count.put('T', 0);
	
	//가장 처음 윈도우창
	for (int i = 0; i < sublength; i++) {
		ACGT_count.put(dna.charAt(i), ACGT_count.get(dna.charAt(i))+1);
	}
	
	
	//윈도우창 이동 전 결과 체크
	int answer = 0;
	if(check(ACGT_count)) answer++;
	
	
	//윈도우창 이동
	for (int i = 1; i+sublength <= strLength; i++) {
		char del = dna.charAt(i-1);
		char add = dna.charAt(i+sublength-1);
		
		ACGT_count.put(del, ACGT_count.get(del)-1);
		ACGT_count.put(add, ACGT_count.get(add)+1);
		
		if(check(ACGT_count)) answer++;
	}
	
	sc.close();
	
	}
}
```
