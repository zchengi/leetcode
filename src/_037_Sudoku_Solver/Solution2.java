package _037_Sudoku_Solver;

/**
 * LeetCode 037. Sudoku Solver
 * <p>
 * 参考 LeetCode 051.
 *
 * @author cheng
 *         2018/12/4 11:49
 */
public class Solution2 {

    private boolean[][] row = new boolean[9][10];
    private boolean[][] col = new boolean[9][10];
    private boolean[][] box = new boolean[9][10];

    public void solveSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';

                    row[i][num] = true;
                    col[j][num] = true;
                    box[j / 3 * 3 + i / 3][num] = true;
                }
            }
        }

        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int x, int y) {

        if (y == 9) {
            return true;
        }


        int nx = (x + 1) % 9;
        int ny = (nx == 0 ? y + 1 : y);
        if (board[x][y] != '.') {
            return dfs(board, nx, ny);
        }

        for (int i = 1; i <= 9; i++) {
            if (!row[x][i] && !col[y][i] && !box[y / 3 * 3 + x / 3][i]) {

                board[x][y] = (char) (i + '0');
                row[x][i] = true;
                col[y][i] = true;
                box[y / 3 * 3 + x / 3][i] = true;

                if (dfs(board, nx, ny)) {
                    return true;
                }

                board[x][y] = '.';
                row[x][i] = false;
                col[y][i] = false;
                box[y / 3 * 3 + x / 3][i] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        new Solution2().solveSudoku(board);
    }
}
