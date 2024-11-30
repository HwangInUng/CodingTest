package test.baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_2493 {
    /**
     * 결과로 인덱스를 출력해야하기 때문에 Top 객체를 생성하여 처리
     * <p>
     * 과정 1. 입력 값 배열에 저장 2. 배열을 0번 인덱스부터 순차적으로 돌면서 스택에 add() 3. 이 때, 스택이 비어있고, peek()가 현재 요소보다 작다면 pop() 반복 4. 반복문이
     * 종료되고, 스택이 비어있으면 0 입력 5. 스택에 요소가 존재한다면 pop() 한 요소의 인덱스 입력
     */

    public static class Top {
        private int number;
        private int value;

        public Top(int number, int value) {
            this.number = number;
            this.value = value;
        }

        public int getNumber() {
            return number;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Top> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            int current = arr[i];

            while (!stack.isEmpty() && stack.peek().getValue() <= current) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                sb.append("0").append(" ");
            } else {
                sb.append(stack.peek().getNumber()).append(" ");
            }

            stack.add(new Top(i + 1, current));
        }

        System.out.println(sb);
    }
}
