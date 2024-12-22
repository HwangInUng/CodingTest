package test.leetcode;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        // 문제
        // 문자열에서 공백으로 구분된 문자중
        // 가장 마지막 문자의 길이를 반환

        // 고려사항
        // 반드시 하나의 단어는 포함됨
        // 영어와 공백으로만 구성됨
        // s의 길이는 1~10,000

        // 문제해결
        // 공백 포함여부 확인
        // 공백을 포함하지 않으면 s의 길이를 반환
        // 마지막 인덱스부터 1씩 감소하며
        // 공백이 있는지 여부를 확인
        // 앞 뒤로 공백이 들어가는 경우를 고려하여
        // 맨 앞,뒤 공백을 제거

        char space = ' ';
        s = s.strip();

        int index = s.length() - 1;
        int count = 0;

        while (index >= 0) {
            if(s.charAt(index) == space) {
                break;
            } else {
                count++;
            }

            index--;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
}
