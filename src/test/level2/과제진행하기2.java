package test.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class 과제진행하기2 {

    public static class Task {
        String name;
        int startTime;
        int playTime;

        public Task(String name, String startTime, String playTime) {
            this.name = name;
            this.startTime = timeToMinute(startTime);
            this.playTime = Integer.valueOf(playTime);
        }

        // String -> Integer 시간으로 변경
        public int timeToMinute(String start) {
            String[] arr = start.split(":");
            int h = Integer.valueOf(arr[0]) * 60;
            int m = Integer.valueOf(arr[1]);

            return h + m;
        }
    }

    // 재귀적으로 Stack에서 비교
    public static void recursivePop(Stack<Task> stack, Task newTask, int curTime, List<String> answer) {
        if (stack.isEmpty()) return;

        // 진행 중인 과제
        Task curTask = stack.peek();
        if (curTime + curTask.playTime <= newTask.startTime){
            answer.add(stack.pop().name);
            // 진행중인 과제가 새로운 과제의 시작시간보다 작거나 같다면
            // 재귀함수 호출
            recursivePop(stack, newTask, curTime + curTask.playTime, answer);
        } else {
            curTask.playTime -= newTask.startTime - curTime;
        }
    }

    public static String[] solution(String[][] plans) {
        // 과제 배열 List로 변환
        List<Task> taskList = Arrays.stream(plans)
                .map(plan -> new Task(plan[0], plan[1], plan[2]))
                .collect(Collectors.toList());

        // 오름차순 정렬
        taskList.sort((o1, o2) -> {
            return o1.startTime - o2.startTime;
        });

        // 진행중인 과제를 저장
        Stack<Task> stack = new Stack<>();
        List<String> answer = new ArrayList<>();

        // 현재 시간 초기화
        int curTime = -1;

        for (int i = 0; i < taskList.size(); i++) {
            // 진행중인 과제가 없다면 과제 삽입
            if (stack.isEmpty()) {
                stack.push(taskList.get(i));
                continue;
            }

            // 진행중인 과제와 새로운 과제가 있는 경우
            Task curTask = stack.peek();
            Task newTask = taskList.get(i);

            // 새로운 과제의 시작시간과 진행중 과제의 종료시간을 비교하기 위해 세팅
            curTime = curTask.startTime;

            if (curTime + curTask.playTime <= newTask.startTime) {
                // 재귀함수 호출
                recursivePop(stack, newTask, curTime, answer);
            } else {
                // 현재 수행중인 과제를 중단하고 시간 갱신 및 새 과제 수행
                // 새로운 과제의 시작시간과 현재 수행과제의 시작시간의 차이를 수행시간에서 빼기
                curTask.playTime -= newTask.startTime - curTime;
            }

            stack.push(newTask);
        }

        // 과제에 대한 반복문 종료 후
        // 남아있는 stack의 이름을 순서대로 저장
        while (!stack.isEmpty()) {
            answer.add(stack.pop().name);
        }

        return answer.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};

        System.out.println(solution(plans));
    }
}
