package _51_N_Queens;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 051. N-Queens
 *
 * @author cheng
 *         2018/4/15 19:55
 */
public class Solution1 {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        boolean[][] chessboard = new boolean[n][n];

        return findQueens(chessboard, 0, result);
    }

    private List<List<String>> findQueens(boolean[][] chessboard, int y, List<List<String>> result) {

        if (y == chessboard.length) {
            result.add(booleanToString(result, chessboard));
            return result;
        }

        boolean[][] chessboardTemp = chessboard.clone();

        for (int i = 0; i < chessboard.length; i++) {
            for (int x = 0; x < chessboard.length; x++) {
                chessboard[x][y] = false;
            }

            chessboard[i][y] = true;
            if (check(chessboardTemp, i, y)) {
                findQueens(chessboardTemp, y + 1, result);
            }
        }

        return result;
    }

    private boolean check(boolean[][] chessboard, int x, int y) {

        int step = 1;
        while (y - step >= 0) {
            if (chessboard[x][y - step]) {
                return false;
            }

            if (x - step >= 0 && chessboard[x - step][y - step]) {
                return false;
            }

            if (x + step < chessboard.length && chessboard[x + step][y - step]) {
                return false;
            }

            step++;
        }

        return true;
    }

    private List<String> booleanToString(List<List<String>> result, boolean[][] chessboard) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < chessboard.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < chessboard.length; j++) {
                builder.append(chessboard[i][j] ? "Q" : ".");
            }
            res.add(builder.toString());
        }

        return res;
    }

    public static void main(String[] args) {

        int n = 4;
        List<List<String>> lists = new Solution1().solveNQueens(n);

        int count = 1;
        for (List<String> list : lists) {
            System.out.println(n + "皇后问题，第 " + count++ + " 种解法：");
            for (String str : list) {
                System.out.println(str);
            }
            System.out.println();
        }
        System.out.println(n + "皇后问题共有" + lists.size() + "种解法。");
    }
}
