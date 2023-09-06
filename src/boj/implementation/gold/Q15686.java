package boj.implementation.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15686 {

    private static class Main {
        static ArrayList<Node> house;
        static ArrayList<Node> chicken;
        static boolean[] visit;
        static int res = Integer.MAX_VALUE;

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            house = new ArrayList<>();
            chicken = new ArrayList<>();

            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<n; j++) {
                    int e = Integer.parseInt(st.nextToken());
                    switch (e) {
                        case 1: house.add(new Node(i, j)); break;
                        case 2: chicken.add(new Node(i, j)); break;
                        default: //Do nothing
                    }
                }
            }
            visit = new boolean[chicken.size()];

            combi(0, m, new ArrayList<>());
            System.out.println(res);
        }

        public static void combi(int start, int m, ArrayList<Integer> combi) {
            if (combi.size() == m) {
                getmin(combi);
                return;
            }

            for (int i=start; i<chicken.size(); i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    combi.add(i);
                    combi(i + 1, m, combi);
                    combi.remove(combi.size() - 1);
                    visit[i] = false;
                }
            }
        }

        private static void getmin(ArrayList<Integer> combi) {
            int sum = 0;
            for (Node h : house) {
                int min = Integer.MAX_VALUE;
                for (int j=0; j<combi.size(); j++) {
                    min = Math.min(min, Math.abs(h.x - chicken.get(combi.get(j)).x) + Math.abs(h.y - chicken.get(combi.get(j)).y));
                }
                sum += min;
            }
            res = Math.min(res, sum);
        }

        static class Node {
            int x, y, distance;
            Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
