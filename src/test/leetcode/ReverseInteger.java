package test.leetcode;

public class ReverseInteger {
	public int reverse(int x) {
		// 문제
		// int 범위 내 정수가 주어짐
		// Integer.MIN_VALUE의 범위는 변환 시 Long으로 인식하기 때문에 long으로 시작
		// 절대값으로 변경 후 negative 여부를 통해 반환 시 음수 처리
		// Integer.MIN_VALUE와 MAX_VALUE를 벗어나면 0 반환

		if(x == 0) {
			return 0;
		}

		long longX = x;
		boolean negative = longX < 0;

		String intToString = String.valueOf(Math.abs(longX));
		String convertedX = new StringBuilder(intToString).reverse().toString();

		longX = negative ? Long.valueOf(convertedX) * -1 : Long.valueOf(convertedX);

		if (longX > Integer.MAX_VALUE || longX < Integer.MIN_VALUE) {
			return 0;
		}

		return (int) longX;
	}
}
