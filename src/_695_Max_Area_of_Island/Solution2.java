package _695_Max_Area_of_Island;

/**
 * LeetCode 695. Max Area of Island
 *
 * @author cheng
 *         2018/11/30 12:26
 */
public class Solution2 {

    private int max = Integer.MIN_VALUE;
    private int area = 0;

    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
                area = 0;
            }
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }

    private void dfs(int[][] grid, int x, int y) {

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return;
        }

        grid[x][y] = 0;
        area++;
        max = Math.max(area, max);

        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
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
        System.out.println(new Solution2().maxAreaOfIsland(grid));

        int[][] grid2 = {{0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(new Solution2().maxAreaOfIsland(grid2));
    }
}
