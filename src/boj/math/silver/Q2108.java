package boj.math.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2108 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] countArr = new int[8001];
        int range = 4000;

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());

            sum += num;
            max = Math.max(max, num);
            min = Math.min(min, num);
            int currentCnt = ++countArr[num + range];
            cnt = Math.max(cnt, currentCnt);
        }

        int count=0;
        int mode_val=0;
        int mid = 8002;
        int mode = 8002;
        boolean check=false;
        for(int i=min+4000; i<=max+4000; i++) {
            if(countArr[i]>0) {
                // 중간값 탐색
                if(count<(n+1)/2) {
                    count+=countArr[i];
                    mid = i-4000;
                }

                // 최빈값 탐색
                if(mode_val<countArr[i]) {
                    mode_val = countArr[i];
                    mode = i-4000;
                    check=true;
                }else if(mode_val==countArr[i] && check) {
                    mode = i-4000;
                    check=false;
                }
            }
        }

        System.out.println(Math.round(sum / (double)n));
        System.out.println(mid);
        System.out.println(mode);
        System.out.println(max - min);
    }
}
