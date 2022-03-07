package boj.bitmasking.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1094 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] x = Integer.toBinaryString(Integer.parseInt(br.readLine()))
					.toCharArray();
		
		int cnt = 0;
		for(int i=0; i<x.length; i++) {
			if(x[i] == '1')
				cnt++;
		}
		
		System.out.println(cnt);
	}
}
