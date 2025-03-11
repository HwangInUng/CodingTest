package test.leetcode;

public class ReverseBits {
	public int reverseBits(int n) {
		// 문제
		// 길이 32의 binary string을 뒤집은 정수형을 반환하는 문제

		// 고려 사항
		// 입력 값의 길이는 항상 32로 고정

		// 문제 해결
		// 비트 연산자를 이용하여 해결
		// 시프트 연산자로 답을 이동
		// 현재 n의 자리가 1이면 답을 1로 변경
		// n의 비트를 오른쪽으로 이동

		int result = 0;
		// 32비트 제약
		for(int i=0; i<32; i++){
			result = result <<1;
			if((n & 1) >0){
				result = result | 1;
			}
			n = n >>1;
		}
		return result;
	}
}
