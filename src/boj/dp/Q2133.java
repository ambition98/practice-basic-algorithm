package boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2133 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] memo = new int[n + 1];
		int res = tile(n, memo);
		
		System.out.println(res);
	}
	
	private static int tile(int n, int[] memo) {
		if(n == 0) return 1; //점화식 맞추는 용도. 입력 범위에 0이 빠져서 가능한 방식이다. 입력에 0이 포함되면 0을 리턴해야하기 때문에 틀리게 됨
		if(n % 2 != 0) return 0;
		if(n == 2) return 3; 
		if(memo[n] != 0) return memo[n];
			
		int res = tile(n-2, memo) * 3;
		for(int i=4; i<=n; i+=2) {
			res += 2 * tile(n-i, memo);
		}
		
		return memo[n] = res;
	}
}
