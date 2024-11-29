package test.baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B_1715 {
    /**
     * 배열을 정렬하여 연산을 처리하는 경우
     * 반복되는 정렬로 인해 시간초과 발생
     * 이 뿐만 아니라 정렬을 미수행하면 기존에 정렬했던 원소보다
     * 구간에서 합쳐진 값이 더 커지는 경우가 발생하여 조건 미충족
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> qp = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            qp.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (qp.size() > 1) {
            int a = qp.poll();
            int b = qp.poll();

            result += a + b;

            qp.add(a + b);
        }

        System.out.println(result);
    }
}
