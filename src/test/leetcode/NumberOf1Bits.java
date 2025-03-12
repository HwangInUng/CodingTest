package test.leetcode;

public class NumberOf1Bits {
	public int hammingWeight(int n) {
		String binaryStr = Integer.toBinaryString(n);

		int count = 0;

		for (int i = 0; i < binaryStr.length(); i++){
			if(binaryStr.charAt(i) == '1') {
				count++;
			}
		}

		return count;
	}
}
