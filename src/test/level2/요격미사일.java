package test.level2;

import java.util.Arrays;

public class 요격미사일 {
    public static int soultion(int[][] targets) {
        int answer = 0;

        // 평균 : O(nlog(n)) / 최악 : O(n^2)
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        int x = 0;

        for (int i = 0; i < targets.length; i++) {
            if (x <= targets[i][0]) {
                x = targets[i][1];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};

        System.out.println(soultion(targets));
    }
}
