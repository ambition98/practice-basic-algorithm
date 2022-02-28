package boj.dp.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11727 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] memo = new int[n + 1];
		
		int res = tile(n, memo);
		
		System.out.println(res);
	}
	
	private static int tile(int n, int[] memo) {
		if(n == 1) return 1;
		if(n == 2) return 3;
		if(memo[n] != 0) return memo[n];
		
		return memo[n] = (tile(n-2, memo)*2 + tile(n-1, memo)) % 10007;
	}
}
