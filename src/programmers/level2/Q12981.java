package programmers.level2;

import java.util.HashSet;

public class Q12981 {

    HashSet<String> set;

    public int[] solution(int n, String[] words) {
        set = new HashSet<>();
        if (words[0].length() < 2) return new int[] {1, 1};
        set.add(words[0]);

        for (int i=1; i<words.length; i++) {
            if (!isValid(words[i-1], words[i])) {
                // System.out.println("탈락단어");
                // System.out.println("idx: " + i + ", prev: " + words[i-1] + ", current: " + words[i]);
                int number = i % n + 1;
                int seq = i / n + 1;
                return new int[] {number, seq};
            }

            set.add(words[i]);
        }

        return new int[] {0, 0};
    }

    private boolean isValid(String prev, String current) {
        if (current.length() < 2)
            return false;
        if (prev.charAt(prev.length() - 1) != current.charAt(0))
            return false;
        if (set.contains(current))
            return false;

        return true;
    }
}
