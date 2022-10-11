package boj.graph.search.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q1260 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		//정점 0 사용 안함
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}

		boolean[] visited = new boolean[n+1];
		dfs(graph, visited, start);
		System.out.println();
		
		for(int i=0;i <visited.length; i++)
			visited[i] = false;
		
		bfs(graph, visited, start);
		
	} //main

	private static void dfs(ArrayList<ArrayList<Integer>> arr, boolean[] visited, int n) {
		if(!visited[n]) {
			System.out.print(n + " ");
			visited[n] = true;
			
			int[] list = new int[arr.get(n).size()];
			for(int i=0; i<list.length; i++) {
				list[i] = arr.get(n).get(i);
			}
			
			Arrays.sort(list);
			
			for(int i=0; i<list.length; i++) {
				dfs(arr, visited, list[i]);
			}
		}
	}
	
	private static void bfs(ArrayList<ArrayList<Integer>> arr, boolean[] visited, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(start);
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			if(!visited[current]) {
				visited[current] = true;
				System.out.print(current + " ");
				
				int[] list = new int[arr.get(current).size()];
				for(int i=0; i<list.length; i++) {
					list[i] = arr.get(current).get(i);
				}
				
				Arrays.sort(list);
				
				for(int i=0; i<list.length; i++) {
					queue.offer(list[i]);
				}
			} //if
		} //while
	} //bfs
}
