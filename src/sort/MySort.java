package sort;
/**
 * @author YJ_Lee
 * 
 * 배열 출력, 평균시간, 최악시간 테스트용 추상클래스
 * 해당 클래스를 상속받아 실제 정렬하는 클래스를 구현 (sort() 메서드 구현 필)
 */
public abstract class MySort {
	private static final int ARRAY_LENGTH = 100000;
//	private static final int REPEAT_TIME = 5;
	private static String sortName;
	
	public MySort(String sortName) {
		MySort.sortName = sortName;
	}
	
	public abstract void sort(int[] arr);
	
	public static void run(MySort mySort) {
		System.out.println("---------- "+sortName+" ----------");
		mySort.runningTest1(mySort);
		mySort.runningTest2(mySort);
		mySort.runningTest3(mySort);
		System.out.println("\n------------------------------\n");
	}
	
	// 정렬 되는지 길이 10의 배열로 테스트
	private void runningTest1(MySort mySort) {
		int[] arr = mySort.getNotDupRandomArr(10);

		System.out.println("before");
		mySort.printArr(arr);
		
		mySort.sort(arr);
		
		System.out.println("\nafter");
		mySort.printArr(arr);
	}
	
	// 평균 시간 테스트(랜덤배열의 정렬시간)
	private void runningTest2(MySort mySort) {
		int[] arr = mySort.getRandomArr(ARRAY_LENGTH);

		long start = System.currentTimeMillis();
		mySort.sort(arr);
		long end = System.currentTimeMillis();
		
		System.out.println("\n\n Average running time: " + (end-start) + "ms");
	}
	
	// 최악 시간 테스트(역순정렬된 배열의 정렬 시간)
	private void runningTest3(MySort mySort) {
		int[] arr = mySort.getDescendingArr(ARRAY_LENGTH);

		long start = System.currentTimeMillis();
		mySort.sort(arr);
		long end = System.currentTimeMillis();
		
		System.out.println("\n\n Worst running time: " + (end-start) + "ms");
	}
	
	//중복값이 없는 랜덤배열 리턴
	//!주의: 시간이 오래걸리므로 작은 배열에서만 테스트해야함
	private int[] getNotDupRandomArr(int length) {
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
	
	private int[] getRandomArr(int length) {
		int[] arr = new int[length];
		for(int i=0; i<length; i++)
			arr[i] = (int) (Math.random() * length);
		
		return arr;
	}
	
	private int[] getDescendingArr(int length) {
		int[] arr = new int[length];
		for(int i=length-1; i>=0; i--) {
			arr[i] = i;
		}
		
		return arr;
	}
	
	private void printArr(int[] arr) {
		for(int i : arr)
			System.out.print(i + " ");
	}
}
