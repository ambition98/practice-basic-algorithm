package boj.sort.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q10816 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> cardMap = new HashMap<>(); //(숫자:가진 갯수)
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int card = Integer.parseInt(st.nextToken());
            cardMap.computeIfPresent(card, (k, v) -> v+1);
            cardMap.putIfAbsent(card, 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int card = Integer.parseInt(st.nextToken());
            sb.append(cardMap.getOrDefault(card, 0)).append(" ");
        }

        System.out.println(sb.toString());
    }
}