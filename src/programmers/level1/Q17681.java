package programmers.level1;

public class Q17681 {
    private String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int len = 0;

        for (int i=0; i<n; i++) {
            String s1 = getBinary(Integer.toBinaryString(arr1[i]), n);
            String s2 = getBinary(Integer.toBinaryString(arr2[i]), n);
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<n; j++) {
                if (s1.charAt(j) == '0' && s2.charAt(j) == '0') {
                    sb.append(' ');
                } else {
                    sb.append('#');
                }
            }
            answer[i] = sb.toString();
        }

        return answer;
    }

    private String getBinary(String s, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<len - s.length(); i++) {
            sb.append("0");
        }
        sb.append(s);

        return sb.toString();
    }
}
