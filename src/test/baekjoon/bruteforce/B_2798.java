package test.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        /*
         * n : 3 <= n && n <= 100
         * m : 10 <= m && m <= 300,000
         * 각 카드의 수는 100,000 이하 양의 정수
         * sum <= m
         * */

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] cards = br.readLine().split(" ");
        int max = 0;

        if (cards.length == 3) {
            System.out.println(Integer.parseInt(cards[0]) + Integer.parseInt(cards[1]) + Integer.parseInt(cards[2]));
        } else {
            for (int i = 0; i < cards.length; i++) {
                int a = Integer.parseInt(cards[i]);
                for (int j = i + 1; j < cards.length; j++) {
                    int b = Integer.parseInt(cards[j]);
                    for (int k = j + 1; k < cards.length; k++) {
                        int c = Integer.parseInt(cards[k]);
                        int sum = a + b + c;
                        if (sum <= m) {
                            max = Math.max(max, sum);
                        }
                    }
                }
            }
            System.out.println(max);
        }
    }
}
