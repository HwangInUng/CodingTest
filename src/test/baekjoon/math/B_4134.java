package test.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            long n = Long.parseLong(br.readLine());

            while (true) {
                boolean flag = true;

                if (n == 0 || n == 1) {
                    n = 2L; // 소수 중 가장작은 2를 반환
                }

                for (long k = 2; k <= Math.sqrt(n); k++) {
                    // 소수가 아니라면 flag 변경
                    if (n % k == 0) {
                        flag = false;
                        break;
                    }
                }

                // 소수가 아니라면 n을 증가시켜 다음소수까지 반복
                if (flag) {
                    sb.append(n + "\n");
                    break;
                } else {
                    n++;
                }
            }
        }

        System.out.println(sb);
    }
}
