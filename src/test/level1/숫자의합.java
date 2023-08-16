package test.level1;

import java.util.Scanner;

public class 숫자의합 {
    public static void main(String[] args) {
        int answer = 0;
        // n 값을 입력받는다.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 입력받은 n의 개수만큼 String형으로 입력받는다.
        String number = sc.next();
        // 입력받은 String을 char[]형으로 변환한다.
        char[] charArray = number.toCharArray();
        // 반복문을 통해 변환된 char[]형의 문자들을 연산하여 int로 더해준다.
        for (int i = 0; i < charArray.length; i++) {
            //int형으로 연산 후 더해준다.
            answer += charArray[i] - 48;
        }

        //결과를 반환한다.
        System.out.println(answer);
    }
}
