package boj.greedy.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q10610 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		Arrays.sort(input);
		
		int sum = 0;
		if(input.length % 2 != 0)
			sum += input[input.length / 2] - '0';
		
		for(int i=0; i<input.length/2; i++) {
			sum += input[i] - '0';
			
			char temp = input[i];
			input[i] = input[input.length-(i+1)];
			input[input.length-(i+1)] = temp;
			
			sum += input[i] - '0';
		}
		
		if(sum % 3 == 0 && input[input.length-1] == '0')
			System.out.println(String.valueOf(input));
		else
			System.out.println(-1);
	}
}
