package test.level1;

public class 삼총사 {
    public static int solution(int[] number) {
        int answer = 0;

        /*
         * 배열 중 3개의 숫자를 합쳐서 나오는 합이 0이면 answer + 1
         * 배열 내 조합 가능한 수를 찾아야함
         * 순서대로 더했을 경우를 판단
         * */

        // 3자리 단위로 배열을 순회하며 0이면 answer++
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        int[] number = {-3, -2, -1, 0, 1, 2, 3};
        int[] number = {-2, 3, 0, 2, -5};

        System.out.println(solution(number));
    }
}
