package test.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_13241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long g = 0;

        if (a > b) {
            g = gcd(a, b);
        } else {
            g = gcd(b, a);
        }

        System.out.println(a * b / g);
    }

    // 유클리드 호제법
    public static long gcd(long a, long b) {
        // b는 a % b = r 값이 재귀적으로 호출
        if (b == 0) {
            // r == 0 참이면 b가 a와 b의 최대 공약수
            return a;
        }
        return gcd(b, a % b);
    }
}
