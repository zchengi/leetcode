package _051_N_Queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 051. N-Queens
 * <p>
 * 另一种更快的实现方法
 *
 * @author cheng
 *         2018/4/15 19:55
 */
public class Solution2 {
    public List<List<String>> solveNQueens(int n) {

        // 优化1：使用char二维数组替代boolean二维数组，避免了字符串的拼接
        char[][] chessboard = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(chessboard[i], '.');
        }

        List<List<String>> result = new ArrayList<>();
        // 这里可以不用返回值，定义一个 result 即可
        findQueens(chessboard, result, 0);
        return result;
    }

    private void findQueens(char[][] chessboard, List<List<String>> result, int row) {

        if (row == chessboard.length) {
            List<String> temp = new ArrayList<>();
            for (char[] aBoard : chessboard) {
                temp.add(new String(aBoard));
            }

            result.add(temp);
            return;
        }

        for (int j = 0; j < chessboard[0].length; j++) {
            if (valid(chessboard, row, j)) {
                chessboard[row][j] = 'Q';
                findQueens(chessboard, result, row + 1);
                // 优化2：递归后只用把这里变为 . 而不用循环整行
                chessboard[row][j] = '.';
            }
        }

    }

    private boolean valid(char[][] chessboard, int x, int y) {

        // 优化3：使用三个for循环，效率比一个for或者while循环还要好，不知原因···

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

        int n = 4;
        List<List<String>> lists = new Solution2().solveNQueens(n);

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
