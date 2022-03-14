package boj.datastructure.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10866 {

	public static void main(String[] args) throws Exception {
		MyDeque deque = new MyDeque();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
			case "push_front":
				deque.pushFront(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				deque.pushBack(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				sb.append(deque.popFront()).append("\n");
				break;
			case "pop_back":
				sb.append(deque.popBack()).append("\n");
				break;
			case "size":
				sb.append(deque.size).append("\n");
				break;
			case "empty":
				sb.append(deque.empty()).append("\n");
				break;
			case "front":
				sb.append(deque.getFront()).append("\n");
				break;
			case "back":
				sb.append(deque.getBack()).append("\n");
				break;
			}

		}
		
		System.out.println(sb);
	}
	
	private static class MyDeque {
		Node front;
		Node back;
		int size;
		
		void pushFront(int data) {
			Node n = new Node(data);
			if(size == 0) {
				front = back = n;
				size++;
				return;
			}
			
			front.prev = n;
			n.next = front;
			front = n;
			size++;
		}
		
		void pushBack(int data) {
			Node n = new Node(data);
			
			if(size == 0) {
				front = back = n;
				size++;
				return;
			}
			
			back.next = n;
			n.prev = back;
			back = n;
			size++;
		}
		
		int popFront() {
			if(size == 0)
				return -1;
			
			int data = front.data;
			if(size == 1) {
				front = back = null;
			} else {
				front.next.prev = null;
				front = front.next;
			}
			size--;
			
			return data;
		}
		
		int popBack() {
			if(size == 0)
				return -1;
			
			int data = back.data;
			if(size == 1) {
				front = back = null;
			} else {
				back.prev.next = null;
				back = back.prev;
			}
			size--;
			
			return data;
		}
		
		int empty() { return size == 0 ? 1 : 0; }
		int getFront() { return front != null ? front.data : -1; }
		int getBack() { return back != null ? back.data : -1; }
		
		private static class Node {
			int data;
			Node next;
			Node prev;
			
			Node(int data) {
				this.data = data;
			}
		}
	}
}

