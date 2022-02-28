package boj.sort.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 * 
 * 1. 길이가 짧은 것부터
 * 2. 길이가 같으면 사전 순으로
 */
public class Q1181 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int n = Integer.parseInt(reader.readLine());
		Word[] wordArr = new Word[n];
		for (int i = 0; i < n; i++) {
			String input = reader.readLine();
			wordArr[i] = (new Word(input));
		}
		
		Arrays.sort(wordArr);
		
		for(int i=0; i<wordArr.length; i++) {
			String s = wordArr[i].word;
			if(i > 0 && s.equals(wordArr[i-1].word))
				continue;
			
			builder.append(s).append("\n");
		}
		
		builder.deleteCharAt(builder.length()-1);
		System.out.println(builder);
		
	}

}

class Word implements Comparable<Word> {
	String word;
	
	public Word(String word) {
		this.word = word;
	}
	
	@Override
	public int compareTo(Word o) {
		if (this.word.length() > o.word.length()) {
			return 1;
			
		} else if (this.word.length() < o.word.length()) {
			return -1;
			
		} else {
			int len = this.word.length();
			
			for(int i=0; i<len; i++) {
				char a = this.word.charAt(i);
				char b = o.word.charAt(i);
				if((int)a == (int)b)
					continue;
				
				return a - b;
			}
		}
		
		return 0;
	}
	
}
