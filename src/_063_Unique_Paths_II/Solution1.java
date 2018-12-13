package _063_Unique_Paths_II;

/**
 * LeetCode 063. Unique Paths II
 *
 * @author cheng
 *         2018/12/13 20:29
 */
public class Solution1 {

    /**
     * 机器人只能向下或向右移动。因此，第一行中的任何单元格只能从左边的单元格到达。
     * 并且，第一列中的任何单元格只能从其上方的单元格到达。
     * 对于网格中的任何其他单元格，我们可以从它的左边的单元格或它上面的单元格到达它。
     * 如果任何单元格有障碍，我们不会让该单元格对任何路径有贡献。
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        obstacleGrid[0][0] = 1;

        // 第一列
        for (int i = 1; i < row; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // 第一行
        for (int i = 1; i < col; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        // 从第 [1, 1] 的位置开始遍历
        // 只能向下或向右移动
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    // 当前位置的路径 = 左边的最多路径 + 上边的最多路径
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    // 当前位置为路障
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[row - 1][col - 1];
    }

    public static void main(String[] args) {

        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        System.out.println(new Solution1().uniquePathsWithObstacles(obstacleGrid));
    }
}
