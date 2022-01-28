package sort;
/**
 * N: 400,000
 * 
 * 평균수행시간 1115ms
 */
public class SelectionSort implements MySort {
	public int[] sort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			
			for(int j=i; j<arr.length; j++) {
				if(min > arr[j]) {
					min = arr[j];
					minIndex = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		
		return arr;
	}
}
