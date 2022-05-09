package boj.sort.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1946 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Applyier[] arr;

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) { // Test case
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            arr = new Applyier[n];

            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j] = new Applyier(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(arr, (o1, o2) -> o1.rank1 - o2.rank1);

            int answer = 1;
            int minRank = arr[0].rank2;
            for(int j=1; j<n; j++) {
                if(minRank > arr[j].rank2) {
                    minRank = arr[j].rank2;
                    answer++;
                }
            }

            sb.append(answer).append("\n");
        } //End test case

        System.out.println(sb.toString());
    }

    private static class Applyier {
        int rank1;
        int rank2;

        public Applyier(int rank1, int rank2) {
            this.rank1 = rank1;
            this.rank2 = rank2;
        }
    }
}
