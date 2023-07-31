package test.level1;

import java.util.*;

public class 햄버거만들기2 {
    public static int solution(int[] ingredient){
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        for(int i : ingredient){
            list.add(i); //문자열 내 햄버거 형태의 문자열 포함여부 확인을 위한 변수

            if(list.size() >= 4){

                if(list.get(list.size() - 4) == 1 &&
                        list.get(list.size() - 3) == 2 &&
                        list.get(list.size() - 2) == 3 &&
                        list.get(list.size() - 1) == 1) {

                    answer++;
                    list.remove(list.size()-4);
                    list.remove(list.size()-3);
                    list.remove(list.size()-2);
                    list.remove(list.size()-1);
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] ingredient = {1, 1, 2, 1, 2, 3, 1, 3, 1, 2, 3, 1};

        System.out.println(solution(ingredient));
    }
}
