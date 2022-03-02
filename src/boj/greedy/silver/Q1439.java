package boj.greedy.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1439 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		
		int count = 0;
		char target;
		if(input[0] == '0')
			target = '1';
		else
			target = '0';
		
		for(int i=1; i<input.length; i++) {
			if(input[i] == target) {
				int j = i+1; 
				
				while(true) {
					if(j >= input.length) {
						i = j;
						count++;
						break;
					}
					
					if(input[j] != target) {
						i = j;
						count++;
						break;
					}
					
					j++;
				}
			}
		}
		
		System.out.println(count);
	}
	
}
