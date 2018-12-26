package _494_Target_Sum;

/**
 * LeetCode 494. Target Sum
 * <p>
 * 动态规划
 *
 * @author cheng
 *         2018/12/26 14:02
 */
public class Solution4 {

    public int findTargetSumWays(int[] nums, int S) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (S > sum || S < -sum) {
            return 0;
        }

        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;

        for (int i = 0; i < nums.length; i++) {
            int[] next = new int[2 * sum + 1];
            for (int k = 0; k < 2 * sum + 1; k++) {
                if (dp[k] != 0) {
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }

        return dp[sum + S];
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(new Solution4().findTargetSumWays(nums, S));
    }
}
