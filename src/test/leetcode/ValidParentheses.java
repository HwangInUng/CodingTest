package test.leetcode;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        // 문제
        // 괄호로 구성된 문자열이 주어짐
        // 같은 유형의 괄호만으로 구성된 문자열인지 확인

        // 고려사항
        // 반드시 같은 유형의 괄호인 경우만 취급
        // 괄호는 중첩될 수 있음
        // 문자열의 길이는 1~10,000
        // 닫힌 괄호가 먼저 나오는 경우 확인

        // 문제 해결
        // 문자열의 길이가 1인 경우 false
        // Stack을 이용하여 열린 괄호와 짝을 이루는 닫힌 괄호 저장
        // 닫힌 괄호가 나왔을 때 해당 괄호가 stack의 마지막 요소와 같은지 확인
        // 같다면 다음 진행
        // 틀리면 false 반환

        // 시간 복잡도 : O(n)
        // 공간 복잡도 : O(n)

        if (s.length() == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);

            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.add(bracket);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                if (bracket == ')' && stack.peek() != '(') {
                    return false;
                } else if (bracket == ']' && stack.peek() != '[') {
                    return false;
                } else if (bracket == '}' && stack.peek() != '{') {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
