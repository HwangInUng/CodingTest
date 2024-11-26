package test.baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B_1966 {
    // 문서 클래스
    public static class Document {
        private int no;
        private int priority;

        Document(int no, int priority) {
            this.no = no;
            this.priority = priority;
        }

        public int getPriority() {
            return priority;
        }

        public int getNo() {
            return no;
        }


        @Override
        public String toString() {
            return "no: " + no + ", priority: " + priority;
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
            int target = Integer.parseInt(st.nextToken()); // 순서
            LinkedList<Document> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < count; j++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new Document(j, priority));
            }

            int printOrder = 0;

            while (true) {
                Document current = queue.poll();
                boolean isOver = false;

                for(Document doc : queue) {
                    if(current.getPriority() < doc.getPriority()) {
                        isOver = true;
                        break;
                    }
                }

                if(isOver) {
                    queue.add(current);
                } else {
                    printOrder++;
                    if(current.getNo() == target) {
                        sb.append(printOrder).append("\n");
                        break;
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
