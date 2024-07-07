package test.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int[] arr2 = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            arr2[arr[i]]++;
        }

        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] != 0) {
                for (int j = 0; j < arr2[i]; j++) {
                    sb.append(i).append("\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}
