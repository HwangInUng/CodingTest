package test.level1;


/*
* 자연수 N이 매개변수로 주어질 때 N의 자릿수별 총합을 반환
* 1. N은 100,000,000 이하의 자연수
* 2. 자료형 변환을 사용하지 않고 문제 해결
*/
public class 자연수합 {
    public static int solution(int n){
        //Math의 함수를 이용하여 자릿수-1 획득
        int length = (int) Math.log10(n);
        /*
        * 만약 n이 한자릿수(10이하)라면 n을 그대로 반환
        * pow() 이용 length만큼 거듭제곱
        * (ex: 10,000일 경우 log = 4이므로 x = 10의 4제곱)
        */
        int x = (n < 10 ? 0 : (int) Math.pow(10, length));

        int sum = 0;
        if (n < 10) {
            sum = n;
        } else {
            for (int i = 0; i <= length; i++) {
                if (i == 0) { //첫번째(가장 큰) 자릿 수 / x
                    sum += n / x;
                } else if (i == length) { //length의 마지막은 1의 자릿수이므로 10으로 나눈 나머지
                    sum += n % 10;
                } else { // 중간자릿수들은 x/10씩 나눠주면서 연산 수행
                    sum += n % x / (x / 10);
                    x = x/10;
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int n = 53423;
        System.out.println(solution(n));
    }
}
