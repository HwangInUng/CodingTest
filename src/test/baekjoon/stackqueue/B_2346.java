package test.baekjoon.stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B_2346 {
    // 값과 순서를 보유한 풍선 클래스
    public static class Balloon {
        private int value;
        private int index;

        public Balloon(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        Deque<Balloon> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int paper = Integer.parseInt(st.nextToken());

            deque.add(new Balloon(paper, i + 1));
        }

        // 양수는 오른쪽, 음수는 왼쪽 이동
        // 이미 터진 풍선은 제외
        // 1번 풍선부터 시작
        Balloon balloon = deque.pollFirst();
        int current = balloon.value;
        sb.append(balloon.index + " ");

        while (deque.size() > 1) {
            if (current > 0) { // 양수인 경우 첫번째 요소를 마지막에 add
                deque.addLast(deque.pollFirst());
                current--;
                if (current == 0) {
                    Balloon currentBalloon = deque.pollLast();
                    current = currentBalloon.value;
                    sb.append(currentBalloon.index + " ");
                }
            } else if (current < 0) { // 음수인 경우 마지막 요소를 처음에 add
                deque.addFirst(deque.pollLast());
                current++;
                if (current == 0) {
                    Balloon currentBalloon = deque.pollFirst();
                    current = currentBalloon.value;
                    sb.append(currentBalloon.index + " ");
                }
            }

        }

        sb.append(deque.pollFirst().index);

        System.out.println(sb);
    }
}
