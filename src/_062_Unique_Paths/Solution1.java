package _062_Unique_Paths;

/**
 * LeetCOde 062. Unique Paths
 *
 * @author cheng
 *         2018/09/14 17:26
 */
public class Solution1 {
    public int uniquePaths(int m, int n) {

        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[] res = new int[n];
        res[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] += res[j - 1];
            }
        }

        return res[n - 1];
    }

    public static void main(String[] args) {

        int m = 7, n = 3;
        System.out.println(new Solution1().uniquePaths(m, n));
    }
}
