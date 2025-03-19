package test.leetcode;

import java.util.HashMap;

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		// 문제
		// 두 개의 문자열의 형태가 동일한지 확인하는 문제
		// 문자열의 생김새가 동일하면 true, 아니면 false

		// 고려사항
		// 두 문자열의 길이는 항상 같다.
		// 문자열의 길이는 1 ~ 50,000
		// 주어진 문자열은 아스키 코드에 포함된 문자로만 구성

		// 문제 해결
		// map을 이용해 key와 value로 짝을 지어줌
		// 반복 시 value가 상이하거나 짝이 없는 value인 경우 false
		HashMap<Character, Character> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);

			if(map.containsKey(sc)) {
				if(map.get(sc) != tc) {
					return false;
				}
			} else if(map.containsValue(tc)) {
				return false;
			} else {
				map.put(sc, tc);
			}
		}

		return true;
	}
}
