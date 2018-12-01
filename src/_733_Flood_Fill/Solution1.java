package _733_Flood_Fill;

import java.util.Arrays;

/**
 * LeetCode 733. Flood Fill
 *
 * @author cheng
 *         2018/12/1 17:30
 */
public class Solution1 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image == null || image.length == 0) {
            return image;
        }

        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void dfs(int[][] image, int x, int y, int oldColor, int newColor) {

        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length
                || image[x][y] != oldColor || image[x][y] == newColor) {
            return;
        }

        image[x][y] = newColor;

        dfs(image, x + 1, y, oldColor, newColor);
        dfs(image, x - 1, y, oldColor, newColor);
        dfs(image, x, y + 1, oldColor, newColor);
        dfs(image, x, y - 1, oldColor, newColor);
    }

    public static void main(String[] args) {

        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;

        System.out.println(Arrays.deepToString(new Solution1().floodFill(image, sr, sc, newColor)));
    }
}
