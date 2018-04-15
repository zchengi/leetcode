package _052_N_Queens_II;

import java.util.Arrays;

/**
 * LeetCode 052. N-Queens II
 *
 * @author cheng
 *         2018/4/15 21:14
 */
public class Solution1 {

    private int count = 0;

    public int totalNQueens(int n) {

        char[][] chessboard = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(chessboard[i], '.');
        }

        findQueens(chessboard, 0);
        return count;
    }

    private void findQueens(char[][] chessboard, int row) {

        if (row == chessboard.length) {
            count++;
        }

        for (int j = 0; j < chessboard[0].length; j++) {
            if (valid(chessboard, row, j)) {
                chessboard[row][j] = 'Q';
                findQueens(chessboard, row + 1);
                chessboard[row][j] = '.';
            }
        }
    }

    private boolean valid(char[][] chessboard, int x, int y) {

        for (char[] chars : chessboard) {
            if (chars[y] == 'Q') return false;
        }

        for (int k = 1; x - k >= 0 && y - k >= 0; k++) {
            if (chessboard[x - k][y - k] == 'Q') return false;
        }

        for (int k = 1; x - k >= 0 && y + k < chessboard[0].length; k++) {
            if (chessboard[x - k][y + k] == 'Q') return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 14;
        int count = new Solution1().totalNQueens(n);
        System.out.println(n + "皇后问题共有" + count + "种解法。");
    }
}
