package boj.greedy.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2217 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] rope = new int[n];
		for(int i=0; i<n; i++)
			rope[i] = Integer.parseInt(br.readLine());

		Arrays.sort(rope);
		
		int weight = 0;
		for(int i=n-1; i>=0; i--) {
			weight = Math.max(weight, (n-i) * rope[i]);
		}
		
		System.out.println(weight);
	}
}
