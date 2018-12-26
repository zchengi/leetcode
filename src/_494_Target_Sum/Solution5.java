package _494_Target_Sum;

/**
 * LeetCode 494. Target Sum
 * <p>
 * 动态规划
 *
 * @author cheng
 *         2018/12/26 14:07
 */
public class Solution5 {

    public int findTargetSumWays(int[] nums, int S) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // nums通过 +- 能否组成 S
        if ((sum + S) % 2 == 1 || sum < S) {
            return 0;
        }

        sum = (sum + S) / 2;

        int[] res = new int[sum + 1];
        res[0] = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = sum; j >= nums[i - 1]; j--) {
                res[j] += res[j - nums[i - 1]];
            }
        }

        return res[sum];
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(new Solution5().findTargetSumWays(nums, S));
    }
}
