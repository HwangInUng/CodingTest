package test.baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String boom = br.readLine();
        int boomSize = boom.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));

            if (stack.size() >= boomSize) {
                boolean isBoom = true;

                for (int j = 0; j < boomSize; j++) {
                    // boom을 포함한 스택의 사이즈에서 boom 크기를 제외하고
                    // 0부터 더하며 확인했을 때 boom과 모두 일치하면 통과
                    // 그렇지 않으면 false로 변경
                    // stack.pop()을 수행해야하기 때문에 불일치 정보를 반복문으로 확인
                    if (stack.get(stack.size() - boomSize + j) != boom.charAt(j)) {
                        isBoom = false;
                        break;
                    }
                }

                // boom 단어 모두 스택에서 제거
                if (isBoom) {
                    for (int j = 0; j < boomSize; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            // pop()을 사용하면 거꾸러 작성되기 때문에 반복문으로 수행
            for (char c : stack) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
