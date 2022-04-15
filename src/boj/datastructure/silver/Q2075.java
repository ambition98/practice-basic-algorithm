package boj.datastructure.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Info> pq = new PriorityQueue<Info>(); //max heap
        for (int j=0; j<N; j++) {
            pq.add(new Info(N-1, j, map[N-1][j]));
        }

        Info max;
        int a, b;
        /**
         * 1. 마지막 행은 각 열의 최댓값이므로 일단 우선순위큐에 저장
         * 2. 한 개씩 poll() 한 후 해당 열의 이전행 값(row - 1)을 큐에 저장한다.
         *    e.g. (4, 3) -> (3, 3)
         * 3. 반복한다.
         * 4. n-1번 반복하면 큐 최상단에 n번째 큰 값이 저장된다.
         *   (한 행을 미리 담아두었으므로 n-1번)
         */
        for (int i=0; i<N-1; i++) {

            max = pq.poll(); //Max heap 이므로 항상 가장 큰 값
            a = max.a;
            b = max.b;

            if (a-1 >= 0) { // 행 제한
                pq.add(new Info(a-1, b, map[a-1][b]));
            }
        }

        int ans = pq.peek().val;
        pq.clear();

        System.out.println(ans);
    }

    static class Info implements Comparable<Info>{
        int a, b;
        int val;

        public Info(int a, int b, int val) {
            this.a = a; //row
            this.b = b; //col
            this.val = val; //node data
        }

        public int compareTo(Info i) {
            return i.val - this.val;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "a=" + a +
                    ", b=" + b +
                    ", val=" + val +
                    '}';
        }
    }
}