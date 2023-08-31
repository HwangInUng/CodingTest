package test.level1;

import java.util.ArrayList;
import java.util.List;

public class PassingCars {
    public int solution(int[] A) {
        int limit = 1000000000;
        int answer = 0;
        int westSum = 0;
        int index = 0;
        int space = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                westSum++;
                space++;
            } else if (A[i] == 0) {
                if (list.size() == 0) {
                    list.add(space);
                    continue;
                }
                list.add(list.get(index) + space);
                index++;
                space = 0;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            answer += westSum - list.get(i);
        }
        return Math.abs(answer) > limit ? -1 : Math.abs(answer);

    }
}
