package test.leetcode;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        // 문제 정의
        // int형의 범위 내의 정수가 주어짐
        // 해당 정수의 펠린드롬 여부를 반환

        // 고려사항
        // 주어진 정수의 각 자리수를 비교해야함
        // 문자열을 사용하지 않고 해결해야함
        // 음수가 나오는 경우 false
        // 정수의 형태에서 - 부호가 숫자 중간에 위치할 수 없으니
        // 당연히 맨 앞자리와 맨 뒷자리가 불일치

        // 해결 방법
        // 주어진 정수와 뒤집은 정수를 각각 준비
        // 뒤집은 정수는 반복문을 통해 생성
        // % 10을 이용해 자리수를 비교하면서 진행
        // 시간 복잡도 O(n)

        if(x < 0) {
            return false;
        }

        int reverse = 0;
        int temp = x;

        while (temp > 9) {
            reverse += temp % 10;
            temp /= 10;
            reverse *= 10;
        }


        while (x > 9) {
            if(x % 10 != reverse % 10) {
                return false;
            }

            x = x / 10;
            reverse = reverse / 10;
        }


        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
