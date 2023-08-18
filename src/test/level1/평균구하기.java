package test.level1;

import java.util.Scanner;

public class 평균구하기 {
//    public static void main(String[] args) {
//        // 과목의 개수 n 저장
//
//        // 최대 점수를 저장할 변수 생성
//        for(//n번만큼 반복문 수행){
//            // 최대 점수를 비교하여 저장
//            // 과목별 점수를 누적하여 저장
//        }
//
//        // 총점 * 100 / 최대점수 / n
//    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = 0;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            int point = scanner.nextInt();
            if (point > max) max = point;

            sum += point;
        }

        System.out.println(sum * 100 / max / n);
    }
}
