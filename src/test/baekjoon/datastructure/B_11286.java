package test.baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B_11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> qp = new PriorityQueue<>((o1, o2) -> {
            if(o2[0] == o1[0]) {
                return o1[1] - o2[1];
            }

            return o1[0] - o2[0];
        });
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (qp.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(qp.poll()[1]).append("\n");
                }
            } else {
                int[] s = new int[]{Math.abs(x), x};
                qp.add(s);
            }
        }

        System.out.println(sb);
    }
}
