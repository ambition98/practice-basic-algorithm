package boj.datastructure.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q10845 {

	public static void main(String[] args) throws Exception {
		MyQueue queue = new MyQueue();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
			case "push":
				queue.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(queue.pop()).append("\n");
				break;
			case "size":
				sb.append(queue.size).append("\n");
				break;
			case "empty":
				sb.append(queue.empty()).append("\n");
				break;
			case "front":
				sb.append(queue.front()).append("\n");
				break;
			case "back":
				sb.append(queue.back()).append("\n");
				break;
			}

		}
		
		System.out.println(sb);
	}
	
	private static class MyQueue {
		Node head;
		Node tail;
		int size;
		
		MyQueue() {
			size = 0;
		}
		
		void push(int value) {
			Node node = new Node(value);
			
			if(size == 0) {
				head = tail = node;
				size++;
			} else {
				tail.next = node;
				tail = node;
				size++;
			}
		}
		
		int pop() {
			if(size == 0)
				return -1;
			
			int value = head.data;
			head = head.next;
			size--;
			
			if(size == 0)
				tail = null;
			
			return value;
		}
		
		int size() {
			return size;
		}
		
		int empty() {
			return size == 0 ? 1 : 0;
		}
		
		int front() {
			return head == null ? -1 : head.data;
		}
		
		int back() {
			return tail == null ? -1 : tail.data;
		}
		
		private static class Node {
			int data;
			Node next;
			
			Node(int value) {
				this.data = value;
			}
		}
	}
}

