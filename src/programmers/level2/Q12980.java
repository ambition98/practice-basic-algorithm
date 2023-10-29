package programmers.level2;

public class Q12980 {
    private class Solution {
        public int solution(int n) {
            int cnt = 0;
            while (n != 0) {
                if (n % 2 == 1) {
                    n--;
                    cnt++;
                }
                n /= 2;
            }

            return cnt;
        }
    }
}
