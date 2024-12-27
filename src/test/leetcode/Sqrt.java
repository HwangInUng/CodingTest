package test.leetcode;

public class Sqrt {
    public int mySqrt(int x) {
        // 문제
        // 양의 정수 x에 대한 제곱근을 반환하는 문제

        // 고려사항
        // 소수점인 경우 내림하여 근접한 정수를 반환
        // sqrt() 등 내장 함수를 사용하면 안됨

        // 문제 해결
        // 이분탐색을 통해 왼쪽, 오른쪽 범위를 좁혀가며 수행
        // 이분 탐색 지점끼리의 곱이 같은 경우
        // 이분 탐색 지점끼리의 곱이 더 큰 경우
        // 이분 탐색 지점끼리의 곱이 더 작은 경우
        // 세가지로 분류하여 수행

        if(x == 0 || x == 1) {
            return x;
        }

        long left = 0;
        long right = x;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if(mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) right;
    }
}
