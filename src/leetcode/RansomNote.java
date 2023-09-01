package leetcode;

import java.util.HashMap;

public class RansomNote {
    private boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<magazine.length(); i++) {
            char c = magazine.charAt(i);
            int prev = map.getOrDefault(c, 0);
            map.put(c, prev + 1);
        }

        for (int i=0; i<ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
