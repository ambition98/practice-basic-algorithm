package boj.datastructure.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q1966 {

	public static void main(String[] args) throws Exception {
		Deque<Integer> deque = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			deque.offerLast(i+1);
		}
		
		while(deque.size() != 1) {
			deque.pollFirst();
			
			deque.offerLast(deque.pollFirst());
		}
		
		System.out.println(deque.poll());
	}
}

