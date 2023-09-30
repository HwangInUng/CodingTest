package test.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇로봇 {
    // 동서남북
    static int[] X = {1, -1, 0, 0};
    static int[] Y = {0, 0, -1, 1};

    public static int solution(String[] board) {
        int answer = Integer.MAX_VALUE;

        // R의 위치를 찾아야함.
        int[] start = findStartPoint('R', board);

        // 배열에서 방문한 위치(x, y)를 기억
        // start는 R의 위치
        boolean[][] visited = new boolean[board.length][board[0].length()];
        visited[start[0]][start[1]] = true;

        // R을 큐에 저장
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start[0], start[1], 0));

        // R의 위치가 배열의 첫번째 또는 마지막번째 요소이면 상/하 이동 불가
        while (!q.isEmpty()) {
            // q에서 현재 노드를 호출
            Node curNode = q.poll();

            if (answer <= curNode.count) {
                continue;
            }

            // G에 도착 시 현재 노드의 카운트와 answer을 비교
            if (board[curNode.x].charAt(curNode.y) == 'G') {
                answer = Math.min(answer, curNode.count);
            }

            // 동서남북 방향을 순회
            for (int i = 0; i < 4; i++) {
                int x = curNode.x + X[i];
                int y = curNode.y + Y[i];

                if (x < 0
                        || y < 0
                        || x >= board.length
                        || y >= board[0].length()
                        || board[x].charAt(y) == 'D') {
                    continue;
                }

                while (x >= 0
                        && y >= 0
                        && x < board.length
                        && y < board[0].length()
                        && board[x].charAt(y) != 'D') {
                    x += X[i];
                    y += Y[i];
                }

                x -= X[i];
                y -= Y[i];

                // 방문한 노드는 패스
                if(visited[x][y]){
                    continue;
                }

                // 방문하지 않았다면 방문 처리
                visited[x][y] = true;

                // 현재 위치를 큐에 저장
                q.offer(new Node(x, y, curNode.count + 1));
            }

        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static int[] findStartPoint(char target, String[] board) {
        for (int i = 0; i < board.length; i++) {
            String s = board[i];
            for (int j = 0; j < board[i].length(); j++) {
                if (s.charAt(j) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        String[] board = {
                "...D..R",
                ".D.G...",
                "....D.D",
                "D....D.",
                "..D...."
        };
        System.out.println(solution(board));
    }
}
