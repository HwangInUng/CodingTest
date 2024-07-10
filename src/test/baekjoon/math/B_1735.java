package test.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int b1 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int g = 0;
        int multiple = 0;
        // 분모 간의 최소공배수를 찾아서 연산
        if (a2 > b2) {
            g = gcd(a2, b2);
            multiple = a2 * b2 / g;
        } else {
            g = gcd(b2, a2);
            multiple = a2 * b2 / g;
        }
        // 최소공배수 / 각 분모로 분자의 값 변경
        a1 *= multiple / a2;
        b1 *= multiple / b2;

        int t = a1 + b1;

        // 최대 공약수 이용 기약분수 구함
        if (t > multiple) {
            g = gcd(t, multiple);
        } else {
            g = gcd(multiple, t);
        }
        System.out.println(t / g + " " + multiple / g);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
