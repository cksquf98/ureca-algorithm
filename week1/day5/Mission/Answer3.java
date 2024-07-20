package com.ureca.Mission;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Answer3 {

	public static void main(String[] args) {

		// TreeSet : 순서&정렬 보장 Set!
		Set<Integer> set = new TreeSet<>();// HashSet<>();

		Random r = new Random();
		while (true) {
			set.add(r.nextInt(45) + 1);
			if (set.size() == 6)
				break;
		}

		System.out.println(set);

	}// main

}// end class
