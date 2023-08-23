package test.level1;

public class FrogJump {
    public static int solution(int X, int Y, int D) {
        // Y - X를 하고 값을 저장한다.
        // 저장된 값을 D로 나눈다.
        // 나눈 값을 double형으로 형변환하여 저장한다.
        // Math.ceil()을 이용해 올림한다.
        // 결과를 반환한다.

        int n = Y - X;
        double m = (double) n / D;
        int answer = (int) Math.ceil(m);

        return answer;
    }
}
