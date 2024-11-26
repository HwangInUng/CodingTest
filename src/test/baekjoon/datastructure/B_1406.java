package test.baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        for(char s : input.toCharArray()) {
            leftStack.push(s);
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            if (command.equals("L") && !leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            } else if (command.equals("D") && !rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
            } else if (command.equals("B") && !leftStack.isEmpty()) {
                leftStack.pop();
            } else if (command.startsWith("P")){
                char value = command.charAt(2);
                leftStack.push(value);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : leftStack) { // 순서대로 꺼내와야하기 때문에 for 루프
            sb.append(c);
        }
        while (!rightStack.isEmpty()) { // 가장 나중에 들어간 문자부터 꺼내와야하기 때문에 while pop()
            sb.append(rightStack.pop());
        }

        System.out.println(sb);
    }
}
