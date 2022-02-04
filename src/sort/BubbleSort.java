package sort;
/**
 * N: 100,000
 * 
 * 평균수행시간: 13902ms
 * 최악수행시간: 1978ms
 */
public class BubbleSort extends MySort{
	private static final String SORT_NAME = "BubbleSort";
	
	public BubbleSort() {
		super(SORT_NAME);
	}
	
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
