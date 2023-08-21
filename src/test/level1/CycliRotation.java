package test.level1;

public class CycliRotation {
    public static int[] solution(int[] A, int K) {
        int[] answer = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            answer[(i + K) % A.length] = A[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] A = {3, 8, 9, 7, 6};
        int K = 3;

        System.out.println(solution(A, K));
    }
}
