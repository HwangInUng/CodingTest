package test.level1;

import java.util.Arrays;

class PermMissingElem {
    public int solution(int[] A) {
        /*
        * 배열 정렬

        for(A의 길이만큼){
            if(A의 요소와 비교값을 틀리다면){
                return 비교값;
            }
        }

        반복문이 정상 종료되면
        return 배열의 길이 + 1을 반환
        * */
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return A.length + 1;
    }
}
