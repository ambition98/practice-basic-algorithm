package boj.datastructure.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012 {

	public static void main(String[] args) throws Exception {
		Stack<Character> stack = new Stack<Character>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		boolean isVPS = true;
		for(int i=0; i<t; i++) {
			char[] input = br.readLine().toCharArray();
			
			for(int j=0; j<input.length; j++) {
				if(input[j] == '(') {
					stack.push(input[j]);
					continue;
				}
				
				if(!stack.isEmpty()) {
					stack.pop();
				} else {
					isVPS = false;
					break;
				}
			}
			
			if(isVPS && stack.isEmpty())
				sb.append("YES").append("\n");
			else
				sb.append("NO").append("\n");
			
			isVPS = true;
			stack.clear();
		}
		
		System.out.println(sb);
	}
}
