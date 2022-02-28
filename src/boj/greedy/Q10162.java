package boj.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10162 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		int[] kindOfBtn = {300, 60, 10};
		
		if(input % 10 != 0)
			System.out.println(-1);
		else {
			for(int i=0; i<kindOfBtn.length; i++) {
				System.out.print(input / kindOfBtn[i]);
				input %= kindOfBtn[i];
				
				if(i < kindOfBtn.length-1)
					System.out.print(" ");
			}
		}
	}
}
