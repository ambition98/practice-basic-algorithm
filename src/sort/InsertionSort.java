package sort;
/**
 * N: 100,000
 * 
 * 평균수행시간: 3416ms
 * 최악수행시간: 1ms
 */
public class InsertionSort extends MySort {
	private static final String SORT_NAME = "InsertionSort";
	
	public InsertionSort() {
		super(SORT_NAME);
	}

	@Override
	public int[] sort(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			int key = arr[i];
			
			int j;
			for(j=i-1; j>=0 && arr[j] > key; j--) {
				arr[j+1] = arr[j];
			}
			
			arr[j+1] = key;
		}
		
		return arr;
	}
}
