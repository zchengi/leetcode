package _052_N_Queens_II;

/**
 * LeetCode 052. N-Queens II
 * <p>
 * 更快的方法
 *
 * @author cheng
 *         2018/4/15 21:24
 */
public class Solution2 {

    private int count = 0;

    public int totalNQueens(int n) {

        boolean[] cols = new boolean[n]; // columns |
        boolean[] d1 = new boolean[2 * n]; // diagonals \
        boolean[] d2 = new boolean[2 * n]; // diagonals /

        backtracking(0, cols, d1, d2);
        return count;
    }

    private void backtracking(int row, boolean[] cols, boolean[] d1, boolean[] d2) {

        int n = cols.length;
        if (row == n) {
            count++;
        }

        for (int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;

            if (cols[col] || d1[id1] || d2[id2]) {
                continue;
            }

            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;

            backtracking(row + 1, cols, d1, d2);

            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }
    }

    public static void main(String[] args) {
        int n = 14;
        int count = new Solution2().totalNQueens(n);
        System.out.println(n + "皇后问题共有" + count + "种解法。");
    }
}
