package test.baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_11729 {
    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        // 경우의 수는 n2-1
        sb.append((int) Math.pow(2, n) - 1).append("\n");
        move(n, 1, 2, 3);

        System.out.println(sb);
    }

    public static void move(int n, int start, int mid, int to) {
        // 원판의 수가 1이면 시작점에서 끝점으로 이동
        if (n == 1) {
            sb.append(start).append(' ').append(to).append('\n');
            return;
        }

        // 가장 큰 수 - 1을 시작탑에서 중간탑으로 이동
        move(n - 1, start, to, mid);

        sb.append(start).append(' ').append(to).append('\n');

        // 중갑탑에서 끝탑으로 이동
        move(n - 1, mid, start, to);
    }
}
