package test.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9663 {
    static int n;
    static int[] arr;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        dfs(0);

        System.out.println(count);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            // i번째 퀸
            arr[depth] = i;
            if (checkCondition(depth)) {
                // 조건 모두 통과시 다음 depth 탐색
                dfs(depth + 1);
            }
        }
    }

    public static boolean checkCondition(int depth) {
        for (int i = 0; i < depth; i++) {
            // 같은 행에 위치하는지 확인
            if (arr[i] == arr[depth]) {
                return false;
            }
            // 대각선 방향 존재여부
            // 행을 depth로 표현하고, 열을 i로 표현
            // 행 - 열의 차이가 같다면 대각선이므로 리턴
            if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
