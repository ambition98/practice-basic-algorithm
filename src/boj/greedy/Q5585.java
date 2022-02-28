package boj.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q5585 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int change = 1000 - Integer.parseInt(br.readLine());
		int res = 0;
		int[] kindOfChange = {500, 100, 50, 10, 5, 1};
		
		for(int i : kindOfChange) {
			res += change / i;
			change %= i;
		}

		System.out.println(res);
	}
}
