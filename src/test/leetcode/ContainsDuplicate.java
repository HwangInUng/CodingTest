package test.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		// 문제
		// 배열에서 서로 다른 인덱스의 요소가 같고,
		// 두 인덱스의 차이가 주어진 정수 이하인 경우 true를 반환하는 문제

		// 고려사항
		// 배열의 길이는 1 ~ 100,000
		// 요소의 크기는 -1,000,000,000 ~ 1,000,000,000
		// 정수의 크기는 0 ~ 100,000

		// 문제해결
		// set을 이용하여 정수를 저장
		// 만약 저장에 실패하면 중복으로 인식하여 true 반환
		// 인덱스가 k 이상이면 set에서 요소 삭제
		if(k == 0) {
			return false;
		}

		Set<Integer> set = new HashSet<>();

		for(int i = 0; i < nums.length; i++) {
			if(!set.add(nums[i])) {
				return true;
			}

			if(i >= k) {
				set.remove(nums[i-k]);
			}
		}

		return false;
	}
}
