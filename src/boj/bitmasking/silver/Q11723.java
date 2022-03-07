package boj.bitmasking.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q11723 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int set = 0;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			
			int num = 0;
			if(st.hasMoreTokens())
				num = 1 << (Integer.parseInt(st.nextToken()) - 1);
			
			switch(op) {
			case "add":
				set |= num;
				break;
				
			case "remove":
				set &= ~num;
				break;
				
			case "check":
				if((set & num) == num)
					bw.write('1');
				else
					bw.write('0');
				
				bw.write("\n");
				break;
				
			case "toggle":
				set ^= num;
				break;
				
			case "all":
				set = 1048575;
				break;
				
			case "empty":
				set = 0;
				break;
			}
			
		}
		bw.flush();
	}
}
