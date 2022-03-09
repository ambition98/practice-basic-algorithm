package boj.graph.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		ArrayList<Pos> goodTomato = new ArrayList<Pos>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<m; j++) {
				int tomato = Integer.parseInt(st.nextToken());
				arr[i][j] = tomato;
				
				if(tomato == 1)
					goodTomato.add(new Pos(i, j));
			}
		}
		
		//처음부터 익은상태(1)인 토마토마다 각각의 큐를 가진다.
		ArrayList<Queue<Pos>> queueList = new ArrayList<Queue<Pos>>();
		
		for(int i=0; i<goodTomato.size(); i++) {
			queueList.add(new LinkedList<Pos>());
			queueList.get(i).offer(goodTomato.get(i));
		}
		
		int res = 0;
		int queueListSize = goodTomato.size(); // 모든 큐의 통합 size
//		int test = 0;
		while(queueListSize != 0) {
			for(int i=0; i<queueList.size(); i++) {
				queueListSize = oneSearchAndReturn(arr, queueList.get(i), queueListSize);
				
//				System.out.println("queueListSize: " + queueListSize);
			}
			
//			System.out.println("--- " + (++test) + " 일차---");
//			for(int[] ii : arr) {
//				for(int iii : ii)
//					System.out.print(iii + " ");
//				System.out.println();
//			}
//			System.out.println("---------------");
			
			res++;
		}
		
		boolean fail = false;
		for(int[] i : arr) {
			for(int ii : i) {
				if(ii == 0) {
					fail = true;
					break;
				}
			}
			if(fail)
				break;
		}
		
		if(fail)
			System.out.println(-1);
		else
			System.out.println(res - 1);
	}
	
	private static int oneSearchAndReturn(int[][] arr, Queue<Pos> queue, int queueListSize) {
		int[] moveX = {-1, 1, 0, 0};
		int[] moveY = {0, 0, -1, 1};
		
		//현재 큐 사이즈 만큼만 BFS(1일차를 수행)
		int currentQueueSize = queue.size();
		for(int i=0; i<currentQueueSize; i++) {
			Pos current = queue.poll();
			queueListSize--;
			
			for(int j=0; j<moveX.length; j++) {
				int nextX = current.x + moveX[j];
				int nextY = current.y + moveY[j];
				
				if(nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr[0].length)
					continue;
				
				if(arr[nextX][nextY] == 1 || arr[nextX][nextY] == -1)
					continue;
				
				queue.offer(new Pos(nextX, nextY));
				arr[nextX][nextY] = 1;
				
				queueListSize++;
			}
		}
		
		
		return queueListSize;
	}
	
	private static class Pos {
		int x;
		int y;
		
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
