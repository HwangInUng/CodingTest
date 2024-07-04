package test.baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        int rowCount = 0;
        int max = -1;
        int row = 0;
        int column = 0;

        while((line = br.readLine()) != null) {
            String[] arr = line.split(" ");

            for (int i = 0; i < arr.length; i++ ){
                int num = Integer.parseInt(arr[i]);
                if(num > max) {
                    max = num;
                    row = rowCount + 1;
                    column = i + 1;
                }
            }
            rowCount++;
        }

        System.out.println(max);
        System.out.println(row + " " + column);
    }
}
