package test.level1;
/*
* 2개의 String 배열을 교차로 합쳐야하는 예제
* -A배열은 B배열의 길이의 2배 이하
* -B배열의 length만큼 도달했다면 0번째부터 다시 삽입
* -A배열이 모두 삽입된 경우 B배열이 마지막으로 삽입되어야함
*/
public class 배열합치기 {
    public static String[] solution(String[] a, String[] b){
        //각 배열의 길이를 판단할 지표
        int a_length = 0;
        int b_length = 0;

        //병합할 배열의 길이
        int length = a.length + b.length;

        //배열의 길이가 홀수 일 경우 짝수로 변환
        String[] c = new String[length % 2 != 0 ? length + 1 : length];

        for(int i = 0; i < c.length; i++){
            //i가 0 또는 2의 배수인 경우 a배열의 요소 삽입
            if(i == 0 || i % 2 == 0){
                c[i] = a[a_length];
                a_length++;
            } else {
                //i가 홀수 일 경우 b배열의 요소 삽입
                //b 배열의 길이를 초과하면 0으로 리셋
                if(b_length > b.length-1){
                    b_length = 0;
                }
                c[i] = b[b_length];
                b_length++;
            }
        }
        return c;
    }
    public static void main(String[] args) {
        //2개의 String[]
        String[] a = {"A", "B", "C", "D", "E", "Z"};
        String[] b = {"G", "H", "T"};

        //응답 String[]
        String[] answers = solution(a, b);

        for(String answer : answers){
            System.out.print(answer);
        }
    }
}
