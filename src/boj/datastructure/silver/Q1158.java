package boj.datastructure.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1158 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			list.add(i+1);
		}
		
		sb.append("<");
		int index = k - 1;
		for(int i=0; i<n-1; i++) {
			sb.append(list.get(index)).append(", ");
			list.remove(index);
			
			index = (index + k-1) % list.size();
		}
		sb.append(list.get(0)).append(">");
		
		System.out.println(sb);
	}
	
}