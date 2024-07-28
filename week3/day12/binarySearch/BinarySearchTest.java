package binarySearch;

import java.util.Arrays;

public class BinarySearchTest {

	private static int[] values = { 3, 11, 15, 20, 21, 29, 45, 59, 65, 72 };

	public static void main(String[] args) {

		// 1.반복문 사용
		System.out.println(binarySearch1(65));
		System.out.println(binarySearch1(3));
		System.out.println(binarySearch1(2));
		System.out.println(binarySearch1(46));
		System.out.println(binarySearch1(72));

		System.out.println("=========================");

		// 2.재귀호출 사용
		System.out.println(binarySearch2(65,0,values.length-1));
		System.out.println(binarySearch2(3,0,values.length-1));
		System.out.println(binarySearch2(2,0,values.length-1));
		System.out.println(binarySearch2(46,0,values.length-1));
		System.out.println(binarySearch2(72,0,values.length-1));
		
		System.out.println("=========================");
		
		System.out.println(Arrays.binarySearch(values, 65));
		System.out.println(Arrays.binarySearch(values, 3));
		System.out.println(Arrays.binarySearch(values, 2));
		System.out.println(Arrays.binarySearch(values, 46));
		System.out.println(Arrays.binarySearch(values, 72));
		
	}

	private static int binarySearch2(int key, int start, int end) {
		//예외를 막기 위한 조건
		if (start <= end) {
			int mid = (start + end) / 2;
			
			// 종료조건
			if (values[mid] == key) {
				return mid;
			}

			else if (values[mid] > key) {
				return binarySearch2(key, start, mid - 1);
			} else if (values[mid] < key) {
				return binarySearch2(key, mid + 1, end);
			}
		}
		return -1;
	}

	private static int binarySearch1(int key) {// key = 찾으려는 값

		// 지역변수는 반드시 초기화해서 사용***
		/*
		 * int start = end = mid = 0; 이렇게도 초기화가 되는군
		 */
		int start = 0;
		int end = values.length - 1;
		int mid;

		while (start <= end) {// 반복할 수 있는 조건
			mid = (start + end) / 2;

			if (values[mid] == key) {
				return mid; // 인덱스를 반환
			}

			else if (values[mid] > key) {
				end = mid - 1;
			}

			else if (values[mid] < key) {
				start = mid + 1;
			}
		}

		return -1; // 못찾은 경우 -1 리턴
	}
	
}
