public class BestTimeStock {
    public int maxProfit(int[] prices) {
        // 문제
        // 일자별 주식 가격이 배열로 제공
        // 매수와 매도의 개념으로 가장 많은 이익을 반환

        // 고려사항
        // 매수가 된 상태에서 매도가 이루어져야함
        // 배열의 길이는 1~100,000
        // 각 요소의 값은 0~10,000
        // 만약 아무런 이익이 없다면 0을 반환
        // 매수 이후의 날짜와 비교해서 이익을 판단

        // 문제 해결
        // 길이가 1이하 경우 return 0
        // 매도의 가장 큰수를 구해서 차이를 반환
        // 만약, 첫 번째 요소가 가장 큰 수라면 0
        // 한 번의 반복을 통해 문제 해결 가능 : O(n)
        if (prices.length < 2) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int result = 0;
        boolean firstIsMax = true;

        for (int i = 0; i < prices.length - 1; i++) {
            int curr = prices[i];
            int next = prices[i + 1];

            if (curr < min) {
                min = curr;
                max = 0;
            }

            if (curr <= next) {
                max = Math.max(max, next);
                firstIsMax = false;
            }

            result = Math.max(result, max - min);
        }


        return firstIsMax ? 0 : result;
    }
}
