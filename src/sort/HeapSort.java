package sort;
/**
 * N: 100,000
 * 
 * 평균수행시간: 16ms
 * 최악수행시간: 10ms
 */
public class HeapSort extends MySort{
	private static final String SORT_NAME = "HeapSort";
	
	public HeapSort() {
		super(SORT_NAME);
	}

	@Override
	public void sort(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			int target = i;
			do {
				int parent = (target - 1) / 2;
				if(arr[parent] < arr[target]) {
					int temp = arr[parent];
					arr[parent] = arr[target];
					arr[target] = temp;
				}
				target = parent;
			} while(target != 0);
			
		}
		
		for(int i=arr.length-1; i>=0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			int parent = 0;
			int target;
			do {
				target = 2 * parent + 1;
				if(target < i-1 && arr[target] < arr[target+1])
					target++;
				
				if(target < i && arr[parent] < arr[target]) {
					temp = arr[parent];
					arr[parent] = arr[target];
					arr[target] = temp;
				}
				parent = target;
			}while(target < i);
		}
	}
}
