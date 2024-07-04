package test.baekjoon.basic;

import java.io.*;

public class B_9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int a = Integer.parseInt(br.readLine());
            int sum = 0;
            StringBuilder sb = new StringBuilder();

            if (a == -1) break;

            for (int i = 1; i <= a; i++) {
                if (i == a) break;

                if (a % i == 0) {
                    sum += i;
                    sb.append(i + " ");
                }
            }

            String[] arr = sb.toString().split(" ");
            sb.delete(0, sb.length());
            for (int i = 0; i < arr.length; i++) {
                int num = Integer.parseInt(arr[i]);
                if (i != 0) {
                    sb.append(" + ");
                }
                sb.append(num);
            }

            if (sum == a) bw.write(a + " = " + sb.toString() + "\n");
            else bw.write(a + " is NOT perfect." + "\n");
        }

        bw.flush();
    }
}
