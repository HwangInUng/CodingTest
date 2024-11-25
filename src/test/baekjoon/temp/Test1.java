package test.baekjoon.temp;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(solution("102", "989"));
    }

    public static String solution (String num1, String num2) {
        int carry = 0;
        StringBuilder result = new StringBuilder();

        int length1 = num1.length();
        int length2 = num2.length();
        int maxLength = Math.max(length1, length2);

        // 앞 자리에 0을 채워 동일한 자리수로 유지
        num1 = String.format("%0" + maxLength + "d", Long.parseLong(num1));
        num2 = String.format("%0" + maxLength + "d", Long.parseLong(num2));

        for(int i = maxLength-1; i >= 0; i--) {
            // 0을 빼면서 한글자씩 누적 합
            int digit1 = num1.charAt(i) - '0';
            int digit2 = num2.charAt(i) - '0';

            int sum = digit1 + digit2 + carry;
            carry = sum / 10; // 자리수 줄이기
            result.append(sum % 10); // 1의 자리 추가
        }

        // 짝수가 아닌 경우 남은 수를 더하기
        if(carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}
