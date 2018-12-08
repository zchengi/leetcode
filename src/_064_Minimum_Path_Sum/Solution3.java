package _064_Minimum_Path_Sum;

/**
 * LeetCode 064. Minimum Path Sum
 * <p>
 * dp
 *
 * @author cheng
 *         2018/12/8 11:15
 */
public class Solution3 {

    public int minPathSum(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        
        // 记录从 grid[0][0] 开始走到 dp[i] 行第 [n] 列的最小值
        int[] dp = new int[rows];

        dp[0] = grid[0][0];

        for (int i = 1; i < rows; i++) {
            dp[i] = dp[i - 1] + grid[i][0];
        }

        // 走到某一列
        for (int i = 1; i < cols; i++) {
            // 第一行第 [i] 列
            dp[0] += grid[0][i];

            // 走到某一行第 [i]列
            for (int j = 1; j < rows; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[j][i];
            }
        }

        return dp[rows - 1];
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new Solution3().minPathSum(grid));
    }
}