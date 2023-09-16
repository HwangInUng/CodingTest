package test.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 과제진행하기 {

    public static class Plan {
        String name;
        int time;
        int playTime;

        public Plan(String name, int time, int playTime) {
            this.name = name;
            this.time = time;
            this.playTime = playTime;
        }
    }

    public static String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        List<Plan> list = new ArrayList<>();
        Stack<Plan> stack = new Stack<>();

        // 시각을 숫자로 변환
        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            int hour = 60 * Integer.valueOf(plans[i][1].split(":")[0]);
            int time = hour + Integer.valueOf(plans[i][1].split(":")[1]);
            int playTime = Integer.valueOf(plans[i][2]);

            list.add(new Plan(name, time, playTime));
        }
        // 시각을 기준으로 정렬
        list.sort((o1, o2) -> {
            return o1.time - o2.time;
        });

        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                answer[i] = stack.size() > 0 ? stack.pop().name : list.get(i).name;
            } else {
                Plan prePlan = list.get(i);
                Plan curPlan = list.get(i + 1);

                int sum = prePlan.time + prePlan.playTime;

                if (sum <= curPlan.time) {
                    answer[i] = prePlan.name;
                    if (stack.size() > 0) {
                        Plan stopPlan = stack.pop();
                        if (curPlan.time - sum > stopPlan.playTime) answer[i] = stopPlan.name;
                        else stack.push(stopPlan);
                    }
                } else {
                    prePlan.playTime = curPlan.time - sum;
                    stack.push(prePlan);
                }
            }
            System.out.println(answer[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};

        System.out.println(solution(plans));
    }
}
