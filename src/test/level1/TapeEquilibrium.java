package test.level1;

class TapeEquilibrium {
    public int solution(int[] A) {
        /*
        합 배열을 선언한다

        for(A의 길이만큼){
            합 배열[index] = 합 배열[index-1] + A[index-1]
        }

        int형의 최대값을 비교할 변수에 저장한다.

        for(A의 길이만큼){
            비교값 = Math.min(비교값, Math.abs(합배열 구간 연산값))
        }

        결과를 반환한다.
        * */

        int[] preSum = new int[A.length + 1];
        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= A.length; i++) {
            preSum[i] = preSum[i - 1] + A[i - 1];
        }

        for (int p = 1; p < A.length; p++) {
            answer = Math.min(answer, Math.abs(preSum[p] - (preSum[preSum.length - 1] - preSum[p])));
        }

        return answer;
    }
}
