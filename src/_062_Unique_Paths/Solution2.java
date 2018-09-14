package _062_Unique_Paths;

/**
 * LeetCOde 062. Unique Paths
 *
 * @author cheng
 *         2018/09/14 17:38
 */
public class Solution2 {
    public int uniquePaths(int m, int n) {

        int[][] paths = new int[m][n];

        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            paths[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }

        return paths[m - 1][n - 1];
    }

    public static void main(String[] args) {

        int m = 7, n = 3;
        System.out.println(new Solution2().uniquePaths(m, n));
    }
}
