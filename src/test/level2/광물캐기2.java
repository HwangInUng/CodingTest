package test.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.frequency;

public class 광물캐기2 {
    /*
     * picks : 곡괭이의 개수, [dia, rion, stone] 순서
     * minerals: 광물들의 순서, 3개의 문자열로 이루어져 있음
     *
     * */
    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;

        // minerals 5개 단위로 나누기
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < minerals.length / 5 + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < minerals.length / 5 + 1; i++) {
            // i가 증가할 때마다 5개 단위 요소를 저장
            for (int j = 0 + i * 5; j < 5 + i * 5; j++) {
                if (j >= minerals.length) break;
                list.get(i).add(minerals[j]);
            }
        }

        // 배열의 요소가 5개 단위로 나누어 떨어지면 불필요한 마지막 요소 생성을 방지
        if (minerals.length % 5 == 0) {
            list.remove(list.size() - 1);
        }

        // 곡괭이보다 광물이 많을 경우 해당 광물들 삭제
        int pickSum = picks[0] + picks[1] + picks[2];
        if (pickSum < list.size()) {
            int countWillRemove = list.size() - pickSum;
            for (int i = 0; i < countWillRemove; i++) {
                list.remove(list.size() - 1);
            }
        }

        // 5개 단위로 나눈 Subset을 정렬
        Collections.sort(list, (l1, l2) -> {
            if (frequency(l2, "diamond") == frequency(l1, "diamond")) {
                if (frequency(l2, "iron") == frequency(l1, "iron")) {
                    return frequency(l2, "stone") - frequency(l1, "stone");
                } else {
                    return frequency(l2, "iron") - frequency(l1, "iron");
                }
            } else {
                return frequency(l2, "diamond") - frequency(l1, "diamond");
            }
        });

        // 순서대로 채광
        for(int i = 0; i < picks[0]; i++){
            if (list.isEmpty()) break;
            List<String> currentList = list.get(0);
            for(int j = 0; j < currentList.size(); j++){
                answer += 1;
            }
            list.remove(0);
        }

        for (int i = 0; i < picks[1]; i++){
            if(list.isEmpty()) break;
            List<String> currentList = list.get(0);
            for(int j = 0; j < currentList.size(); j++){
                if(currentList.get(j).equals("diamond"))answer += 5;
                else answer += 1;
            }
            list.remove(0);
        }

        for(int i = 0; i < picks[2]; i++){
            if(list.isEmpty()) break;
            List<String> currentList = list.get(0);
            for(int j = 0; j < currentList.size(); j++){
                if(currentList.get(j).equals("diamond")) answer += 25;
                else if (currentList.get(j).equals("iron")) answer += 5;
                else answer += 1;
            }
            list.remove(0);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

        System.out.println(solution(picks, minerals));
    }

}
