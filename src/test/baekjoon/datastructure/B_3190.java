package test.baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_3190 {
    private static int[][] board;
    private static ArrayList<int[]> snake = new ArrayList<>();
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static HashMap<Integer, String> command = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        // 사과 위치 지정
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken()) - 1;
            int column = Integer.parseInt(st.nextToken()) - 1;

            board[row][column] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        // 방향 설정
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int second = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            command.put(second, direction);
        }

        move();
    }

    public static void move() {
        int cx = 0, cy = 0;
        int time = 0;
        int direction = 0;
        snake.add(new int[]{0, 0});

        while (true) {
            time++;

            // 현재 머리 위치 + 방향 이동
            int nx = cx + dx[direction];
            int ny = cy + dy[direction];

            // 게임 종료 체크
            if(isGameOver(nx, ny)) {
                break;
            }

            // 머리 위치 이동
            snake.add(new int[]{nx, ny});

            // 현재 머리 위치에 사과 여부 처리
            if(board[nx][ny] == 1) {
                board[nx][ny] = 0;
            } else {
                // 꼬리 지우기
                snake.remove(0);
            }

            // 현재 시간에 내려진 방향 전환
            if(command.containsKey(time)) {
                if(command.get(time).equals("D")) {
                    direction++;
                    if(direction == 4) {
                        direction = 0;
                    }
                } else {
                    direction--;
                    if(direction == -1) {
                        direction = 3;
                    }
                }
            }

            // 다음 이동을 위한 현재 위치 갱신
            cx = nx;
            cy = ny;
        }

        System.out.println(time);
    }

    public static boolean isGameOver(int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= board.length || ny >= board.length) {
            return true;
        }

        // nx, ny는 현재 머리 위치
        // 부딪히는 부분이 있는지 확인
        for (int[] s : snake) {
            if (nx == s[0] && ny == s[1]) {
                return true;
            }
        }

        return false;
    }

}
