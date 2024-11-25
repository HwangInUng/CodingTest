package test.baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1966 {
    // 문서 클래스
    public static class Document implements Comparable<Document> {
        private int no;
        private int rank;

        Document(int no, int rank) {
            this.no = no;
            this.rank = rank;
        }

        public int getRank() {
            return rank;
        }

        public int getNo() {
            return no;
        }

        @Override
        public int compareTo(Document o2) {
            if(this.rank > o2.getRank()) {
                return -1;
            } else if (this.rank == o2.getRank()) {
                return 0;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "no: " + no + ", rank: " + rank;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            PriorityQueue<Document> pq = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < count; j++) {
                int rank = Integer.parseInt(st.nextToken());
                pq.add(new Document(j, rank));
            }

            int j = 0;
            while (true) {
                j++;
                if(pq.peek().getNo() == number) {
                    pq.poll();
                    sb.append(j).append("\n");
                    break;
                }

                pq.poll();
            }
        }

        System.out.println(sb);
    }
}
