package practice.sort;
/**
 * N: 100,000
 * 
 * 평균수행시간: 13ms
 * 최악수행시간: 4ms
 */
public class MergeSort extends MySort{
	private static final String SORT_NAME = "MergeSort";
	private int[] sortedArr;
	
	public MergeSort() {
		super(SORT_NAME);
		
	}
	
	@Override
	public void sort(int[] arr) {
		sortedArr = new int[arr.length];
		mergeSort(arr, 0, arr.length-1);
	}
	
	private void mergeSort(int[] arr, int left, int right) {
		if(left >= right)
			return;
		
		int middle = (left + right) / 2;
		mergeSort(arr, left, middle);
		mergeSort(arr, middle+1, right);
		merge(arr, left, middle, right);
	}
	
	private void merge(int[] arr, int left, int middle, int right) {
		int i = left;
		int j = middle + 1;
		int k = left;
		
		while(i <= middle && j <= right) {
			if(arr[i] <= arr[j])
				sortedArr[k] = arr[i++];
			else
				sortedArr[k] = arr[j++];
			
			k++;
		}
		
		if(i > middle) { //left ~ middle 배열을 끝까지 순회했을 경우
			for(; j<=right; j++) {
				sortedArr[k++] = arr[j];
			}
		} else {
			for(; i<=middle; i++) {
				sortedArr[k++] = arr[i];
			}
		}
		
		for(int ii=left; ii<=right; ii++) {
			arr[ii] = sortedArr[ii];
		}
	}
}
