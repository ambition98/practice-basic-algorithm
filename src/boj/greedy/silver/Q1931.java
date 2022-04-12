package boj.greedy.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q1931 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Time> lectureList = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lectureList.add(new Time(start, end));
        }

        Collections.sort(lectureList);

        int answer = 0;
        int p = 0;
        while(p <= lectureList.size() - 1) {
            answer++;
            Time currentLet = lectureList.get(p++);

//            System.out.println("Current lecture time: " + currentLet.start + " , " + currentLet.end);
            while(p < lectureList.size() && lectureList.get(p).start < currentLet.end) {
                p++;
            }
//            System.out.println("Pointer: " + p);
        }

        System.out.println(answer);
    }

    private static class Time implements Comparable<Time> {
        int start;
        int end;

        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if(this.end == o.end)
                return this.start - o.start;
            else
                return this.end - o.end;
        }
    }
}
