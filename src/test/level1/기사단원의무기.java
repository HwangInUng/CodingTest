package test.level1;

public class 기사단원의무기 {
    public static int solution(int number, int limit, int power) {
        int answer = 0;
        int sum = 0;

        for(int i = 1; i <= number; i++){
            for(int j = 1; j*j <= i; j++){
                if(j * j == i) sum++;
                else if(i % j == 0) sum += 2;
            }
            if(sum <= limit){
                answer += sum;
            } else{
                answer += power;
            }
            sum = 0;
        }

        return answer;
    }
    public static void main(String[] args) {
        int number = 5;
        int limit = 3;
        int power = 2;

        System.out.println(solution(number, limit, power));
    }
}
