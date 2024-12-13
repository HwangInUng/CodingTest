package test.leetcode;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        // 문제
        // 문자열로 구성된 배열이 주어지고,
        // 각 문자열에서 공통된 접두사 중 가장 긴 접두사를 반환
        // 만약, 없다면 ""를 반환

        // 고려사항
        // 배열의 길이는 1이상 200이하
        // 문자열의 길이도 동일
        // 각 문자열은 소문자로만 구성

        // 문제해결
        // 200 * 200 = 40,000번의 연산 O(n^2)까지 수행가능
        // 요소가 1개라면 해당 요소를 반환
        // 요소가 2개 이상인 경우 현재까지 동일한 prefix 임시저장
        // prefix를 비교하며 작업 수행
        // 만약 틀리면 "" 반환
        // 일부만 같다면 해당 prefix 수정

        String first = strs[0];
        int pos = Integer.MAX_VALUE;
        int length = strs.length;

        if (length == 1) {
            return first;
        }

        for (int i = 1; i < length; i++) {
            int index = 0;

            while (index < first.length() && index < strs[i].length()) {
                if (first.charAt(index) != strs[i].charAt(index)) {
                    break;
                }
                index++;
            }
            pos = Math.min(pos, index);
        }

        if (pos == Integer.MAX_VALUE) {
            return "";
        }

        return first.substring(0, pos == 0 ? 0 : pos);
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
