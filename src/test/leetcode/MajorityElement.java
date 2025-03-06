package test.leetcode;

import java.util.HashMap;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		// 문제
		// n의 길이의 정수형 배열이 주어짐
		// 배열내에서 가장 많이 반복되는 정수를 반환

		// 고려사항
		// 시간 복잡도 : 선형 O(n)
		// 공간 복잡도 : O(1)

		// 문제해결
		// Map에 반복되는 숫자 정보를 저장
		// 저장된 Map을 순회하며 value가 가장 높은 key를 반환

		HashMap<Integer, Integer> map = new HashMap<>();
		int result = 0;
		int maxValue = Integer.MIN_VALUE;

		if(nums.length == 1) {
			return nums[0];
		}

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for(int key : map.keySet()) {
			if(map.get(key) > maxValue) {
				maxValue = map.get(key);
				result = key;
			}
		}

		return result;
	}
}
