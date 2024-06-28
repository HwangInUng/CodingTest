package test.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_25206 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        /*
         * n = 20
         * 1라인당 = 과목명 학점 등급
         * 과목명은 알파벳만 사용, 중복되지 않음
         * P는 계산에서 제외
         * */
        String[] rating = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
        double[] ratingPoint = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};
        double sum = 0.0;
        double degreeSum = 0.0;

        try {
            while ((line = br.readLine()) != null) {
                String[] items = line.split(" ");

                if(items[2].equals("P")) continue;

                for (int i = 0; i < rating.length; i++) {
                    if(rating[i].equals(items[2])) {
                        double degree = Double.parseDouble(items[1]);
                        sum += ratingPoint[i] * degree;
                        degreeSum += degree;
                    }
                }
            }

            System.out.println(avg(sum, degreeSum));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double avg(double sum, double degreeSum) {
        return sum / degreeSum;
    }
}
