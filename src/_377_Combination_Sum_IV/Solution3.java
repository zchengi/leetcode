package _377_Combination_Sum_IV;

/**
 * LeetCode 377. Combination Sum IV
 *
 * @author cheng
 *         2018/12/23 20:12
 */
public class Solution3 {
    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];
        // 如果 target 为0，则凑成情况只有一种
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(new Solution3().combinationSum4(nums, target));
    }
}
