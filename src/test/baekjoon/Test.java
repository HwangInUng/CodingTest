package test.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        dp();
    }

    // 0 이상 정수로 구성된 배열이 주어진다.
    // arr[i] = i를 만족하는 beauty의 수를 반환해라.
    // arr[i] = i가 만족하면, arr[i] 요소는 delete한다.
    public static void dp() {
        // i는 1부터 시작한다.
        // 배열의 요소는 0번부터 시작한다.
        // 이 점을 인지하고, 현재 요소는 i - 1로 계산한다.
        int[] arr = new int[]{1, 3, 2, 5, 4, 5, 3};

        // i = 1부터 시작하고, 현재 요소를 i - 1로 설정한다.
        // dp라는 새배열을 생성하고, 해당 배열에 i 위치에 값을 추가한다.
        int[] dp = new int[arr.length + 1];
        // i와 현재 요소가 동일하면 beauty 증가
        // i와 현재 요소가 다른데 현재 요소가 크다면 현재 i를 lastIndex에 저장
        // i와 현재 요소가 다른데 현재 요소가 작다면 lastIndex와 현재 요소가 맞는지 확인
        // 맞다면 arr[i] = i에 일치하므로 beauty 증가
        int lastIndex = 0;

        for (int i = 1; i <= arr.length; i++) {
            int current = arr[i - 1];

            if (i == current) {
                // beauty의 증가는 배열의 전 요소에서 + 1
                dp[i] = dp[i - 1] + 1;
            } else if (i < current) {
                lastIndex = i;
                dp[i] = dp[i - 1];
            } else {
                if (lastIndex == current) {
                    dp[i] = dp[i - 1] + 1;
                    lastIndex = i;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }

        System.out.println(dp[dp.length - 1]);
    }

    // n 길이의 시작 및 종료 시간이 들어있는 각각의 배열이 있다.
    // 프로세스 시작 및 종료 시간을 참고하여 가장 작은 수의 코어를 반환해라.
    public static void scheduler() {
        // 프로세스 간에 시작 및 종료 시간이 겹치는 경우들이 발생
        // 이 때는 코어를 하나 추가하여 프로세스를 처리

        // 프로세스 실행 : 코어 1개 사용
        // 동시간대 프로세스 2개 실행 : 코어 2개 사용
        // 1개 종료 시 : 코어 반납
        // 위 규칙을 토대로 시작 시 대기중인 코어가 있으면 사용
        // 없으면 추가하는 방식으로 처리
        // 이 때 동시간대에 가장 많은 코어수를 max에 저장하여 결과로 반환
        int[] start = new int[]{1, 2, 3};
        int[] end = new int[]{3, 3, 5};

        // 리스트에 1차원 배열을 저장 -> 0 - start or end, 1 -> 1(add) or -1(remove)
        ArrayList<int[]> processes = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            processes.add(new int[]{start[i], 1});
            processes.add(new int[]{end[i], -1});
        }

        // 시간 기준으로 정렬
        // 만약 시작 및 종료 시간이 같은 경우 value로 정렬하여 core를 먼저 추가
        processes.sort((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        // list를 순회하며 max 값 구하기
        int max = 0;
        int cores = 0;
        for (int[] process : processes) {
            cores += process[1];
            max = Math.max(max, cores);
        }

        System.out.println(max);
    }

    // 문자열 배열이 주어지면 해당 배열에서 동일한 알파벳으로 구성된 문자열의 수를 반환
    // 문자열은 소문자로만 구성
    public static void similarStrings() {
        // pair의 수를 찾아야 하기 때문에 pair * (pair-1) / 2로 계산
        String[] words = {"aba", "abaca", "baab", "cba"};
        HashMap<String, Integer> map = new HashMap();
        int pair = 0;

        for (String word : words) {
            // 문자열을 char형 배열로 변환 후 정렬
            char[] arr = word.toCharArray();
            Arrays.sort(arr);

            StringBuilder sb = new StringBuilder();
            // 중복되는 문자 제거
            for (char c : arr) {
                if (sb.isEmpty()) {
                    sb.append(c);
                    continue;
                }

                if (sb.charAt(sb.length() - 1) != c) {
                    sb.append(c);
                }
            }

            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // overflow를 대비하여 long형으로 캐스팅
        for (Integer value : map.values()) {
            if (value > 1) {
                pair += (long) value * (value - 1) / 2;
            }
        }

        System.out.println(pair);
    }
}
