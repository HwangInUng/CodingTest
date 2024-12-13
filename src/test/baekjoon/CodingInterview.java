package test.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class CodingInterview {
    public static void main(String[] args) {
        sumBigNumber();
    }

    // [1, 3, 2, 5, 4, 5, 3]
    // 위와 같은 배열이 주어졌을 때 다음 조건에 만족하는 결과를 반환하라.
    // arr[i] = i 이면, beauty 1 증가
    // 배열에서 최대 beauty 수를 반환
    // 여기서 i는 1이상 100이하의 수
    // 만약 arr[2] = 2이면, arr[2] = 3을 삭제 후 다음과 같은 배열 상태가 되어야함.
    // [1, 2, 5, 4, 5, 3]
    public static void beauty() {
        int[] arr = new int[]{1, 3, 2, 5, 4, 5, 3};

        // i가 1부터 시작하기 때문에 배열의 첫 번째 요소는 i - 1로 접근
        // 즉, 순서는 1이지만 배열의 원소 순서는 첫 번째라고 생각하고 문제에 접근
        // 그렇다면 i를 1부터 시자하여 배열의 길이와 동일할 때까지 반복문을 수행
        // arr[i] = i 조건을 만족하면 beauty 증가
        // 만족하지 않는다면 조건을 판단
        // i 보다 현재 요소가 크다면 조건이 성립될 수 없으므로 현재 i 값을 저장 후 이동
        // i 보다 현재 요소가 작다면 마지막 i 값을 확인하여 바로 이전 인덱스일 경우 arr[i] = i가 성립하므로
        // beauty 1을 증가하고 i값 최신화
        // 바로 이전 인덱스일 경우에는 arr[i] = i 일 때 arr[i] 요소가 삭제되었을 경우를 가정

        int[] dp = new int[arr.length + 1];
        // 최신 i의 위치를 저장할 변수
        int lastIndex = 0;

        for (int i = 1; i <= arr.length; i++) {
            // 현재 요소(인덱스 접근을 위해 순서에서 -1을 적용)
            int current = arr[i - 1];

            if (i == current) {
                // beauty 증가
                dp[i] = dp[i - 1] + 1;
            } else if (i < current) {
                // 이전 값과 동일하게 반영
                dp[i] = dp[i - 1];
                lastIndex = i;
            } else { // i보다 현재 요소가 작은 경우
                if (lastIndex == current) {
                    // beauty 증가
                    dp[i] = dp[i - 1] + 1;
                    lastIndex = i;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }

        // 가장 높은 beauty 출력
        System.out.println(Arrays.stream(dp).max().orElse(0));
    }

    // 프로세스가 수행될 때 최대로 사용되는 코어 수를 반환하는 문제
    // {1, 3}, {2, 3}, {3, 5} 등 배열로 주어짐
    // 다음 조건을 고려해서 필요한 코어 수를 반환
    // 프로세스 수행 시 1개의 코어가 사용
    // 이전 프로세스의 종료 시간과 다음 프로세스의 시작 시간이 동일하면 새로운 코어 사용
    // 프로세스가 완료되면 코어는 대기 상태
    // 이 때 동시간에 최대로 사용되는 코어 수를 반환
    public static void getMaxCores() {
        int[] start = new int[]{1, 2, 3};
        int[] end = new int[]{3, 3, 5};

        // 프로세스가 시작되면 코어를 사용하기 때문에 1 부여
        // 프로세스가 종료되면 코어를 반환하기 때문에 -1 부여
        // 만약 프로세스들의 시작 시간과 종료 시간이 겹친다면 시작하는 프로세스에 우선 순위 부여
        // 리스트에 프로세스를 시작과 종료시간 int[]로 저장
        // 각 요소의 시작 시간을 기준으로 오름차순으로 정렬을 한다.
        // 오름차순 정렬이 된 배열의 1번째, 즉 값을 코어 수로 누적하여 계산한다.
        // 동시간대에 가장 많이 누적된 코어 수를 변수에 저장하여 반환한다.
        ArrayList<int[]> processes = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            // 반복하며 시작 시간과 종료 시간을 하나의 배열로 삽입
            processes.add(new int[]{start[i], 1});
            processes.add(new int[]{end[i], -1});
        }

        // 시작 시간 순으로 정렬
        // 시간 시간이 같으면 종료 시간 기준으로 정렬
        Collections.sort(processes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        int maxCores = 0;
        int cores = 0;
        // 프로세스를 반복하며 동시간대 최대 코어 수 저장
        for (int[] process : processes) {
            // 코어의 증감을 누적
            cores += process[1];
            maxCores = Math.max(maxCores, cores);
        }

        System.out.println(maxCores);
    }

    // 문자열 배열이 주어졌을 때 동일한 문자로 구성된 쌍이 몇개 인지 반환
    // {"aba", "abaca", "baab", "cba"} 형태로 데이터가 주어진다
    public static void sameStringPairs() {
        String[] words = {"aba", "abaca", "baab", "cba"};

        // 문자열의 순서가 보장되어 있지 않은 상태
        // 문자열의 길이에 상관없이 구성된 문자가 동일한 쌍의 개수를 구해야한다.
        // 문자열의 알파벳 순서를 오름차순으로 정렬하고,
        // 정렬된 문자열에서 중복된 문자들을 제거한 뒤,
        // 해당 문자열을 key로 Hash를 사용하여 개수를 누적한다.
        // 누적된 문자열의 개수를 쌍으로 계산하여 반환한다.
        // 계산식 pair * pair(-1) / 2
        // pair-1은 기준이 되는 문자열을 제외한 값이며,
        // 나누기 2는 문자열의 개수가 아닌 쌍의 개수를 의미하기 때문

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            // 정렬을 위해 문자 배열로 변환 후 정렬
            char[] sortedWord = word.toCharArray();
            Arrays.sort(sortedWord);

            // 정렬된 상태의 문자들을 반복을 수행하며 중복 제거
            // 새 문자열로 조합
            StringBuilder combinedWord = new StringBuilder();
            for (char c : sortedWord) {
                // 초기 상태면 추가 후 다음 반복 진행
                if (combinedWord.isEmpty()) {
                    combinedWord.append(c);
                    continue;
                }

                // 중복되지 않은 문자만 추가
                // 순서대로 정렬했기 때문에 이전 문자가 동일하면 중복으로 판단
                if (combinedWord.charAt(combinedWord.length() - 1) != c) {
                    combinedWord.append(c);
                }
            }

            // 대상 문자를 누적하여 값을 증가
            String target = combinedWord.toString();
            map.put(target, map.getOrDefault(target, 0) + 1);
        }

        int pairs = 0;
        for (Integer pair : map.values()) {
            pairs += pair * (pair - 1) / 2;
        }

        System.out.println(pairs);
    }

    public static void sumBigNumber() {
        String number1 = "9223372036854775807";
        String number2 = "922337203685477";

        // 문자열의 길이가 다를 수 있다.
        // 길이가 다르기 때문에 뒤에서부터 계산하고,
        // 인덱스 범위 내에 있는 경우에만 sum을 수행한다.
        // 문자열의 합이 10이 넘는 경우 나머지를 처리하고,
        // 1을 다음번 연산에 더해준다.

        // 인덱스를 각각 감소시키며 진행
        // while문으로 1번인덱스 >= 0 || 2번인덱스 >= 0 동안 진행
        int index1 = number1.length() - 1;
        int index2 = number2.length() - 1;
        int carry = 0;

        StringBuilder result = new StringBuilder();

        while (index1 >= 0 || index2 >= 0) {
            int sum = carry;

            if (index1 >= 0) {
                sum += number1.charAt(index1--) - '0';
            }

            if (index2 >= 0) {
                sum += number2.charAt(index2--) - '0';
            }


            carry = sum / 10;

            result.append(sum % 10);
        }

        if (carry > 0) {
            result.append(carry);
        }

        System.out.println(result.reverse());
    }
}
