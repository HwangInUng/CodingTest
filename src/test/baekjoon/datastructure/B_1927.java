package test.baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B_1927 {

    public static void main(String[] args) throws IOException {
        // 최소 힙을 이용하여 연산 지원 -> 우선순위 큐 이용
        // 자연수 입력 시 힙에 저장
        // 0 입력 시 최소 값 출력 후 제거
        // 힙이 비어있는 경우 0 출력
        // 최대 O(n log n)의 시간복잡도로 해결해야함.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0 && minHeap.isEmpty()) {
                sb.append(0).append("\n");
            } else if (x > 0) {
                minHeap.add(x);
            } else if (x == 0) {
                sb.append(minHeap.poll()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
