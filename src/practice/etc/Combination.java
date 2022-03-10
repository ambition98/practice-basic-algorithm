package practice.etc;

import java.util.ArrayList;

public class Combination {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		boolean[] visited = new boolean[arr.length];
		int n = arr.length;
		int r = 3;
		
		ArrayList<ArrayList<Integer>> combiList = new ArrayList<ArrayList<Integer>>();
		combination(arr, visited, 0, n, r, combiList);
		
		for(ArrayList<Integer> combi : combiList) {
			for(int i : combi) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	
	private static void combination(int[] arr, boolean[] visited, int start, int n, int r, ArrayList<ArrayList<Integer>> combiList) {
		if(r == 0) {
//			print(arr, visited, n);
			ArrayList<Integer> combi = new ArrayList<Integer>();
			setCombi(arr, visited, n, combi);
			combiList.add(combi);
			return;
		}
		
		for(int i=start; i<n; i++) {
			visited[i] = true;
			combination(arr, visited, i+1, n, r-1, combiList);
			visited[i] = false;
		}
	}
	
	private static void setCombi(int[] arr, boolean[] visited, int n, ArrayList<Integer> combi) {
		for(int i=0; i<n; i++) {
			if(visited[i]) {
				combi.add(arr[i]);
			}
		}
	}
//	private static void print(int[] arr, boolean[] visited, int n) {
//		for(int i=0; i<n; i++) {
//			if(visited[i]) {
//				System.out.print(arr[i] + " ");
//			}
//		}
//		System.out.println();
//	}
}
