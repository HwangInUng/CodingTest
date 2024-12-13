package test.leetcode;

import java.util.HashMap;

public class RomanToInteger {
    public static int romanToInt(String s) {
        // 문제
        // 주어진 문자열에서 사전에 정의된
        // 심볼을 찾고, 해당 심볼 값들의 합을 구하는 문제

        // 고려사항
        // 심볼은 사전에 정의되어 있음
        // 일부 심볼은 조합되어 특수한 값을 가짐

        // 문제해결
        // 심볼을 Map에 key-value로 저장
        // 문자열이 isEmpty()가 될 때까지 반복
        // Map에 있는 문자열 순회 후 값 누적

        HashMap<Character, Integer> symbolMap = new HashMap<>();
        symbolMap.put('I', 1);
        symbolMap.put('V', 5);
        symbolMap.put('X', 10);
        symbolMap.put('L', 50);
        symbolMap.put('C', 100);
        symbolMap.put('D', 500);
        symbolMap.put('M', 1000);

        int result = 0;
        int prev = 0;

        for(int i = 0; i < s.length(); i++) {
            int current = symbolMap.get(s.charAt(i));

            if(prev < current) {
                result -= (current - prev) - prev;
            } else {
                result += current;
            }
            prev = current;
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
}
