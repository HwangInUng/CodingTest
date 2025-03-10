package test.leetcode;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String columnTitle) {
		// 문제
		// 알파벳으로 된 액셀 시트 컬럼 번호를 정수로 변경

		// 고려사항
		// 컬럼 타이틀 알파벳의 총 길이는 7이하
		// 오직 대문자 영여로만 구성
		// A ~ FXSHRXW의 범위를 가짐

		// 문제 해결
		// A - Z 까지 26의 범위를 가짐
		// 범위 x 현재 알파벳를 기본으로 계산
		// 다음 자리수가 없다면 해당 값을 반환
		// 다음 자리수가 있다면 동일한 로직을 반복 수행

		int range = 26;
		int length = columnTitle.length();
		int result = 0;

		for (int i = 0; i < length; i++) {
			int index = length - 1 - i;
			int word = columnTitle.charAt(index) - 'A'+ 1;

			result += Math.pow(range, i) * word;
		}

		return result;
	}
}
