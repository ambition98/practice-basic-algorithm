package boj.datastructure.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1920 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int element = Integer.parseInt(st.nextToken());
			
			sb.append(binarySearch(arr, element, 0, n-1))
			  .append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	private static int binarySearch(int[] arr, int data, int start, int end) {
		int index = (end + start) / 2;
		
		if(data == arr[index])
			return 1;
		
		if(start > end)
			return 0;
		
		if(data > arr[index]) {
			return binarySearch(arr, data, index+1, end);
		} else {
			return binarySearch(arr, data, start, index-1);
		}
		
	}
}

