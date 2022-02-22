package boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
 * 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 */
public class Q11726 {
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		int[] memo = new int[n + 2];
		int res = tile(n + 1, memo);
		
		System.out.println(res);
	}
	
	private static int tile(int n, int[] memo) {
		if(n == 1) return 1;
		if(n == 2) return 1;
		if(memo[n] != 0) return memo[n];
		
		return memo[n] = (tile(n-2, memo) + tile(n-1, memo)) % 10007;
	}
}
