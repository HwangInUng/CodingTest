package test.baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B_1021 {
    private static LinkedList<Integer> deque = new LinkedList<>();
    private static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            deque.add(i + 1);
        }

        st = new StringTokenizer(br.readLine(), " ");
        sequence = new int[m];
        for (int i = 0; i < m; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }

    public static int solution() {
        int count = 0;

        for (int i = 0; i < sequence.length; i++) {
            int target = deque.indexOf(sequence[i]); // 대상 인덱스
            int middle = 0; // 중간 지점

            if (deque.size() % 2 == 0) {
                // 짝수의 경우 인덱스가 0이기 때문에 -1을 적용
                middle = deque.size() / 2 - 1;
            } else {
                // 홀수는 한쪽의 요소가 더 많기 때문에 -1 미적용
                middle = deque.size() / 2;
            }

            // target이 중간 지점보다 작으면
            if (target <= middle) {
                // 0부터 target Index까지만 앞에서 뒤로 이동
                for (int j = 0; j < target; j++) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            } else { // 크면
                // 0부터 요소들의 수에서 target Index를 뺀 횟수만큼 앞으로 이동
                for (int j = 0; j < deque.size() - target; j++) {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }

            // 위 과정을 수행하면 가장 첫 번째 요소가 target이므로 poll();
            deque.pollFirst();
        }

        return count;
    }

}
