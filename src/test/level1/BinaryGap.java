package test.level1;

public class BinaryGap {
    public static int solution(int N) {
        int answer = 0;
        int max = 0;
        String binary = Integer.toBinaryString(N);
        char[] arr = binary.toCharArray();

        if (!binary.contains("1")) {
            return 0;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                max++;
            } else {
                if (answer < max) answer = max;
                max = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int N = 1041;

        System.out.println(solution(N));
    }
}
