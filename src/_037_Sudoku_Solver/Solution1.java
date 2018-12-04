package _037_Sudoku_Solver;

/**
 * LeetCode 037. Sudoku Solver
 *
 * @author cheng
 *         2018/12/4 11:37
 */
public class Solution1 {
    public void solveSudoku(char[][] board) {

        if (board == null || board.length == 0) {
            return;
        }

        solve(board);
    }

    private boolean solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    // trail
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            // put c for this cell
                            board[i][j] = c;

                            if (solve(board)) {
                                // if it's the solution return true
                                return true;
                            } else {
                                // otherwise go back
                                board[i][j] = '.';
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {

        for (int i = 0; i < 9; i++) {
            // check row
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }

            // check column
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }

            // check 3 * 3 block
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
                    && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }

        return true;
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

        new Solution1().solveSudoku(board);
    }
}
