package boj.greedy.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2810 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String seat = br.readLine();
		
		int i = 0;
		int holderCnt = 1;
		while(i < seat.length()) {
			holderCnt++;
			
			if(seat.charAt(i) == 'S')
				i++;
			else
				i += 2;
		}
		
		if(seat.length() < holderCnt)
			System.out.println(seat.length());
		else
			System.out.println(holderCnt);
	}
}
