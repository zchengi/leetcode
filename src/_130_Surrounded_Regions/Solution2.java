package _130_Surrounded_Regions;

/**
 * LeetCode 130. Surrounded Regions
 *
 * @author cheng
 *         2018/11/28 19:36
 */
public class Solution2 {
    public void solve(char[][] board) {

        if (board == null || board.length == 0) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            helper(board, i, 0);
            helper(board, i, board[0].length - 1);
        }

        for (int i = 0; i < board[0].length; i++) {
            helper(board, 0, i);
            helper(board, board.length - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void helper(char[][] board, int i, int j) {

        if (board[i][j] != 'O') {
            return;
        }

        board[i][j] = '#';

        if (i > 0) {
            helper(board, i - 1, j);
        }
        if (i + 1 < board.length) {
            helper(board, i + 1, j);
        }
        if (j > 0) {
            helper(board, i, j - 1);
        }
        if (j + 1 < board[0].length) {
            helper(board, i, j + 1);
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X' },
                {'X', 'O', 'O', 'X' },
                {'X', 'X', 'O', 'X' },
                {'X', 'O', 'X', 'X' }};

        new Solution2().solve(board);
    }
}
