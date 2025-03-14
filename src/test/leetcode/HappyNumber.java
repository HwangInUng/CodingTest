package test.leetcode;

import java.util.HashSet;

public class HappyNumber {
	public boolean isHappy(int n) {
		// 문제
		// 양의 정수가 주어짐
		// 해당 정수의 자리수를 분리하여 제곱의 합을 반복하여
		// happy(1) 여부를 확인

		// 고려사항
		// n은 1이상 양의 정수이며,
		// Integer의 데이터 범위를 초과하지 않음

		// 문제해결
		// 중복된 합이 있는 경우 지속적인 루프 반복이 되지 않기 때문에
		// set에 중복되지 않은 합을 저장하여 매 반복마다 비교
		// 이 방법 말고도 n이 4가 되는 경우 무한루프에 빠지는 것을 확인할 수 있음
		HashSet<Integer> set = new HashSet<>();

		while(!set.contains(n)) {
			set.add(n);
			n = getSum(n);

			if(n == 1) {
				return true;
			}
		}


		return false;
	}

	public int getSum(int n) {
		int sum = 0;

		while(n > 0) {
			sum += (n%10) * (n%10);
			n = n/10;
		}

		return sum;
	}
}
