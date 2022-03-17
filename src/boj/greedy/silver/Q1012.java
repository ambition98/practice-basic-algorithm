package boj.greedy.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1012 {
	static int[] moveX = {-1, 1, 0, 0};
	static int[] moveY = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		int[] answer = new int[testCase];
		int answerIndex = 0;
		
		for(int i=0; i<testCase; i++) {
			ArrayList<Pos> cabbage = new ArrayList<Pos>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[][] field = new int[n][m];
			
			for(int j=0; j<k; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				cabbage.add(new Pos(y, x));
				field[y][x] = 1;
			}
			
			for(Pos p : cabbage) {
				if(field[p.x][p.y] == 0)
					continue;
				
				dfs(field, p);
				answer[answerIndex]++;
			}
			answerIndex++;
		}
		
		for(int i : answer)
			System.out.println(i);
	}//main
	
	private static void dfs(int[][] arr, Pos pos) {
		arr[pos.x][pos.y] = 0;
		
		for(int i=0; i<moveX.length; i++) {
			int nextX = pos.x + moveX[i];
			int nextY = pos.y + moveY[i];
			
			if(nextX >= 0 && nextY >= 0 && nextX < arr.length && nextY < arr[0].length && arr[nextX][nextY] == 1)
				dfs(arr, new Pos(nextX, nextY));
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

