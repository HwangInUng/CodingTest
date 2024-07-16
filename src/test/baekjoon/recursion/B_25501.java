package test.baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_25501 {
    static int count;

    // 왼쪽과 오른쪽의 문자열을 비교
    // 왼쪽 인덱스가 오른쪽과 같거나 커질 경우 끝까지 같으니 1 반환
    // 왼쪽 인덱스의 위치와 오른쪽 인덱스의 위치가 다르면 reverse한 결과도 다르니 0 반환
    public static int recursion(String s, int l, int r) {
        count++;
        if (l >= r) {
            return 1;
        } else if (s.charAt(l) != s.charAt(r)) {
            return 0;
        } else {
            return recursion(s, l + 1, r - 1);
        }
    }

    // 시작
    // 왼쪽 인덱스 : 0
    // 오른쪽 인덱스 : 문자열의 길이 - 1
    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String word = br.readLine();

            int result = isPalindrome(word);
            sb.append(result).append(" ").append(count).append("\n");

            // 결과와 count를 담고 초기화
            count = 0;
        }

        System.out.println(sb);
    }
}
