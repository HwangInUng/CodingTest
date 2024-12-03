package test.leetcode;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandCenter(s, i, i); // 홀수
            int len2 = expandCenter(s, i, i + 1); // 짝수
            int len = Math.max(len1, len2); // 둘 중에 큰 것으로 적용

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int expandCenter(String s, int left, int right) {
        // left가 0 이상이고, right가 s.length() 이하이며,
        // left와 right가 같으면 센터 확장
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
