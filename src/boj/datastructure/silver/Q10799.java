package boj.datastructure.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10799 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        int cutting = 0;
        int stick = 0;
        boolean isLaser = false;

        char[] input = br.readLine().toCharArray();
        for(int i=0; i<input.length; i++) {
            char current = input[i];


            if(input[i] == '(') {
                stack.push(current);
                if(i < input.length && input[i+1] == ')')
                    isLaser = true;

            } else {
                stack.pop();

                if(isLaser) {
                    cutting += stack.size();
                    isLaser = false;
                } else {
                    stick++;
                }
            }
        }//for

        System.out.println(cutting + stick);
    }
}
