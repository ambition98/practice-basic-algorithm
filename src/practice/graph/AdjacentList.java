package practice.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjacentList {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		StringTokenizer st = null;
		
//		System.out.print("정점의 개수(1~10): ");
//		int n = Integer.parseInt(br.readLine());
//		
//		for(int i=0; i<n; i++) {
//			graph.add(new ArrayList<Integer>());
//			
//			System.out.print((i+1) + "번 정점의 연결정점(1~" + n + "): ");
//			st = new StringTokenizer(br.readLine());
//			while(st.hasMoreTokens()) {
//				graph.get(i).add(Integer.parseInt(st.nextToken()));
//			}
//		}
		
		makeTestGraph(graph);
		boolean[] isVisited = new boolean[9];
		printGraph(graph);
		
		DFS(graph, isVisited, 1);
		System.out.println();
		
		for(int i=0; i<isVisited.length; i++)
			isVisited[i] = false;
		
		BFS(graph, isVisited, 1);
	}
	
	private static void DFS(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int n) {
		visited[n] = true;
		System.out.print(n + " ");
		
		for(int i=0; i<graph.get(n).size(); i++)
			if(!visited[graph.get(n).get(i)])
				DFS(graph, visited, graph.get(n).get(i));
		
	}
	
	private static void BFS(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(n);
		visited[n] = true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");
			
			
			for(int i=0; i<graph.get(current).size(); i++) {
				int next = graph.get(current).get(i);
				
				if(!visited[next]) {
					queue.offer(next);
					visited[next] = true;
				}
			}
		}
		
	}

	private static void makeTestGraph(ArrayList<ArrayList<Integer>> graph) {
		int n = 8;
		for(int i=1; i<=n+1; i++)
			graph.add(new ArrayList<Integer>());
		
		graph.get(1).add(2);
		graph.get(1).add(3);
		graph.get(1).add(8);
		
		graph.get(2).add(1);
		graph.get(2).add(7);

		graph.get(3).add(1);
		graph.get(3).add(4);
		graph.get(3).add(5);
		
		graph.get(4).add(3);
		graph.get(4).add(5);
		
		graph.get(5).add(3);
		graph.get(5).add(4);
		
		graph.get(6).add(7);
		
		graph.get(7).add(2);
		graph.get(7).add(6);
		graph.get(7).add(8);
		
		graph.get(8).add(1);
		graph.get(8).add(7);
	}
	
	private static void printGraph(ArrayList<ArrayList<Integer>> graph) {
		System.out.println("--- 연결 상태 ---");
		for(int i=1; i<graph.size(); i++) {
			System.out.println((i) + ": " + graph.get(i).toString());
		}
		System.out.println();
	}
}
