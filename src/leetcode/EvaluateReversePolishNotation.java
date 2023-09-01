package leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    private  int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<tokens.length; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));

            } else {
                int temp = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(stack.pop() + temp);
                        break;
                    case "-":
                        stack.push(stack.pop() - temp);
                        break;
                    case "*":
                        stack.push(stack.pop() * temp);
                        break;
                    default:
                        stack.push(stack.pop() / temp);
                        break;
                }
            }
        }

        return stack.pop();
    }

    private boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
