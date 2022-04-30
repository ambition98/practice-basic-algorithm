package boj.graph.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q7576 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		ArrayList<Pos> goodTomato = new ArrayList<Pos>(n * m);
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<m; j++) {
				int tomato = Integer.parseInt(st.nextToken());
				arr[i][j] = tomato;
				
				if(tomato == 1)
					goodTomato.add(new Pos(i, j));
			}
		}
		
		int left = 0;
		int right = goodTomato.size();
		int res = -1;
		int currentQueueSize = right - left;
		int[] moveX = {-1, 1, 0, 0};
		int[] moveY = {0, 0, -1, 1};
		
		while(left < right) {
			for(int i=0; i<currentQueueSize; i++) {
				Pos current = goodTomato.get(left++);
				
				for(int j=0; j<moveX.length; j++) {
					int nextX = current.x + moveX[j];
					int nextY = current.y + moveY[j];
					
					if(nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr[0].length)
						continue;
					
					if(arr[nextX][nextY] == 1 || arr[nextX][nextY] == -1)
						continue;
					
					goodTomato.add(new Pos(nextX, nextY));
					right++;
					arr[nextX][nextY] = 1;
					
				}
			}
			
			currentQueueSize = right - left;
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
			System.out.println(res);
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
