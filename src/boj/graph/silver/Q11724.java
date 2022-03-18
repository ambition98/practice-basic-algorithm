package boj.graph.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q11724 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<Integer>();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			union(arr, x, y);
		}
		
		for(int i=1; i<arr.length; i++) {
			set.add(findRoot(arr, i));
		}
		
		System.out.println(set.size());
	}
	
	private static void union(int[] arr, int x, int y) {
		int xRoot = findRoot(arr, x);
		int yRoot = findRoot(arr, y);
		
		if(xRoot != yRoot)
			arr[xRoot] = yRoot;
	}
	
	private static int findRoot(int[] arr, int x) {
		if(arr[x] == 0)
			return x;
		
		return arr[x] = findRoot(arr, arr[x]);
	}
}

