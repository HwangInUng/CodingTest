package test.level2;

import java.util.ArrayList;
import java.util.List;

public class 수열의합 {
    public int[] solution(int[] sequence, int k) {
        int sum = sequence[0];
        int left = 0;
        int right = 0;
        int n = sequence.length;

        List<SubSequence> subs = new ArrayList<>();
        while (true) {
            if (sum == k) {
                subs.add(new SubSequence(left, right));
            }
            if (left == n && right == n) break;

            if (sum <= k && right < n) {
                right++;
                if (right < n) sum += sequence[right];
            } else {
                if (left < n) sum -= sequence[left];
                left++;
            }
        }
        subs.sort(SubSequence::compareTo);

        return new int[]{subs.get(0).left, subs.get(0).right};
    }

    public static void main(String[] args) {
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;

        수열의합 number = new 수열의합();

        System.out.println(number.solution(sequence, k));
    }

    private class SubSequence implements Comparable<SubSequence> {
        int left;
        int right;
        int size;

        public SubSequence(int left, int right) {
            this.left = left;
            this.right = right;
            this.size = right - left;
        }

        @Override
        public int compareTo(SubSequence o) {
            if (this.size == o.size) {
                return this.left - o.left;
            }
            return this.size - o.size;
        }
    }
}
