package boj.datastructure.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10733 {

	public static void main(String[] args) throws Exception {
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		for(int i=0; i<k; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0)
				stack.pop();
			else
				stack.push(n);
			
		}

		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
	}
}