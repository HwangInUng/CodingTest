package test.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1~100 사이의 양의 정수 N으로 구성된 집합 Z가 존재 Z.length-1 갯수의 연산자들의 집합 A가 존재
 * <p>
 * Z의 각 요소 사이에 A의 요소를 하나씩 배치하여 값을 구함 이때, Z의 각 요소의 순서를 변경할 순 없음 또한 A의 연산자 우선순위를 무시 예를 들어 +와 x가 나온 경우 먼저 나온 +를 계산
 * <p>
 * 나눗셈의 대한 계산은 몫만 계산하며 음수인 경우 양수로 나눈 몫을 음수로 변경
 * <p>
 * 위 조건에 해당하는 결과중 최소 값과 최대 값을 구해라.
 */
public class B_14888 {
    // 정수들의 집합
    static int[] Z;
    // 연산자 갯수들의 집합
    static int[] A = new int[4];
    static int n;

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 숫자들의 갯수
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        Z = new int[n];
        for (int i = 0; i < n; i++) {
            Z[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        calculate(1, Z[0]);

        System.out.println(max);
        System.out.println(min);
    }

    /*
     * Z[index] A.get(index) Z[index + 1] 형태로 계산을 반복
     * return 시 합을 최소, 최대 값에 대입
     * */
    public static void calculate(int index, int sum) {
        if (index == n) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (A[i] > 0) {

                A[i]--;

                switch (i) {
                    case 0:
                        calculate(index + 1, sum + Z[index]);
                        break;
                    case 1:
                        calculate(index + 1, sum - Z[index]);
                        break;
                    case 2:
                        calculate(index + 1, sum * Z[index]);
                        break;
                    case 3:
                        calculate(index + 1, sum / Z[index]);
                        break;
                }
                A[i]++;
            }
        }
    }
}
