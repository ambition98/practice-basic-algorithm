package boj.datastructure.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q2504 {
    public static void main(String[] args) throws Exception {
        Stack<String> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        boolean isPossible = true;
        for(int i=0; i<input.length(); i++) {
            String current = input.substring(i, i+1);

            if(current.equals("(") || current.equals("[")) {
                stack.push(current);

            } else if(current.equals(")") || current.equals("]")) {
                isPossible = calc(stack, current);
            }

            if(!isPossible)
                break;
        }

        //Print
        int sum = 0;
        while(!stack.isEmpty() && isPossible) {
            String s = stack.pop();
            if(isNumber(s))
                sum += Integer.parseInt(s);
            else
                isPossible = false;
        }

        if(isPossible) {
            System.out.print(sum);
        } else {
            System.out.print(0);
        }
    }

    private static boolean calc(Stack<String> stack, String bracket) {
        //여는 괄호가 나올 때 까지 pop()후 스택에 저장
        if(stack.isEmpty()) //닫는 괄호가 먼저 나왔을 경우
            return false;

        int sum = 0;
        String pair = "";
        if(bracket.equals(")"))
            pair = "(";
        else
            pair = "[";

        while(!stack.isEmpty()) {
            String next = stack.pop();

            if(isNumber(next)) { //숫자일 경우 더함
                sum += Integer.parseInt(next);
            } else if(next.equals(pair)) { //여는 괄호의 짝이 맞을 경우
                if(sum == 0) { //현 합계가 0일 경우 곱하지 않고 그대로 push()
                    if(pair.equals("("))
                        stack.push(String.valueOf(2));
                    else
                        stack.push(String.valueOf(3));

                } else if(pair.equals("(")) {
                    stack.push(String.valueOf(sum * 2));
                } else {
                    stack.push(String.valueOf(sum * 3));
                }

                break;
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
