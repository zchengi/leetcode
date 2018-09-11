package _053_Maximum_Subarray;

/**
 * LeetCode 053. Maximum Subarray
 *
 * @author cheng
 *         2018/9/10 22:16
 */
public class Solution1 {
    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution1().maxSubArray(nums));
    }
}
