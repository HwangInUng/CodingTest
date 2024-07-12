package test.baekjoon.stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int count = 1;
        sb.append("<");
        while (queue.size() > 1) {
            // k번째가 아닌경우 밀어내기
            if (count != k) {
                int current = queue.poll();
                queue.add(current);
                count++;

                continue;
            }

            // count가 k번째이면 큐에서 제거
            sb.append(queue.poll()).append(", ");
            count = 1;
        }

        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }
}
