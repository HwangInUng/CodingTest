package test.leetcode;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // 좌우측에서 조건에 따라 좁혀가며 반복
        // 중간 값은 좌측 + (우측 - 좌측) / 2로 계산

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // 예를 들어 left 3, right 8이면
            // 3 + (8 - 3) / 2니까
            // 8 / 2 = 4로 중간 값을 가지게 됨
            int middle = left + (right - left) / 2;

            if(nums[middle] == target) {
                return middle;
            }

            if(target < nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}
