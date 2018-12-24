package _377_Combination_Sum_IV._474_Ones_and_Zeroe;

/**
 * LeetCode 474. Ones and Zeroes
 *
 * @author cheng
 *         2018/12/24 18:31
 */
public class Solution2 {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        int[] nums;
        for (String str : strs) {
            nums = calculate(str);
            for (int i = m; i >= nums[0]; i--) {
                for (int j = n; j >= nums[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - nums[0]][j - nums[1]] + 1);
                }
            }

        }

        return dp[m][n];
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
        System.out.println(new Solution2().findMaxForm(strs, m, n));

        strs = new String[]{"10", "0", "1"};
        m = 1;
        n = 1;
        System.out.println(new Solution2().findMaxForm(strs, m, n));
    }
}
