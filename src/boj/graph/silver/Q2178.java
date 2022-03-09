package boj.graph.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			char[] input = br.readLine().toCharArray();
			
			for(int j=0; j<m; j++) {
				arr[i][j] = input[j] - '0';
			}
		}
		
		boolean[][] visited = new boolean[n][m];
		bfs(arr, visited);
		
		System.out.println(arr[n-1][m-1]);
	} //main
	
	private static void bfs(int[][] arr, boolean[][] visited) {
		Queue<Pos> queue = new LinkedList<Pos>();
		//상 하 좌 우
		int[] moveX = {-1, 1, 0, 0};
		int[] moveY = {0, 0, -1, 1};
		
		queue.offer(new Pos(0, 0));
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Pos current = queue.poll();
			
			for(int i=0; i<moveX.length; i++) {
				int nextX = current.x + moveX[i];
				int nextY = current.y + moveY[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr[0].length)
					continue;
				
				if(arr[nextX][nextY] == 0 || visited[nextX][nextY] == true)
					continue;
				
				if(arr[nextX][nextY] == 1) {
					arr[nextX][nextY] += arr[current.x][current.y];
					queue.offer(new Pos(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
			
		}
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
