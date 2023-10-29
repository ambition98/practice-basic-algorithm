package programmers.level2;

public class Q12911 {
    private int solution(int n) {
        int cnt = countOne(Integer.toBinaryString(n));
        int target = -1;

        while (cnt != target) {
            n++;
            target = countOne(Integer.toBinaryString(n));
        }

        return n;
    }

    private int countOne(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') cnt++;
        }

        return cnt;
    }
}
