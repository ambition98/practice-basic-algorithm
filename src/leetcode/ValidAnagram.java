package leetcode;

import java.util.HashMap;

public class ValidAnagram {
    private boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            int prev = map.getOrDefault(c, 0);
            map.put(c, prev + 1);
        }

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }

        return map.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .count() == 0L;
    }
}
