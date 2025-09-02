package test.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Zigzag {
	public String convert (String s, int numRows) {
		// 문제
		// 문자열 s를 주어진 numRows에 맞게 지그재그로 배치
		// 지그재그 방향 최초 위에서 아래로 시작하며,
		// numRows에 도달하면 대각선 위로 이동,
		// 위 동작을 반복하여 문자열의 마지막까지 수행
		// 이후 배치된 문자열을 1개 로우씩 이어붙어 반환

		// 해결 방향
		// 2차원 리스트를 이용하여 문자열 배치
		// numRows에 도달하면 세로 이동을 멈추고, isVertical을 true로 변환
		// 0이 되면 isVertical을 false로 변경
		// 빈 공간은 " "로 채우고, 차후 제거
		// 문자열을 스트링 빌더에 쌓아서 반환

		if (numRows == 1) {
			return s;
		}

		int y = 0;
		boolean isVertical = false;
		List<List<String>> zigzag = new ArrayList<>();

		for (int i = 0; i < numRows; i++) {
			zigzag.add(new ArrayList<>());
		}

		for (int i = 0; i < s.length(); i++) {
			String current = String.valueOf(s.charAt(i));

			if (!isVertical) {
				zigzag.get(y).add(current);
				y++;
			}

			if (isVertical) {
				if (y < numRows && y > 0) {
					zigzag.get(y).add(current);
				} else {
					zigzag.get(y).add(" ");
				}
				y--;
			}

			if (y == numRows - 1) {
				isVertical = true;
			}

			if (y == 0) {
				isVertical = false;
			}

		}

		StringBuilder sb = new StringBuilder();
		for (List<String> list : zigzag) {
			for (String word : list) {
				if (!word.equals(" ")) sb.append(word);
			}
		}

		return sb.toString();
	}
}
