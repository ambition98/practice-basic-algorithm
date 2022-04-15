package boj.datastructure.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q11286 {
    public static void main(String[] args) throws Exception {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0) {
                if(pq.isEmpty())
                    sb.append(0).append("\n");
                else
                    sb.append(pq.poll().data).append("\n");

            } else {
                pq.offer(new Node(x));
            }
        }

        System.out.println(sb.toString());
    }

    private static class Node implements Comparable<Node> {
        private int data;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public int compareTo(Node o) {
            int abs1 = Math.abs(this.data);
            int abs2 = Math.abs(o.data);

            if(abs1 == abs2) { //절댓값이 같을 경우 실제 데이터가 작은 쪽이 우선
                if(this.data < o.data)
                    return -1;
                else
                    return 1;

            } else { //기본적으로는 절댓값이 작은 쪽이 우선
                return abs1 - abs2;
            }
        }
    }
}
