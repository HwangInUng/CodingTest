package test.level1;

public class 옹알이 {
    public static int solution(String[] babbling) {
        String[] word = {"aya", "ye", "woo", "ma"};
        int count = 0;
        boolean flag = false;

        for (int i = 0; i < babbling.length; i++) {
            String target = babbling[i];

            for (int j = 0; j < word.length; j++) {
                String element = word[j];

                // 1. word 중 1개라도 포함되어있는지 여부 확인
                if (target.contains(element)) {
                    String sum = element + element;

                    // 2. 반복되는 단어 여부 확인
                    if (target.contains(sum)) {
                        target = target.replace(sum, "");
                    }

                    // 4. 포함되는 element가 있다면 인덱스를 찾아서 0이 아니면 이전까지는 삭제
                    int index = target.indexOf(element);

                    if (index > 0) {
                        target = target.substring(0, index);
                        target = target.replace(element, "");
                    } else {
                        target = target.replace(element, "");
                    }

                    if (target.length() == 0) {
                        flag = true;
                        break;
                    } else {
                        flag = false;
                    }
                }
            }
            if (flag) {
                count++;
                flag = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

        System.out.println(solution(babbling));
    }
}
