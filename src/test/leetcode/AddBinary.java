package test.leetcode;

public class AddBinary {
    public String addBinary(String a, String b) {
        // 문제
        // 이진수로 전달된 파라미터의 합을 구하고,
        // 해당 수를 다시 이진 수로 변환하여 반환하는 문제

        // 고려사항
        // a와 b의 길이는 1~10,000까지
        // long형의 범위를 넘을 수 있음
        // 각 문자열은 0이 주어지지 않는다.

        // 문제해결
        // 이진수끼리의 합에서 다음 조건대로 처리
        // 1-1 : 올림
        // 1-0 : 1
        // 0-0 : 0
        // 시간복잡도 : O(n)
        // 더 긴 길이의 수만큼 반복
        // 각 자리수의 1, 0 여부를 비교하여 처리
        // 1-1인 경우 carry를 증가

        int maxLength = Math.max(a.length(), b.length());
        int len1 = a.length() - 1;
        int len2 = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < maxLength; i++) {
            int sum = carry;

            if (len1 >= 0) {
                sum += a.charAt(len1--) - '0';
            }

            if (len2 >= 0) {
                sum += b.charAt(len2--) - '0';
            }

            carry = sum / 2;
            sb.append(sum % 2);
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
