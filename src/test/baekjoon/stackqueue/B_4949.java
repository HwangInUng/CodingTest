package test.baekjoon.stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] arr = br.readLine().split("");
            boolean result = false;
            if (arr.length == 1 && arr[0].equals(".")) {
                break;
            }
            result = checkStack(arr);

            if (result) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean checkStack(String[] arr) {
        Stack<String> stack = new Stack<>();

        if (arr[0].equals(")") || arr[0].equals("]")) {
            return false;
        }

        for (String s : arr) {
            if (!isBracket(s)) continue;

            if (stack.isEmpty()) {
                stack.push(s);
            } else {
                String target = stack.peek();

                boolean small = target.equals("(") && s.equals(")");
                boolean big = target.equals("[") && s.equals("]");
                if (small || big) {
                    stack.pop();
                } else {
                    stack.push(s);
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isBracket(String str) {
        return str.equals("(") || str.equals(")") || str.equals("[") || str.equals("]");
    }
}
