package test.level2;

import javax.swing.text.Segment;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합2_1 {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int n = Integer.valueOf(stringTokenizer.nextToken());
        int m = Integer.valueOf(stringTokenizer.nextToken());
        int k = Integer.valueOf(stringTokenizer.nextToken());

        long[] arr = new long[n + 1];

        for (int i = 1; i <= n; i++){
            arr[i] = Long.valueOf(bufferedReader.readLine());
        }

        SegmentTree segmentTree = new SegmentTree(arr);
        segmentTree.init(1, 1, n);

        for(int i = 0; i < m+k; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int a = Integer.valueOf(stringTokenizer.nextToken());
            int b = Integer.valueOf(stringTokenizer.nextToken());
            long c = Long.valueOf(stringTokenizer.nextToken());

            if (a == 1){
                segmentTree.update(1, 1, n, b, c - segmentTree.getnArray()[b]);
                segmentTree.updatenArray(b, c);
            } else{
                System.out.println(segmentTree.sum(1, 1, n, b, (int)c));
            }
        }
        bufferedReader.close();
    }

   static class SegmentTree{
        private long[] tree;
        private long[] nArray;

        public SegmentTree(long[] arr){
            int height = (int) Math.ceil(Math.log(arr.length - 1) / Math.log((2)));

            tree = new long[(int)Math.pow(2, height + 1)];
            this.nArray = arr;
        }

        public long init(int node, int start, int end){
            if (start == end){
                return this.tree[node] = this.nArray[start];
            }
            return this.tree[node] = init(node * 2, start, (start + end) / 2) +
                    init(node * 2 + 1, (start + end) / 2 + 1, end);
        }

        public void update(int node, int start, int end, int index, long diff){
            if (index < start || end < index){
                return;
            }

            this.tree[node] += diff;

            if(start != end){
                update(node * 2, start, (start + end) / 2, index, diff);
                update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
            }
        }

        public long sum(int node, int start, int end, int left, int right){
            if(left > end || right < start){
                return 0;
            }

            if(left <= start && end <= right){
                return this.tree[node];
            }

            return sum(node * 2, start, (start + end) / 2, left, right)
                    + sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        }

        public long[] getnArray(){
            return this.nArray;
        }

        public void updatenArray(int index, long value){
            this.nArray[index] = value;
        }
    }
}
