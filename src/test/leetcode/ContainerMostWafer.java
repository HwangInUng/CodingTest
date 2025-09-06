package test.leetcode;

public class ContainerMostWafer {
	public int maxArea (int[] height) {
		// 반복문 한번에 좌우측 인덱스를 축소하면서 max를 비교
		// (right - left) * height = water
		int max = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right) {
			int min = Math.min(height[left], height[right]);
			int diff = right - left;

			max = Math.max(max, diff * min);

			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}


		return max;
	}
}
