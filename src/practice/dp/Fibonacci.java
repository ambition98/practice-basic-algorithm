package practice.dp;

public class Fibonacci {
	public static void main(String[] args) {
		int n = 50;
		int[] memo = new int[n + 2];
		
		int res = fibo(n+1, memo);
		System.out.println(res);
	}
	
	private static int fibo(int n, int[] memo) {
		if(n == 1) return 1;
		if(n == 2) return 1;
		if(memo[n] != 0) return memo[n];
		
		return memo[n] = fibo(n-1, memo) + fibo(n-2, memo);
	}
}
