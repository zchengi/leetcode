package _377_Combination_Sum_IV._474_Ones_and_Zeroe;

/**
 * LeetCode 474. Ones and Zeroes
 *
 * @author cheng
 *         2018/12/24 17:59
 */
public class Solution1 {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        for (int i = 1; i < strs.length + 1; i++) {

            int[] nums = calculate(strs[i - 1]);
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    if (i == 0) {
                        dp[i][j][k] = 0;
                    } else if (j >= nums[0] && k >= nums[1]) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - nums[0]][k - nums[1]] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }

    private int[] calculate(String str) {

        int[] res = new int[2];

        for (char c : str.toCharArray()) {
            if (c == '0') {
                res[0]++;
            } else if (c == '1') {
                res[1]++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(new Solution1().findMaxForm(strs, m, n));

        strs = new String[]{"10", "0", "1"};
        m = 1;
        n = 1;
        System.out.println(new Solution1().findMaxForm(strs, m, n));
    }
}
