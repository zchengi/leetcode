package _377_Combination_Sum_IV._474_Ones_and_Zeroe;

/**
 * LeetCode 474. Ones and Zeroes
 *
 * @author cheng
 *         2018/12/24 18:31
 */
public class Solution3 {
    /**
     * dp[m][n] 表示能组成 strs 的最大值
     * <p>
     * 对于每一个单词只有两种情况：
     * 1.不选择当前单词的
     * 2.选择当前单词
     * 则只需要判断这两种情况下谁的 dp[i][j] 更大，就选择那种情况
     */
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int zeros = getZeroCount(str);
            int ones = str.length() - zeros;

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }

        return dp[m][n];
    }

    private int getZeroCount(String str) {

        int count = 0;
        for (char c : str.toCharArray()) {
            if ('0' == c) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(new Solution3().findMaxForm(strs, m, n));

        strs = new String[]{"10", "0", "1"};
        m = 1;
        n = 1;
        System.out.println(new Solution3().findMaxForm(strs, m, n));
    }
}
