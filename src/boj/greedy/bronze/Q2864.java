package boj.greedy.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2864 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int max, min;
		
		input[0] = input[0].replace("5", "6");
		input[1] = input[1].replace("5", "6");
		max = Integer.parseInt(input[0]) + Integer.parseInt(input[1]);
		
		input[0] = input[0].replace("6", "5");
		input[1] = input[1].replace("6", "5");
		min = Integer.parseInt(input[0]) + Integer.parseInt(input[1]);
		
		System.out.println(min + " " + max);
		
	}
}
