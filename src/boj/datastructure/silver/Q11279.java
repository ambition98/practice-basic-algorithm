package boj.datastructure.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11279 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		MyHeap heap = new MyHeap(100001);
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input == 0) {
				sb.append(heap.poll()).append("\n");
			} else {
				heap.offer(input);
			}
		}
		
		System.out.println(sb);
	}
	
	
	private static class MyHeap {
		int[] heap;
		int size;
		
		MyHeap(int capacity) {
			heap = new int[capacity + 1];
			size = 0;
		}
		
		void offer(int data) {
			int target = size + 1;
			int parent = target / 2;
			
			while(target > 1 && data > heap[parent]) {
				heap[target] = heap[parent];
				
				target = parent;
				parent = target / 2;
			}
			
			heap[target] = data;
			size++;
		}
		
		int poll() {
			if(size == 0)
				return 0;
			
			int data = heap[1];
			heap[1] = heap[size];
			heap[size--] = 0;
			
			int target = heap[1];
			int parent = 1;
			int lChild = 2;
			while(lChild <= size) {
				int rChild = parent * 2 + 1;
				int child = -1;
				
				if(rChild <= size && heap[lChild] < heap[rChild])
					child = rChild; 
				else
					child = lChild;
				
				
				if(target > heap[child])
					break;
				
				heap[parent] = heap[child];
				parent = child;
				lChild = parent * 2;
			}
			
			heap[parent] = target;
			
			return data;
		}
	}
}