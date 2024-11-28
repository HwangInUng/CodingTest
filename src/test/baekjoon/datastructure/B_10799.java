package test.baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10799 {
    /**
     * 막대가 나온 숫자를 확인하고, 레이저가 조합될 때 스택에 쌓인 막대의 수를 결과에 누적 막대의 끝에 도달하면 + 1을 결과에 누적
     * <p>
     * 막대 1개를 레이저 1개로 자르는 경우 막대는 2조각으로 나누어짐 막대 2개를 레이저 1개로 자르는 경우 막대는 4조각으로 나누어짐 이와 같은 원리로 레이저가 막대를 자를 때 막대의 수를 누적하고,
     * 막대의 끝에 도달하면 +1을 해주어 막대의 수만큼 누적하여 최종 결과를 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int stack = 0;
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == '(') {
                stack++;
            } else {
                if (input.charAt(i-1) == '(') {
                    stack--;
                    result += stack;
                } else {
                    result++;
                    stack--;
                }
            }
        }

        System.out.println(result);
    }
}
