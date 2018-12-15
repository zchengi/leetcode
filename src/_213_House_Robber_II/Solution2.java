package _213_House_Robber_II;

/**
 * LeetCode 213. House Robber II
 *
 * @author cheng
 *         2018/12/15 14:20
 */
public class Solution2 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // 跳过最后一个/第一个房子
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    private int robHelper(int[] nums, int lo, int hi) {

        int include = 0;
        int exclude = 0;

        for (int k = lo; k <= hi; k++) {
            int tmp = include;
            include = nums[k] + exclude;
            exclude = Math.max(tmp, exclude);
        }

        return Math.max(include, exclude);
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 2};
        System.out.println(new Solution2().rob(nums));
        int[] nums2 = {1, 2, 3, 1};
        System.out.println(new Solution2().rob(nums2));
    }
}
