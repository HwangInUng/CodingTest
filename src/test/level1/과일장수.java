package test.level1;

import java.util.ArrayList;
import java.util.Collections;

public class 과일장수 {
    public static int solution(int k, int m, int[] score){
        int answer = 0;

        // 1.배열의 특정 값을 삭제하기 위하여 Arrays -> ArrayList로 변환
        ArrayList<Integer> list = new ArrayList();

        // 2. List의 값을 추가하고, 순차정렬
        for(int s : score){
            list.add(s);
        }
        Collections.sort(list);

        // 3. list의 길이가 박스 내 개수(m)로 나눌 수 없는 경우 나머지를 버림
        if(list.size()%m != 0){
            int num = list.size() % m;
            for(int i = 0; i < num; i++){
                list.remove(0);
            }
        }

        // 4. list의 박스별 총합을 구하여 반환
        answer = sumPoint(list, m);

        return answer;
    }

    // list의 합을 구하는 함수
    public static int sumPoint(ArrayList list, int m){
        int answer = 0;
        int count = 0;

        // 1. list의 길이 / 박스 내 개수 동안 반복문 실행
        for(int i = 0; i < list.size()/m; i++){
            // 2. 박스별 점수를 담을 배열 생성(반복문 마다 초기화)
            int[] point = new int[m];

            // 3. 박스별 점수 배열의 길이만큼 반복문 수행하며 list의 객체를 1개씩 저장
            for(int j = 0; j < point.length; j++){
                point[j] = (int) list.get(count);
                count++;
            }
            // 4. 저장된 배열의 0번째(가장작은 수) * 박스 내 개수(m)
            answer += point[0] * m;
        }
        // 5. 결과 반환
        return answer;
    }

    public static void main(String[] args) {
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        System.out.println(solution(k, m, score));
    }
}
