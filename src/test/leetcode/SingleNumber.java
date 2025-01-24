package test.leetcode;

import java.util.HashSet;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        // 문제
        // 배열에서 짝이 없는 요소를 반환

        // 고려사항
        // 배열의 길이는 1~30,000
        // 각 요소의 값은 -30,000~30,000
        // 배열 내에 짝이 없는 요소가 2개 존재 할 수 없음
        // 짝이 있는 요소로만 구성될 수도 없음

        // 문제 해결
        // 배열의 시작과 끝지점에서 Set에 요소를 저장
        // 요소가 있는 경우 삭제
        // 없는 경우 저장
        // 마지막에 Set에 남은 요소를 반환
        // 시간 복잡도 : O(n), 공간 복잡도 : O(n)

        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        int right = nums.length - 1;

        if (nums.length == 1) {
            return nums[0];
        }

        while (left < right) {
            if (set.contains(nums[left])) {
                set.remove(nums[left]);
            } else {
                set.add(nums[left]);
            }

            if (set.contains(nums[right])) {
                set.remove(nums[right]);
            } else {
                set.add(nums[right]);
            }

            left++;
            right--;
        }

        if (set.contains(nums[left])) {
            set.remove(nums[left]);
        }

        if (set.isEmpty()) {
            set.add(nums[left]);
        }

        return set.iterator().next();
    }
}
