package leetcode;

//https://foxtrot.tistory.com/19
class ValidPalindrome {
    private boolean isPalindrome(String s) {
        if (s.length() == 1) return true;

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            while (!Character.isLetterOrDigit(c1)) {
                // c1이 영문자나 숫자가 아니라면
                if (++left > right) break;
                c1 = s.charAt(left);
            }

            while (!Character.isLetterOrDigit(c2)) {
                // c2가 영문자나 숫자가 아니라면
                if (left > --right) break;
                c2 = s.charAt(right);
            }

            if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) return false;
            left++;
            right--;
        }

        return true;
    }
}
