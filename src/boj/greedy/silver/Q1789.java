package boj.greedy.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1789 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long input = Long.parseLong(br.readLine());
		
		long sum = 0;
		long i = 0;
		while(sum < input) {
			sum += ++i;
		}
		
		if(sum == input)
			System.out.println(i);
		else
			System.out.println(i - 1);
	}
}
