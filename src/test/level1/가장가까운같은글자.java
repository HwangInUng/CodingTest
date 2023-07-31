package test.level1;

public class 가장가까운같은글자 {
    public static int[] solution(String s) {
        int[] answer = new int[s.length()];

        //1. 배열 내 동일한 문자 판단
        for (int i = 0; i < s.length(); i++) {
            String word = Character.toString(s.charAt(i));
            //2. 동일 문자 없을 시 -1 배열에 저장
            if (i == 0) {
                answer[i] = -1;
            } else if (i > 0 && !s.substring(0, i).contains(word)) {
                answer[i] = -1;
            } else if (i > 0 && s.substring(0, i).contains(word)) {
                //3. 동일 문자 존재 시 현재 인덱스 - 해당 인덱스
                int index = s.lastIndexOf(word, i - 1);
                answer[i] = i - index;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "foobar";

        System.out.println(solution(s));
    }
}
