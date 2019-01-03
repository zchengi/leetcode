package _583_Delete_Operation_for_Two_Strings;

/**
 * LeetCode 583. Delete Operation for Two Strings
 * <p>
 * LCS 问题，动态规划，躲避边界条件
 * <p>
 * 时间复杂度: O(len(s1)*len(s2))
 * 空间复杂度: O(len(s1)*len(s2))
 *
 * @author cheng
 *         2019/1/3 17:37
 */
public class Solution1 {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        /*
         * memo 是 (m+1) * (n+1) 的动态规划表格
         * memo[i][j] 表示 s1 的前i个字符和s2前j个字符的最长公共子序列的长度
         * 其中 memo[0][j] 表示 s1 取空字符串时，和 s2 的前j个字符作比较
         * memo[i][0] 表示 s2 取空字符串时，和 s1 的前i个字符作比较
         * 所以，memo[0][j] 和 memo[i][0] 均取 0 时，
         * 不需要对 memo 进行单独的边界条件处理
         */
        int[][] memo = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }

        // 通过 memo 反向求解 s1 和 s2 的最长公共子序列
        StringBuilder sb = new StringBuilder();
        while (m > 0 && n > 0) {
            if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
                sb.insert(0, word1.charAt(m - 1));
                m--;
                n--;
            } else if (memo[m - 1][n] > memo[m][n - 1]) {
                m--;
            } else {
                n--;
            }
        }

        return word1.length() - sb.length() + word2.length() - sb.length();
    }

    public static void main(String[] args) {

        String word1 = "sea";
        String word2 = "eat";
        System.out.println(new Solution1().minDistance(word1, word2));
    }
}
