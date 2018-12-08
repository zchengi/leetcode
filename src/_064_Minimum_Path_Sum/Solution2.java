package _064_Minimum_Path_Sum;

/**
 * LeetCode 064. Minimum Path Sum
 * <p>
 * dp: 自顶向下
 *
 * @author cheng
 *         2018/12/8 11:15
 */
public class Solution2 {

    public int minPathSum(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int[] dp = new int[cols + 1];

        for (int i = 0; i < rows; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < cols; j++) {
                dp[j] = (i == 0 ? dp[j - 1] : Math.min(dp[j - 1], dp[j])) + grid[i][j];
            }
        }

        return dp[cols - 1];
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new Solution2().minPathSum(grid));
    }
}