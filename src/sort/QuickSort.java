package sort;

import java.util.Stack;
/**
 * N: 100,000
 * 
 * 평균수행시간: 28ms
 * 최악수행시간: 5001ms
 */
public class QuickSort extends MySort {
	private static final String SORT_NAME = "QuickSort";
	
	public QuickSort() {
		super(SORT_NAME);
	}
	
	// n 크기가 커서 재귀적으로 구현 시 Stack Overflow 발생
	// 따라서 스택으로 변경
	@Override
	public int[] sort(int[] arr) {
		Stack<QuickSortElement> stack = new Stack<QuickSortElement>();
//		if(start >= end)
//			return arr;
		stack.push(new QuickSortElement(0, arr.length-1));
		while(!stack.isEmpty()) {
			QuickSortElement element = stack.pop();
			int start = element.start;
			int end = element.end;
			int i = start + 1;
			int j = end;
			
			while(i <= j) {
				while(i <= end && arr[start] >= arr[i]) {
					i++;
				}
				
				while(j > start && arr[start] <= arr[j]) {
					j--;
				}
				
				if(i > j) {
					int temp = arr[start];
					arr[start] = arr[j];
					arr[j] = temp;
				} else {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
			if(start < end) {
				stack.push(new QuickSortElement(j+1, end));
				stack.push(new QuickSortElement(start, j-1));
			}
			
		}
		
		return arr;
	}
	
	private class QuickSortElement {
		private int start;
		private int end;
		
		QuickSortElement(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
