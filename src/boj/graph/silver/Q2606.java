package boj.graph.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2606 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		int vertex = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());
		
		//정점 0 사용 안함
		for(int i=0; i<=vertex; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<edge; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}

		boolean[] visited = new boolean[vertex+1];
		
		int cnt = bfs(graph, visited, 1, -1);
		
		System.out.println(cnt);
	} //main

	private static int bfs(ArrayList<ArrayList<Integer>> arr, boolean[] visited, int start, int cnt) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(start);
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			if(!visited[current]) {
				cnt++;
				visited[current] = true;
				
				for(int i=0; i<arr.get(current).size(); i++) {
					queue.offer(arr.get(current).get(i));
				}
				
			} //if
		} //while
		
		return cnt;
	} //bfs
}
