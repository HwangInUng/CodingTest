package test.level1;

public class 콜라 {
    public static int solution(int a, int b, int n) {
        int answer = 0;

        // 1. n < a 이면 return 0
        if (n < a) return 0;

        while (n >= a) {
            // 2. dummy에 나머지 대입, n/a는 answer로 적재
            // 3. 적재 후 n에 반환갯수와 dummy 덧셈
            int dummy = n % a;
            answer += (n / a) * b;
            n = (n / a) * b + dummy;
            
            if (n == a) {
                answer++;
                //break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
