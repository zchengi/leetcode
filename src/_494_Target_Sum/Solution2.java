package _494_Target_Sum;

/**
 * LeetCode 494. Target Sum
 * <p>
 * dfs
 *
 * @author cheng
 *         2018/12/26 13:45
 */
public class Solution2 {

    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, 0, S, 0);
    }

    private int dfs(int[] nums, int sum, int target, int k) {
        if (nums.length == k) {
            return sum == target ? 1 : 0;
        }
        return dfs(nums, sum + nums[k], target, k + 1) +
                dfs(nums, sum - nums[k], target, k + 1);
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(new Solution2().findTargetSumWays(nums, S));
    }
}
