package test.level1;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
    /*
    배열의 요소를 담을 Set을 선언(중복불허)

    for(A의 길이만큼 수행){
        Set에 요소를 하나씩 add

        if(Set의 길이가 X와 동일하면) return 인덱스;
    }

    반복문이 정상종료되면 return -1;
    * */

    public int solution(int X, int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);

            if (set.size() == X) return i;
        }

        return -1;
    }
}
