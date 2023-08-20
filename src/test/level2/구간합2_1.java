package test.level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합2_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());

        long[] arr = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.valueOf(br.readLine());
        }

        SegmentTree tree = new SegmentTree(arr);
        tree.init(1, 1, n);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            long c = Long.valueOf(st.nextToken());

            if (a == 1) {
                tree.update(1, 1, n, b, c - tree.getArray()[b]);
                tree.updateArray(b, c);
            } else {
                System.out.println(tree.sum(1, 1, n, b, (int) c));
            }
        }
        br.close();
    }

    private static class SegmentTree {
        private long[] nArray;
        private long[] tree;

        public SegmentTree(long[] arr) {
            int height = (int) Math.ceil(Math.log(arr.length - 1) / Math.log(2));
            int treeSize = (int) Math.pow(2, height + 1);

            tree = new long[treeSize];
            this.nArray = arr;
        }

        public long init(int node, int start, int end) {
            if (start == end) {
                return this.tree[node] = this.nArray[start];
            }

            int mid = (start + end) / 2;
            return this.tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
        }

        public void update(int node, int start, int end, int index, long diff) {
            if (index < start || end < index) {
                return;
            }

            this.tree[node] += diff;
            int mid = (start + end) / 2;

            if (start != end) {
                update(node * 2, start, mid, index, diff);
                update(node * 2 + 1, mid + 1, end, index, diff);
            }
        }

        public long sum(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 0;
            }

            if (left <= start && end <= right) {
                return this.tree[node];
            }

            int mid = (start + end) / 2;
            return sum(node * 2, start, mid, left, right) +
                    sum(node * 2 + 1, mid + 1, end, left, right);
        }

        public long[] getArray() {
            return this.nArray;
        }

        public void updateArray(int index, long value) {
            this.nArray[index] = value;
        }
    }
}
