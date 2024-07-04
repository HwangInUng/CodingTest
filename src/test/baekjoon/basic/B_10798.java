package test.baekjoon.basic;

import java.io.*;

public class B_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = 5;
        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            sb.append(br.readLine());
            if (i != n - 1) {
                sb.append("\n");
            }
        }
        String[] arr = sb.toString().split("\n");
        for(String s : arr) {
            maxLength = Math.max(maxLength, s.length());
        }

        for(int i = 0; i < maxLength; i++) {
            for(int j = 0; j < n; j++) {
                if(i > arr[j].length() - 1) continue;
                bw.write(arr[j].charAt(i));
            }
        }

        bw.flush();
    }
}
