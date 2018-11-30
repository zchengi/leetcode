package _695_Max_Area_of_Island;

/**
 * LeetCode 695. Max Area of Island
 *
 * @author cheng
 *         2018/11/30 11:35
 */
public class Solution1 {

    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int max_area = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max_area = Math.max(max_area, areaOfIsland(grid, i, j));
                }
            }
        }

        return max_area;
    }

    private int areaOfIsland(int[][] grid, int x, int y) {

        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
            grid[x][y] = 0;

            return 1 + areaOfIsland(grid, x + 1, y)
                    + areaOfIsland(grid, x - 1, y)
                    + areaOfIsland(grid, x, y - 1)
                    + areaOfIsland(grid, x, y + 1);
        }

        return 0;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(new Solution1().maxAreaOfIsland(grid));

        int[][] grid2 = {{0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(new Solution1().maxAreaOfIsland(grid2));
    }
}
