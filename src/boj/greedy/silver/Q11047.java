package boj.greedy.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11047 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] kindOfCoin = new int[n];
		
		for(int i=0; i<n; i++)
			kindOfCoin[i] = Integer.parseInt(br.readLine());
		
		int count = 0;
		for(int i=n-1; i>=0; i--) {
			int temp = k / kindOfCoin[i];
			
			if(temp > 0) {
				k %= kindOfCoin[i];
				count += temp;
			}
		}
			
		System.out.println(count);
	}
}
