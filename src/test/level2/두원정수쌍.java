package test.level2;

public class 두원정수쌍 {
    public static long solution(int r1, int r2) {
        long answer = (long) (r2 - r1 + 1) * 4L;

        int smallY = 0;
        int bigY = 0;

        for (int i = 1; i < r2; i++) {
            smallY = (int) Math.sqrt((long) r1 * r1 - (long) i * i);
            bigY = (int) Math.sqrt((long) r2 * r2 - (long) i * i);
            answer += (long) (bigY - smallY) * 4;

            if (i < r1 && Math.sqrt((long) r1 * r1 - (long) i * i) % 1 == 0) answer += 4L;
        }
        return answer;
    }

    public static void main(String[] args) {
        int r1 = 2;
        int r2 = 3;

        System.out.println(solution(r1, r2));
    }
}
