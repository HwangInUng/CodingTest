package test.level1;

import java.util.ArrayList;
import java.util.Collections;

public class 푸드파이트 {
    public static String solution(int[] food){
        StringBuilder answer = new StringBuilder();

        for(int i = 1; i < food.length; i++){
            // 1. 배열 요소의 홀수 여부를 판단하여 홀수일 경우 -1
            if(food[i] % 2 != 0){
                food[i] -= 1;
            }

            // 2. 반복문을 수행하며 요소의 수만큼 2중 반복문을 통해 append()
            int count = food[i]/2; // 배열 길이의 절반만큼 반복문 수행
            for(int j = 0; j < count; j++){
                answer.append(i);
            }
        }
        // 4. 생성된 String에 0을 추가
        answer.append(0);

        // 5. 기존 String을 내림차순으로 추가하여 완성
        for(int i = answer.length()-2; i >= 0; i--){
            answer.append(answer.charAt(i));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};

        System.out.println(solution(food));
    }
}
