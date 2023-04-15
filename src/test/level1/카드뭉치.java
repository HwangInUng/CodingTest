package test.level1;

public class 카드뭉치 {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        boolean result = false;
        int length1 = 0;
        int length2 = 0;

        //1. cards1과 cards2를 차례대로 순회하며 goal[i]번째와 일치하는 단어확인
        for (String str : goal) {
            //2. cards1, 2의 length를 벗어나면 남은 배열에서만 해당 단어 확인
            if (cards1.length > length1 && cards1[length1].equals(str)) {
                result = true;
                length1++;
            } else if (cards2.length > length2 && cards2[length2].equals(str)) {
                result = true;
                length2++;
            } else { //3. cards1, 2에 해당 단어가 없으면 "No" 리턴 후 반복문 종료
                return "No";
            }
        }

        //3. 결과반환
        return (result ? "Yes" : "No");
    }

    //테스트 케이스
    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        System.out.println(solution(cards1, cards2, goal));
    }
}
