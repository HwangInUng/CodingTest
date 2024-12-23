package test.leetcode;

import java.util.Stack;

public class PlusOne {
    
    // 내가 해결한 방법
    public static int[] plusOne(int[] digits) {
        // 문제
        // 큰 정수의 조각들로 이루어진 배열이 주어짐
        // 왼쪽에서 오른쪽 순서로 정렬되어 있음
        // 요소들을 이어붙이고, 1을 더했을 때의 큰 정수를
        // 배열에 요소로 담아서 반환

        // 고려사항
        // 배열의 길이는 1~100
        // long형을 벗어나는 정수의 범위
        // 숫자의 앞에는 0이 포함될 수 없음
        // 각 요소는 0~9까지의 범위를 가짐

        // 문제 해결
        // 시간 복잡도 O(n)
        // 배열의 가장 뒤에서 1을 더하며 인덱스를 줄여나감
        // 배열의 마지막 요소가 9라면 carry를 1로 증가
        // 아니라면 1만 더하고 StringBuilder에 순서대로 담기
        // 만약 carry가 1이라면 이후 요소들의 값도 확인
        // carry를 다음 요소에 전해준 경우 0으로 초기화
        // 반복문 종료 후 StringBuilder의 마지막 요소를
        // 배열의 첫 번째 요소로 담으면서 반복

        int carry = 1;
        Stack<Integer> stack = new Stack<>();

        for(int i = digits.length-1; i >= 0; i--) {
            int current = digits[i];
            int sum = current + carry;

            stack.add(sum % 10);
            carry = sum / 10;
        }

        if(carry > 0) {
            stack.add(carry);
        }

        int[] result = new int[stack.size()];

        for(int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }

        return result;
    }
    
    // 리트 코드 샘플
    public static int[] plusOneSomeOneElse(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            // 9보다 작으면 해당 인덱스를 ++
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        // 반복문이 정상 종료되면 앞자리를 올림하여 반환
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
