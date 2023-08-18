package test.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합2 {
    // n은 최대 1,000,000개 이하
    // m은 수의 변경이 일어나는 횟수, 10,000번 이하
    // k는 구간의 합을 구하는 횟수, 10,000번 이하

    // n개의 수가 주어짐
    // a가 1이면 b(인덱스)를 c(값)으로 교체, 2이면 b(시작인덱스)부터 c(종료인덱스)까지 합을 구한다.

    // 숫자의 개수(n)을 입력받는다.
    // 수의 변경(m)을 입력받는다.
    // 구간합의 횟수(k)를 입력받는다.

    //for(n만큼 반복){
    // 인덱스의 값 교체를 위한 배열 저장
    // n개의 수를 합 배열 요소에 연산하여 저장
    //}

    //for(m + k만큼 반복){
    // a를 입력받는다.
    // b를 입력받는다.
    // c를 입력받는다.

    //if(a가 1이면){
    //기존배열[b] = c
    //} else{
    //합 배열[c] - 합 배열[b-1]
    //}
    //}
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.valueOf(stringTokenizer.nextToken());
        int m = Integer.valueOf(stringTokenizer.nextToken());
        int k = Integer.valueOf(stringTokenizer.nextToken());
        long[] nArray = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            nArray[i] = Long.valueOf(stringTokenizer.nextToken());
        }

        long[] preSum = getPrefixSum(n, nArray);

        for (int i = 0; i < m + k; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.valueOf(stringTokenizer.nextToken());
            int b = Integer.valueOf(stringTokenizer.nextToken());
            long c = Long.valueOf(stringTokenizer.nextToken());

            if (a == 1) {
                nArray[b] = c;
                preSum = getPrefixSum(n, nArray);
            } else {
                System.out.println(preSum[(int) c] - preSum[b - 1]);
            }

        }
    }

    public static long[] getPrefixSum(int n, long[] nArray) {
        long[] preSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nArray[i];
        }
        return preSum;
    }
}
