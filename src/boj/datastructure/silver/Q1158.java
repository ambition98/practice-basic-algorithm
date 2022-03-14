package boj.datastructure.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1158 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int element = 0;
		boolean isPossible = true;
		for(int i=0; i<n; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input <= element) { // pop 해야 하는경우
				while(true) {
					int temp = stack.pop();
					sb.append("-").append("\n");
					
					if(temp == input) {
						break;
					}
					
					if(temp > input) {
						isPossible = false;
						break;
					}
				}
				
			} else {
				while(input != element) {
					stack.push(++element);
					sb.append("+").append("\n");
				}
				
				stack.pop();
				sb.append("-").append("\n");
			}
			
			
			if(!isPossible) {
				sb.replace(0, sb.length()-1, "NO");
				break;
			}
		}
		
		System.out.println(sb);
	}
	
}