package test.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<Integer> getRow(int rowIndex) {
        // 문제
        // 파스칼 트라이앵글의 특정 행의 결과를 반환

        // 고려사항
        // rowIndex의 범위는 0 ~ 33
        // 공간 복잡도는 O(rowIndex)만을 사용

        // 문제해결
        // rowIndex는 legnth와 동일
        // 요소는 무조건 1개씩 증가
        // 0과 rowIndex - 1은 1로 고정
        // 위 사항을 고려하여 배열의 요소를 1부터 시작
        // i가 0과 length - 1이 아니면 i-1 + i를 i에 덮어쓰기
        // length - 1에 도달하면 length - 1 + 1
        // 마지막에 1을 추가
        List<Integer> result = new ArrayList<>();

        for (int row = 0; row <= rowIndex; row++) {
            result.add(0, 1);
            for (int i = 1; i < row; i++) {
                result.set(i, result.get(i) + result.get(i + 1));
            }
        }

        return result;
    }
}
