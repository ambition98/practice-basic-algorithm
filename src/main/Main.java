package main;

import sort.MySort;
import sort.SelectionSort;

public class Main {
	private static int ARRAY_LENGTH = 100000;
	private static int REPEAT_TIME = 10;
	
	public static void main(String[] args) {
		runningTest1(new SelectionSort());
		runningTest2(new SelectionSort());
	}
	
	// 정렬 되는지 길이 10의 배열로 테스트
	private static void runningTest1(MySort mySort) {
		int[] arr = getNotDupRandomArr(10);

		System.out.println("before");
		printArr(arr);
		
		mySort.sort(arr);
		
		System.out.println("\nafter");
		printArr(arr);
	}
	
	// 시간이 얼마나 걸리는지 큰 배열로 테스트
	private static void runningTest2(MySort mySort) {
		int[] arr = getRandomArr(ARRAY_LENGTH);

		long sum = 0;
		for(int i=0; i<REPEAT_TIME; i++) {
			long start = System.currentTimeMillis();
			arr = mySort.sort(arr);
			long end = System.currentTimeMillis();
			
			sum += end - start;
		}
		
		long avgRunningTime = sum / REPEAT_TIME;
		
		System.out.println("\n\n Average running time: " + avgRunningTime + "ms");
	}
	
	private static int[] getRandomArr(int length) {
		int[] arr = new int[length];
		for(int i=0; i<length; i++)
			arr[i] = (int) (Math.random() * length);
		
		return arr;
	}
	
	private static int[] getNotDupRandomArr(int length) {
		int[] arr = new int[length];
		int idx = 0;
		
		while(true) {
			boolean isDuplicated = false;
			int temp = (int) (Math.random() * length);
			for(int i : arr) {
				if(i == temp) {
					isDuplicated = true;
					break;
				}
			}
			
			if(isDuplicated)
				continue;
			else
				arr[idx++] = temp;
			
			if(idx == length - 1)
				break;
		}
		
		return arr;
	}
	
	private static void printArr(int[] arr) {
		for(int i : arr)
			System.out.print(i + " ");
	}
}
