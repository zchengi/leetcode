package _064_Minimum_Path_Sum;

/**
 * LeetCode 064. Minimum Path Sum
 * <p>
 * LeetCode 超时
 *
 * @author cheng
 *         2018/12/8 10:46
 */
public class Solution1 {

    private int res = Integer.MAX_VALUE;

    public int minPathSum(int[][] grid) {

        int x = 0, y = 0, sum = 0;

        dfs(x, y, sum, grid);
        return res;
    }

    private void dfs(int x, int y, int sum, int[][] grid) {

        if (x >= grid.length || y >= grid[0].length) {
            return;
        }

        sum += grid[x][y];

        if (x == grid.length - 1 && y == grid[0].length - 1) {
            res = res < sum ? res : sum;
            return;
        }

        dfs(x + 1, y, sum, grid);
        dfs(x, y + 1, sum, grid);
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new Solution1().minPathSum(grid));
    }
}