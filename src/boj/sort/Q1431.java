package boj.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 시리얼번호 A가 시리얼번호 B의 앞에 오는 경우는 다음과 같다.
 * 
 * 1. A와 B의 길이가 다르면, 짧은 것이 먼저 온다.
 * 2. 만약 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)
 * 3.  만약 1,2번 둘 조건으로도 비교할 수 없으면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.
 */
public class Q1431 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int n = Integer.parseInt(reader.readLine());
		String[] serialArr = new String[n];
		for(int i=0; i<serialArr.length; i++)
			serialArr[i] = reader.readLine();
		
		Arrays.sort(serialArr, serialComparator);
		
		for(String s : serialArr)
			builder.append(s).append("\n");
		
		builder.deleteCharAt(builder.length()-1);
		System.out.println(builder);
	}
	
	static Comparator<String> serialComparator = new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			if(o1.length() != o2.length()) {
				return o1.length() - o2.length();
				
			} else {
				int sum1 = 0, sum2 = 0;
				for(int i=0; i<o1.length(); i++) {
					char c1 = o1.charAt(i);
					char c2 = o2.charAt(i);
					
					if(c1 >= '1' && c1 <= '9')
						sum1 += c1 - '0';
					
					if(c2 >= '1' && c2 <= '9')
						sum2 += c2 - '0';
				}
				
				if(sum1 != sum2) {
					return sum1 - sum2;
				} else {
					for(int i=0; i<o1.length(); i++) {
						char c1 = o1.charAt(i);
						char c2 = o2.charAt(i);
						
						if(c1 == c2)
							continue;
						else
							return c1 - c2;
					}
				}
			}
			
			return 0;
		}//end compare()
	};
}
