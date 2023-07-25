package test.level1;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.Stack;

public class 햄버거만들기 {
    public static int solution(int[] ingredient){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i : ingredient){
            stack.push(i); //문자열 내 햄버거 형태의 문자열 포함여부 확인을 위한 변수

            if(stack.size() >= 4){

                if(stack.get(stack.size() - 4) == 1 &&
                        stack.get(stack.size() - 3) == 2 &&
                        stack.get(stack.size() - 2) == 3 &&
                        stack.get(stack.size() - 1) == 1) {

                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
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
