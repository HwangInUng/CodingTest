package test.level1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 숫자짝꿍 {
    public static String solution(String X, String Y) {
        String answer = "";
        List<String> list = new ArrayList();

        // 1. X와 y를 비교하여 동일한 숫자 획득
        for (int i = 0; i < X.length(); i++) {
            String target = String.valueOf(X.charAt(i));
            if (Y.contains(target)) {
                Y = Y.replaceFirst(target, "");
                answer += target;
            }
        }

        if (answer.isEmpty()) return "-1";
        if (answer.replaceAll("0", "").isEmpty()) return "0";

        // 3. 문자에서 가장 큰 순자 순서대로 정렬
        list.sort(Comparator.reverseOrder());
        answer = String.join("", list);

        return answer;
    }

    public static void main(String[] args) {
        String X = "12321";
        String Y = "42531";

        System.out.println(solution(X, Y));
    }
}
