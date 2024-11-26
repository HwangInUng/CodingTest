package test.baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class B_5430 {
    /**
     * 정수 배열을 대상으로 명령을 수행 배열 뒤집기, 앞에서부터 요소 삭제 등에 대한 명령 결국, 덱의 특성을 이용하여 하나의 자료구조 안에서 명령을 효과적으로 수행할 수 있는지 확인
     * <p>
     * 명령(P)의 길이는 최대 100,000 배열의 길이는 최대 100,000
     * <p>
     * 시간 제한 2초 -> 최대 2억번 이내의 연산 수행 -> O(n log n)까지 수행가능
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String p = br.readLine(); // 함수
            char[] pArr = p.toCharArray();
            int n = Integer.parseInt(br.readLine()); // 요소 수
            String x = br.readLine();

            ArrayDeque<String> deque = new ArrayDeque<>();
            if (n > 0) {
                String[] xArr = x.substring(1, x.length() - 1).split(",");
                deque.addAll(Arrays.asList(xArr));
            }

            boolean isReverse = false;
            boolean isError = false;

            for (char c : pArr) {
                if (c == 'R') {
                    isReverse = !isReverse;
                } else if (c == 'D') {
                    if(deque.isEmpty()) {
                        isError = true;
                        break;
                    }

                    if (isReverse) {
                        deque.pollLast();
                    }else {
                        deque.pollFirst();
                    }
                }
            }

            if (isError) {
                sb.append("error").append("\n");
            } else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(isReverse ? deque.pollLast() : deque.pollFirst());

                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]").append("\n");
            }
        }

        System.out.println(sb);
    }
}
