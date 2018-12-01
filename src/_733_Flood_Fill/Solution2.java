package _733_Flood_Fill;

import java.util.Arrays;

/**
 * LeetCode 733. Flood Fill
 *
 * @author cheng
 *         2018/12/1 17:47
 */
public class Solution2 {

    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int oldColor = image[sr][sc];

        if (oldColor == newColor) {
            return image;
        }

        fill(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void fill(int[][] image, int x, int y, int oldColor, int newColor) {

        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length
                || image[x][y] != oldColor) {
            return;
        }

        image[x][y] = newColor;
        for (int[] dir : dirs) {
            fill(image, x + dir[0], y + dir[1], oldColor, newColor);
        }
    }

    public static void main(String[] args) {

        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;

        System.out.println(Arrays.deepToString(new Solution2().floodFill(image, sr, sc, newColor)));
    }
}
