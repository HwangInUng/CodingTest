package test.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2580 {
    static int[][] sudoku = new int[9][9];
    static int answer = 45;

    /*
     * 1 ~ 9까지 어떤 특정 숫자 n을 가지는 9x9 크기의 집합 z가 있음
     * z의 각 행과 열에는 1~9까지의 숫자 n이 중복되지 않고 입력되어있음
     * n의 행, 열, 3 x 3 정사각형의 1~9의 숫자의 여부를 확인
     *
     * z의 0,0 지점부터 열로 출발
     * 0을 만나는 위치에서 행, 열, 3x3 정사각형에 해당 숫자가 있는지 체크
     * 있다면 pass, 없면는 현재 숫자를 대입하고 백트래킹 수행
     *
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for (int i = 0; i < sudoku.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < sudoku.length; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
    }

    public static void dfs(int row, int col) {
        // 열을 모두 순회한 경우 row를 증가하여 재시도
        if (col == sudoku.length) {
            dfs(row + 1, 0);
            return;
        }

        // row까지 모두 완료한 경우 출력 후 시스템 종료
        if (row == sudoku.length) {
            StringBuilder sb = new StringBuilder();

            for (int[] arr : sudoku) {
                for (int i : arr) {
                    sb.append(i).append(" ");
                }
                sb.append("\n");
            }

            System.out.println(sb);
            System.exit(0);
        }

        if (sudoku[row][col] == 0) {
            for (int num = 1; num <= 9; num++) {
                if (isValid(row, col, num)) {
                    sudoku[row][col] = num;
                    dfs(row, col + 1);
                    // 만약 위 시도에서 해답을 찾지 못하면 0으로 초기화하여
                    // 다른 숫자 시도를 반복
                    sudoku[row][col] = 0;
                }
            }
        } else {
            dfs(row, col + 1);
        }

    }

    public static boolean isValid(int row, int col, int num) {
        for (int i = 0; i < sudoku.length; i++) {
            // 행의 결과 확인
            if (sudoku[row][i] == num) {
                return false;
            }
        }

        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[i][col] == num) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudoku[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
