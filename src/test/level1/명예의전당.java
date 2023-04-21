import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 명예의전당 {
    public static int[] solution(int k, int[] score){
        int[] answer = new int[score.length];
        ArrayList<Integer> scoreList = new ArrayList();
        ArrayList<Integer> topList = new ArrayList();
        for(int i : score){
            scoreList.add(i);
        }

        for(int i = 0; i < scoreList.size(); i++){
            int s = scoreList.get(i);
            if(i < k){
                topList.add(s);
            } else {
                if (Collections.min(topList) < s) {
                    topList.remove(Collections.min(topList));
                    topList.add(s);
                }
            }
            answer[i] = Collections.min(topList);
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};

        System.out.println(solution(k, score));
    }
}
