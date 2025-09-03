package test.leetcode;

public class StringToIntegerAtoi {
	public int myAtoi (String s) {
		long result = 0;
		boolean negative = false;
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		String stripS = s.strip();
		StringBuilder sb = new StringBuilder();

		if (stripS.isEmpty()) {
			return 0;
		}

		for (int i = 0; i < stripS.length(); i++) {
			char current = stripS.charAt(i);

			if (i == 0 && current == '-') {
				negative = true;
				continue;
			}

			if (i == 0 && current == '+') {
				continue;
			}

			if (!Character.isDigit(current)) {
				break;
			}

			if (Character.isDigit(current)) {
				if (sb.isEmpty() && current == '0') {
					continue;
				}
				sb.append(String.valueOf(current));
			}
		}
		String numberString = sb.toString();

		if (numberString.length() > 10 && negative) return min;
		if (numberString.length() > 10 && !negative) return max;

		result = numberString.isEmpty() ? 0 : Long.valueOf(numberString);

		result = negative ? -result : result;

		// Long의 범위에는 들어가지만 Integer 범위를 넘어선 경우 처리
		if (result > max) return max;
		if (result < min) return min;

		return (int) result;
	}
}
