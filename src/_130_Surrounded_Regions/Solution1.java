package _130_Surrounded_Regions;

/**
 * LeetCode 130. Surrounded Regions
 *
 * @author cheng
 *         2018/11/28 19:16
 */
public class Solution1 {
    public void solve(char[][] board) {

        if (board.length == 0) {
            return;
        }

        // check first row
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                setSign(0, i, board);
            }
        }

        // check last row
        for (int i = 0; i < board[0].length; i++) {
            if (board[board.length - 1][i] == 'O') {
                setSign(board.length - 1, i, board);
            }
        }

        // check first column
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                setSign(i, 0, board);
            }
        }

        // check last column
        for (int i = 0; i < board.length; i++) {
            if (board[i][board[0].length - 1] == 'O') {
                setSign(i, board[0].length - 1, board);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void setSign(int i, int j, char[][] board) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '-';

        setSign(i + 1, j, board);
        setSign(i - 1, j, board);
        setSign(i, j + 1, board);
        setSign(i, j - 1, board);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X' },
                {'X', 'O', 'O', 'X' },
                {'X', 'X', 'O', 'X' },
                {'X', 'O', 'X', 'X' }};

        new Solution1().solve(board);
    }
}
