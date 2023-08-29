package test.level1;

import java.util.Arrays;

public class MaxCounters2 {
    public int[] solution(int N, int[] A) {
        int[] sequence = new int[N];
        int max = 0;
        int preMax = 0;
        int x = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                preMax = max;
            } else {
                int counter = A[i] - 1;
                if(sequence[counter] < preMax) sequence[counter] = preMax + 1;
                else sequence[counter]++;

                if(sequence[counter] > max) max = sequence[counter];
            }
        }

        for (int i = 0; i < sequence.length; i++){
            if(sequence[i] < preMax){
                sequence[i] = preMax;
            }
        }

        return sequence;
    }
}
