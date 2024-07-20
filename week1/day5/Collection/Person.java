package com.ureca.Collection;

class Person implements Comparable<Person>{
	String name;
	int age;
	String job;
	int score;
	
	
	public Person() {
		super();
	}


	public Person(String name, int age, String job, int score) {
		this.name = name;
		this.age = age;
		this.job = job;
		this.score = score;
	}


//	@Override
//	public String toString() {
//		return "\n[ " + name + ", " + age + ", " + job + ", " + score + " ]";
//	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n[name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", job=");
		builder.append(job);
		builder.append(", score=");
		builder.append(score);
		builder.append("]");
		return builder.toString();
	}


	//Person 정렬 기준 설정하는 메서드
	@Override
	public int compareTo(Person o) {
		//나이 오름차순
//		return this.age - o.age;
		
		//이름 오름차순
//		return this.name - o.name; 문자열은 빼기 못하니까 에러
		return this.name.compareTo(o.name);
	}
}
