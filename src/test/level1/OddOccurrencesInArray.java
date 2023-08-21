package test.level1;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {

    public static int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], A[i]);
            } else {
                map.remove(A[i]);
            }
        }

        int answer = 0;
        for (Integer key : map.keySet()) {
            answer = map.get(key);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] A = {9, 3, 9, 3, 9, 7, 9};

        System.out.println(solution(A));
    }
}
