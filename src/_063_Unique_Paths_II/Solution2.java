package _063_Unique_Paths_II;

/**
 * LeetCode 063. Unique Paths II
 *
 * @author cheng
 *         2018/12/13 20:57
 */
public class Solution2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        obstacleGrid[0][0] = 1;

        // 第一列
        for (int column = 1; column < obstacleGrid[0].length; column++) {
            if (obstacleGrid[0][column] == 0 && obstacleGrid[0][column - 1] == 1) {
                obstacleGrid[0][column] = 1;
            } else {
                obstacleGrid[0][column] = 0;
            }
        }

        // 第一行
        for (int row = 1; row < obstacleGrid.length; row++) {
            if (obstacleGrid[row][0] == 0 && obstacleGrid[row - 1][0] == 1) {
                obstacleGrid[row][0] = 1;
            } else {
                obstacleGrid[row][0] = 0;
            }
        }

        // 从 [1, 1] 遍历
        for (int row = 1; row < obstacleGrid.length; row++) {
            for (int column = 1; column < obstacleGrid[0].length; column++) {
                if (obstacleGrid[row][column] == 0) {
                    obstacleGrid[row][column] = obstacleGrid[row - 1][column] + obstacleGrid[row][column - 1];
                } else {
                    obstacleGrid[row][column] = 0;
                }
            }
        }

        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {

        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        System.out.println(new Solution2().uniquePathsWithObstacles(obstacleGrid));
    }
}
