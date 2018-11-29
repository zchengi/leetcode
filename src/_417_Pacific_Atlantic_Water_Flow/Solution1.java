package _417_Pacific_Atlantic_Water_Flow;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 417. Pacific Atlantic Water Flow
 *
 * @author cheng
 *         2018/11/29 14:29
 */
public class Solution1 {

    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<int[]> pacificAtlantic(int[][] matrix) {

        List<int[]> res = new LinkedList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int n = matrix.length, m = matrix[0].length;

        // one visited map for each ocean
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();

        // vertical border
        for (int i = 0; i < n; i++) {
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, m - 1});
            pacific[i][0] = true;
            atlantic[i][m - 1] = true;
        }

        // horizontal border
        for (int i = 0; i < m; i++) {
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{n - 1, i});

            pacific[0][i] = true;
            atlantic[n - 1][i] = true;
        }

        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }

        return res;
    }

    private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {

        int n = matrix.length, m = matrix[0].length;
        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            for (int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];

                if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]) {
                    continue;
                }

                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 5},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 2, 1, 2, 4}};
        System.out.println(new Solution1().pacificAtlantic(matrix));
    }

}
