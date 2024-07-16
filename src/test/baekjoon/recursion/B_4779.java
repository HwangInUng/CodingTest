package test.baekjoon.recursion;

import java.io.*;
import java.util.Arrays;

public class B_4779 {
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = "";

        while ((input = br.readLine()) != null) {
            int n = (int) Math.pow(3, Integer.parseInt(input));
            arr = new char[n];
            Arrays.fill(arr,'-');

            recursion(0, n);

            for(char s : arr) {
                bw.write(s);
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static void recursion(int start, int n) {
        if(n <= 1) {
            return;
        }

        int newLength = n / 3;
        int end = start + newLength * 2;

        // 중간부분 공백으로 변환
        for(int i = start + newLength; i < end; i++) {
            arr[i] = ' ';
        }

        // 구역을 나누어 재귀호출
        recursion(start, newLength);
        recursion(end, newLength);
    }
}
