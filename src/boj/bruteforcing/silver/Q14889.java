package boj.bruteforcing.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q14889 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[] seq = new int[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			seq[i] = i;
		}
		
		ArrayList<int[]> team = new ArrayList<int[]>();
		boolean[] visited = new boolean[n];
		combination(seq, visited, 0, n/2, team, n/2);
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<team.size()/2; i++) {
			int sum1 = 0, sum2;
			ArrayList<int[]> couple = new ArrayList<int[]>();
			boolean[] visited2 = new boolean[team.get(i).length];
			combination(team.get(i), visited2, 0, 2, couple, 2);
			sum1 = getSum(arr, couple);
			
			couple = new ArrayList<int[]>();
			visited2 = new boolean[team.get(i).length];
			combination(team.get(team.size()-i-1), visited2, 0, 2, couple, 2);
			sum2 = getSum(arr, couple);
			
			min = Math.min(min, Math.abs(sum1 - sum2));
			
		}
		
		System.out.println(min);
	}
	
	private static int getSum(int[][] arr, ArrayList<int[]> couple) {
		int sum = 0;
		
		for(int i=0; i<couple.size(); i++) {
			int x = couple.get(i)[0];
			int y = couple.get(i)[1];
			
			sum += arr[x][y] + arr[y][x];
		}
		
		return sum;
	}
	
	private static void combination(int[] arr, boolean[] visited, int start, int r
			, ArrayList<int[]> res, int len) {
		
		if(r == 0) {
			int[] temp = new int[len];
			
			int idx = 0;
			for(int i=0; i<arr.length; i++) {
				if(visited[i])
					temp[idx++] = arr[i];
			}
			
			res.add(temp);
			return;
		}
		
		for(int i=start; i<arr.length; i++) {
			visited[i] = true;
			combination(arr, visited, i+1, r-1, res, len);
			visited[i] = false;
		}
	}
}
