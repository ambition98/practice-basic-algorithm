package boj.datastructure.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Q1966 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		int[] answer = new int[testCase];
		int answerIndex = 0;
		
		for(int i=0; i<testCase; i++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); //문서의 개수
			int m = Integer.parseInt(st.nextToken()); //찾을 문서의 index
			
			//입력
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) { // queue 입력
				int file = Integer.parseInt(st.nextToken());
				
				map.computeIfPresent(file, (k, v) -> v+1);
				map.putIfAbsent(file, 1);
				queue.offer(file);
			}
			
			// 내림차순 정렬된 우선순위 list 생성
			List<Integer> priority = map.keySet()
										.stream()
										.sorted(Collections.reverseOrder())
										.collect(Collectors.toList());
			
			int cnt = 0;
			boolean isFindTarget = false;
			while(!isFindTarget) {
				int file = queue.peek();
				
				//비교대상 탐색
				int nextPriority = priority.get(0);
				int pCount = map.get(nextPriority);
				while(pCount == 0) {
					priority.remove(0);
					nextPriority = priority.get(0);
					pCount = map.get(nextPriority);
				}
				
				if(file < nextPriority) {
					queue.offer(queue.poll());
					if(--m < 0)
						m = queue.size() - 1;
					
				} else {
					cnt++;
					queue.poll();
					map.computeIfPresent(nextPriority, (k, v) -> v-1);
					
					if(m == 0) {
						isFindTarget = true;
						answer[answerIndex++] = cnt;
						break;
					}
					
					if(--m < 0)
						m = queue.size() - 1;
					
				}
				
//				printQueue(queue);
			}
		}//for
		
		for(int i : answer)
			System.out.println(i);
		
	}//main
	
//	private static void printQueue(Queue<Integer> queue) {
//		for(int i=0; i<queue.size(); i++) {
//			int e = queue.poll();
//			System.out.print(e + " ");
//			queue.offer(e);
//		}
//		System.out.println();
//	}
}

