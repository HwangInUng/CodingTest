package test.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합 {
    public static void main(String[] args) throws Exception {
        // n = 100,000 이하
        // m = 100,000 이하
        // n*m = 10억으로 시간초과

        // 숫자의 갯수 n을 저장
        //for(n만큼 반복){
        // 입력받은 숫자를 배열로 저장
        //}

        // 입력받은 숫자의 배열
        //for(배열의 길이만큼 수행){
        // i가 0이고, j가 100,000일 경우 100,000번의 연산 필요
        // 이 과정을 단축하기 위해 합 배열 사용
        // n개의 숫자는 이전 요소와 합하며 배열에 저장
        //}

        //for(m만큼 반복){
        // 구간 종료 j - 구간 시작 i - 1 을 통해 합 배열을 통하여 계산
        //}

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.valueOf(stringTokenizer.nextToken());
        int m = Integer.valueOf(stringTokenizer.nextToken());
        int[] preSum = new int[n + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + Integer.valueOf(stringTokenizer.nextToken());
        }

        for (int x = 0; x < m; x++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.valueOf(stringTokenizer.nextToken());
            int j = Integer.valueOf(stringTokenizer.nextToken());

            System.out.println(preSum[j] - preSum[i - 1]);
        }
    }
}
