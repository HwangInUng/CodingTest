package test.leetcode;

import java.util.LinkedList;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        // set에 문자를 담으면서
        // 이미 존재했던 문자인지 확인
        // 이미 존재한 문자가 보이면
        // 현재 setsize를 max로 등록
        // 해당 문자를 제거 후
        // 종료된 인덱스에서 재시작
        // O(n)으로 해결가능?
        LinkedList<Character> deque  = new LinkedList<>();
        int max = 0;
        int index = 0;

        if(s.length() == 0) return 0;

        while (true) {
            char c = s.charAt(index);
            int target = deque.indexOf(c);

            if(target != -1) {
                max = Math.max(max, deque.size());
                for(int i = 0; i <= target; i++) {
                    deque.pollFirst();
                }
            }
            deque.addLast(c);

            if(index == s.length()-1) {
                max = Math.max(max, deque.size());
                break;
            }
            index++;
        }


        return max;
    }
}
