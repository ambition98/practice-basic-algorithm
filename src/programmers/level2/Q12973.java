package programmers.level2;

import java.util.Stack;

public class Q12973 {
    private int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        if (stack.isEmpty()) return 1;
        else return 0;
    }

    private int[] test() {
        return new int[]{1,1};
    }
}
