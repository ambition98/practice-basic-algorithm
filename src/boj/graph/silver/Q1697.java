package boj.graph.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1697 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
//		int[] arr = new int[Math.max(n, k) + 1];
		int[] arr = new int[1000001];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(n);
		boolean findPath = false;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int i=0; i<3; i++) {
				int next = getNext(current, i);
				
				if(next >= 0 && next < arr.length && arr[next] == 0 && next != n) {
					arr[next] = arr[current] + 1;
					if(current == k) {
						findPath = true;
						break;
					}
					
					queue.offer(next);
				}
			}
			
			if(findPath)
				break;
		}
		
		System.out.println(arr[k]);
	}
	
	private static int getNext(int idx, int state) {
		switch(state) {
		case 0:
			return idx << 1;
		case 1:
			return idx + 1;
		case 2:
			return idx - 1;
		default:
			return -1;
		}
	}
}

