package boj.graph.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q4963 {
	
	//상, 우상, 우, 우하, 하, 좌하, 좌, 좌상
	private static int[] moveX = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] moveY = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0)
				break;
			
			int[][] map = new int[h][w];
			boolean[][] visited = new boolean[h][w]; 
			ArrayList<Integer> landX = new ArrayList<Integer>();
			ArrayList<Integer> landY = new ArrayList<Integer>();
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					int input = Integer.parseInt(st.nextToken());
					map[i][j] = input;
					
					if(input == 1) {
						landX.add(i);
						landY.add(j);
					}
				}
			}
			
			int cnt = 0;
			for(int i=0; i<landX.size(); i++) {
				int x = landX.get(i);
				int y = landY.get(i);
				
				if(!visited[x][y]) {
					dfs(map, visited, x, y);
					cnt++;
				}
			}
			
			answer.add(cnt);
		}
			
		answer.forEach((v) -> System.out.println(v));
	}
	
	private static void dfs(int[][] map, boolean[][] visited, int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<moveX.length; i++) {
			int nextX = x + moveX[i];
			int nextY = y + moveY[i];
			
			if(nextX >= 0 && nextY >= 0 && nextX < map.length && nextY < map[0].length
					&& map[nextX][nextY] == 1
					&& !visited[nextX][nextY]) {
				
				dfs(map, visited, nextX, nextY);
			}
		}
	}
}

