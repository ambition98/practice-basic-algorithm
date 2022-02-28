package boj.greedy.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2839 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int res = n / 5;
		int temp = n % 5;
		
		if(temp != 0) {
			if(temp % 3 == 0) {
				res += temp / 3;
			} else {
				while(temp < n) {
					temp += 5;
					res--;
					
					if(temp % 3 == 0) {
						res += temp / 3;
						temp %= 3;
						break;
					}
				}
				
				if(temp != 0)
					res = -1;
			}
		}
		
		System.out.println(res);
	}
}
