package test.level1;

import java.util.Arrays;

public class MaxCounters {
    public int[] solution(int N, int[] A) {
        // M개의 정수가 담긴 배열 A
        // A의 각 요소를 비교한다.
        // counter x 는 1부터 1씩 증가하는 정수이다.
        // a[i] = x 이면 카운터를 1증가시킨다.
        // a[i] = N + 1이면 모든 카운터 배열의 카운터 값을 max 카운터로 세팅한다.
        // 가장 높은 시퀀스 값의 배열을 반환한다.

        int[] sequence = new int[N];
        int max = 0;
        int x = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                if (max != x) {
                    Arrays.fill(sequence, x);
                    max = x;
                }
            } else {
                sequence[A[i] - 1]++;
                x = Math.max(x, sequence[A[i] - 1]);
            }
        }

        return sequence;
    }
}
