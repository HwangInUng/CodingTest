package test.leetcode;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // 정수로 구성된 배열이 주어진다.
        // 배열 내에서 2개의 수를 더해서 target이 완성되는 요소의 인덱스를 반환하라.

        // 타겟과 정수는 음수도 가능
        // 배열의 크기는 10,000 이하
        // 시간복잡도 O(n log n) 이내로 수행해야 해결 가능

        // 배열을 순회하며 각 요소의 값을 key, 인덱스를 value로 HashMap에 저장
        // 다시 배열을 순회하며 target - 현재 요소 값이 HashMap에 있는 경우
        // 두 요소의 인덱스 배열을 반환

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if (map.containsKey(rest) && map.get(rest) != i) {
                result[0] = i;
                result[1] = map.get(rest);
            }
        }

        return result;
    }
}
