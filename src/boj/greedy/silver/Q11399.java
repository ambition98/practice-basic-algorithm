package boj.greedy.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11399 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] people = new int[n];
		for(int i=0; i<n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		//SJF
		Arrays.sort(people);
		int sum = 0;
		int total = 0;
		for(int i : people) {
			sum = sum + i;
			total += sum;
		}
		
		System.out.println(total);
	}
}
