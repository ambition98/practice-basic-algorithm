package boj.sort.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Q1427 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Character[] charArray = new Character[input.length()];
        for(int i=0; i<input.length(); i++) {
            charArray[i] = input.charAt(i);
        }

        Arrays.sort(charArray, Collections.reverseOrder());

        for(char c : charArray)
            System.out.print(c);

    }
}
