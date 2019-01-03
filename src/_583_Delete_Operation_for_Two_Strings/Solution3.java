package _583_Delete_Operation_for_Two_Strings;

/**
 * LeetCode 583. Delete Operation for Two Strings
 * <p>
 * DP
 * <p>
 * 时间复杂度: O(n*m)
 * 空间复杂度: O(m)
 *
 * @author cheng
 *         2019/1/3 17:37
 */
public class Solution3 {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int[] newRow = new int[n + 1];

            for (int k = 1; k <= n; k++) {
                // word1[i-1] to word2[k]
                int top = dp[k];
                // word1[i] to word2[k-1]
                int left = newRow[k - 1];

                if (word1.charAt(i - 1) != word2.charAt(k - 1)) {
                    newRow[k] = Math.max(top, left);
                } else {
                    int topLeft = dp[k - 1] + 1;
                    newRow[k] = Math.max(top, left);
                    newRow[k] = Math.max(newRow[k], topLeft);
                }
            }
            dp = newRow;
        }

        return (word1.length() + word2.length()) - (2 * dp[n]);
    }

    public static void main(String[] args) {

        String word1 = "sea";
        String word2 = "eat";
        System.out.println(new Solution3().minDistance(word1, word2));
    }
}
