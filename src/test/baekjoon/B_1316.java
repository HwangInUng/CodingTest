package test.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1316 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());
            String temp = "";
            int count = 0;

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                StringBuilder save = new StringBuilder();

                for (int j = 0; j < line.length(); j++) {
                    String current = String.valueOf(line.charAt(j));

                    if (j == 0) {
                        save.append(current);
                        temp = current;
                        continue;
                    }

                    if(temp.equals(current)) continue;

                    if(save.indexOf(current) == -1) {
                        save.append(current);
                        temp = current;
                    } else if (save.indexOf(current) > -1) {
                        count++;
                        break;
                    }
                }
            }

            System.out.println(n - count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
