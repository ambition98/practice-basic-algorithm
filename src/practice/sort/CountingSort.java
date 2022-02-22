package practice.sort;
/**
 * N: 100,000
 * 
 * 평균수행시간: 2ms
 * 최악수행시간: 1ms
 * 
 * 테스트용 배열의 원소값이 0 ~ N-1으로 한정되어 있기 때문에 다음과 같은 결과가 나왔다.
 * 실제로는 사용이 매우 제한적인 정렬방법
 * 적절한 상황에 사용하면 매우 빠른 알고리즘이다. O(n)
 */
public class CountingSort extends MySort{
	private static final String SORT_NAME = "CountingSort";
	
	public CountingSort() {
		super(SORT_NAME);
	}
	
	public void sort(int[] arr) {
		int[] count = new int[arr.length]; //들어오는 배열의 원소는 0 ~ (length-1) 로 한정되어 있다.
		
		for(int i=0; i<arr.length; i++) {
			count[arr[i]]++;
		}
		
		int index = 0;
		for(int i=0; i<count.length; i++) {
			for(int j=0; j<count[i]; j++) {
				arr[index++] = i;
			}
		}
	}
}
