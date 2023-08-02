package test.level1;

public class 옹알이풀이 {
    public static int solution(String[] babbling) {
        String[] word = {"aya", "ye", "woo", "ma"};
        int count = 0;

        for (int i = 0; i < babbling.length; i++) {
            String element = babbling[i];
            if (element.contains("ayaaya") || element.contains("yeye") || element.contains("woowoo") || element.contains("mama")) {
                continue;
            }

            element = element.replace("aya", " ");
            element = element.replace("ye", " ");
            element = element.replace("woo", " ");
            element = element.replace("ma", " ");
            element = element.replace(" ", "");

            if (element.length() == 0) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

        System.out.println(solution(babbling));
    }
}
