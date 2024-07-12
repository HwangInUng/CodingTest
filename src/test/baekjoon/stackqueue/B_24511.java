package test.baekjoon.stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B_24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] typeArr = new int[n];
        Deque<Integer> deque = new LinkedList<>();

        // 타입에 대한 배열
        String[] a = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            typeArr[i] = Integer.parseInt(a[i]);
        }

        // 각 자료구조의 한개의 원소
        String[] b = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (typeArr[i] == 0) {
                deque.addLast(Integer.parseInt(b[i]));
            }
        }

        // 입력받는 숫자만큼 반복
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            // 큰 큐를 생각하고, 앞으로 요소를 추가
            // 스택은 어차피 마지막 요소를 빼기 때문에
            // pollLast를 처리
            // 큐의 입장에서도 앞에서부터 요소가 들어오기에 마지막이 첫번째 입력값이 맞음
            deque.addFirst(x);
            sb.append(deque.pollLast()).append(" ");
        }

        System.out.println(sb);
    }
}
