package sort;
/**
 * N: 400,000
 * 
 * 평균수행시간 1115ms
 */
public class BubbleSort implements MySort{
	public int[] sort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		return arr;
	}
}
