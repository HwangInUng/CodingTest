package test.baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        int high = 0; // 최고 높이
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, trees[i]);
        }

        int low = 0; // 시작 위치
        int result = 0;

        // 시작 위치가 최고 높이 이하인 경우 반복
        while (low <= high) {
            // 시작 위치와 최고 높이의 합에서 중간값으로 분할
            int mid = (low + high) / 2;
            long total = 0;

            for (int tree : trees) {
                // 나무가 현재 높이보다 큰 경우만 계산
                if (tree > mid) {
                    total += tree - mid;
                }
            }

            // 나무를 자른 결과가 m 이상이면
            if (total >= m) {
                // 현재 값을 결과로 갱신
                result = mid;
                // 높이 증가
                // 만약, 여기서 증가하고 high보다 low가 높아지면 반복문 종료
                // 즉, result = m
                low = mid + 1;
            } else {
                // 결과가 m보다 작으면 높이를 낮춰서 진행
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}
