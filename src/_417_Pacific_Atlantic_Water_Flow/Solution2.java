package _417_Pacific_Atlantic_Water_Flow;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 417. Pacific Atlantic Water Flow
 *
 * @author cheng
 *         2018/11/29 14:56
 */
public class Solution2 {

    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return res;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        boolean PV[][] = new boolean[n][m];
        boolean AV[][] = new boolean[n][m];

        // 这里从所有临海的地方到这回去判断某个节点是否能流到对应的地方
        for (int i = 0; i < n; i++) {
            flow(PV, matrix, i, 0, n, m);
            flow(AV, matrix, i, m - 1, n, m);
        }
        for (int i = 0; i < m; i++) {
            flow(PV, matrix, 0, i, n, m);
            flow(AV, matrix, n - 1, i, n, m);
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (PV[x][y] && AV[x][y]) {
                    int[] point = {x, y};
                    res.add(point);
                }
            }
        }
        return res;
    }

    private void flow(boolean visited[][], int matrix[][], int x, int y, int n, int m) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {

                // 一个节点是只能留到不高于自己高度的节点，但是我们这里是反过来找能从 nxny 留到 xy 的节点，所以这里注意下
                if (!visited[nx][ny] && matrix[nx][ny] >= matrix[x][y]) {
                    flow(visited, matrix, nx, ny, n, m);
                }
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
        System.out.println(new Solution2().pacificAtlantic(matrix));
    }
}
