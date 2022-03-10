package boj.graph.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14052 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		ArrayList<Pos> virus = new ArrayList<Pos>(n * m);
		ArrayList<Pos> zero = new ArrayList<Pos>(n * m);
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2)
					virus.add(new Pos(i, j));
				else if(map[i][j] == 0)
					zero.add(new Pos(i, j));
			}
		}
		
		int maxZero = getMaxZero(map, virus, zero);
		
		System.out.println(maxZero);
	}
	
	private static int getMaxZero(int[][] map, ArrayList<Pos> virus, ArrayList<Pos> zero) {
		int n = 3; // 벽의 개수
		int maxZero = 0;
		int[] arr = new int[zero.size()];
		boolean[] visited = new boolean[zero.size()];
		ArrayList<Integer[]> combiList = new ArrayList<Integer[]>();
		
		for(int i=0; i<zero.size(); i++)
			arr[i] = i;
		
		setCombiList(arr, visited, 0, zero.size(), n, combiList);
		
//		for(Integer[] combi : combiList) {
//			for(int i : combi) {
//				System.out.print(i + " ");
//			}
//			
//			System.out.println();
//		}
		
		for(int i=0; i<combiList.size(); i++) {
			int[][] copiedMap = new int[map.length][map[0].length];
			for(int j=0; j<map.length; j++) {
				copiedMap[j] = map[j].clone();
			}
			
			Pos wall1 = zero.get(combiList.get(i)[0]);
			Pos wall2 = zero.get(combiList.get(i)[1]);
			Pos wall3 = zero.get(combiList.get(i)[2]);
			System.out.println("--- 벽 위치 ---");
			System.out.println("(" + wall1.x + ", " + wall1.y + ") (" + wall2.x + ", " + wall2.y + 
					") (" + wall3.x + ", " + wall3.y + ")");
			System.out.println();
			
			
			copiedMap[wall1.x][wall1.y] = 1;
			copiedMap[wall2.x][wall2.y] = 1;
			copiedMap[wall3.x][wall3.y] = 1;
			
			int countZero = spreadVirus(copiedMap, virus);
			maxZero = Math.max(maxZero, countZero);
			
			System.out.println("--- 벽 설치 후 바이러스 확산 결과 ---");
			for(int[] j : copiedMap) {
				for(int k : j)
					System.out.print(k + " ");
				System.out.println();
			}
			
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.println("현재 0 개수: " + countZero);
			System.out.println("갱신 후 최대 0 개수: " + maxZero);
			System.out.println("============================");
		}
		
		return maxZero;
	}
	
	private static void setCombiList(int[] arr, boolean[] visited, int start, int n, int r, ArrayList<Integer[]> combiList) {
		if(r == 0) {
			Integer[] combi = new Integer[3];
			int idx = 0;
			for(int i=0; i<n; i++) {
				if(visited[i]) {
					combi[idx++] = arr[i];
				}
			}
			
			combiList.add(combi);
			return;
		}
		
		for(int i=start; i<n; i++) {
			visited[i] = true;
			setCombiList(arr, visited, i+1, n, r-1, combiList);
			visited[i] = false;
		}
	}
	
	private static int spreadVirus(int[][] map, ArrayList<Pos> virus) {
		int maxZero = 0;
		for(int i=0; i<virus.size(); i++) {
			Pos start = virus.get(i);
			
			bfs(map, start);
		}
		maxZero = Math.max(maxZero, countZero(map));
		
		return maxZero;
	}
	
	private static void bfs(int[][] map, Pos start) {
		Queue<Pos> queue = new LinkedList<Pos>();
		int[] moveX = {-1, 1, 0, 0};
		int[] moveY = {0, 0, -1, 1};
		
		queue.offer(start);
		while(!queue.isEmpty()) {
			Pos current = queue.poll();
			
			for(int i=0; i<moveX.length; i++) {
				int nextX = current.x + moveX[i];
				int nextY = current.y + moveY[i];
				
				if(nextX >= 0 && nextY >= 0 && nextX < map.length && nextY < map[0].length && map[nextX][nextY] == 0) {
					map[nextX][nextY] = 2;
					queue.offer(new Pos(nextX, nextY));
				}
			}
		}
	}
	
	private static int countZero(int[][] arr) {
		int count = 0;
		
		for(int[] arr2 : arr) {
			for(int i : arr2) {
				if(i == 0)
					count++;
			}
		}
		
		return count;
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
