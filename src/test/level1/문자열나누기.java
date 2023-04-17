package test.level1;

public class 문자열나누기 {
    public static int solution(String s){
        int count = 0;
        int x = 0;
        int y = 0;


        for(int i = 0; i < s.length(); i++){
            if(x == y){
                //3. x와 y가 같다면 count 증가 및 모든 지표 초기화
                count++;
                s = s.substring(i);
                x = 0;
                y = 0;
                i = 0;
            }
            //1. 문자열의 첫 글자를 선택
            String f = Character.toString(s.charAt(0));

            //2. 첫 글자와 동일한 글자가 나오면 해당길이 만큼 문자열 나누기
            String word = Character.toString(s.charAt(i));
            if(f.equals(word)){
                x++;
            } else if(!f.equals(word)){
                y++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        String s = "aaabbaccccabba";

        System.out.println(solution(s));
    }
}
