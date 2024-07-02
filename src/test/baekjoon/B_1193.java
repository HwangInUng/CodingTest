package test.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String answer = "";

        // 현재 대각선 길이
        int temp = 0;
        // 대각선 길이의 총합
        int sum = 0;
        // 대각선이 늘어날때마다 카운트
        int count = 0;

        // 대각선 길이의 총합이 n을 넘지않을때까지 반복
        while (sum < n) {
            sum += temp + 1;
            temp += 1;
            count++;
        }

        /*
        * a : 대각선 길이의 총합 - n을 빼주고, 0인 경우를 감안하여 1을 추가
        * b : 대각선 길이의 총합 - n을 빼주고, 대각선 카운트에서 해당 값을 빼줌
        */
        String a = String.valueOf(sum - n + 1);
        String b = String.valueOf(count - (sum - n));

        // 짝수인 경우 열의 카운트가 먼저 위치
        // 홀수인 경우 행의 카운트가 먼저 위치
        answer = count % 2 == 0 ? b+"/"+a : a+"/"+b;

        System.out.println(answer);
    }
}
