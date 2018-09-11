package _053_Maximum_Subarray;

/**
 * LeetCode 053. Maximum Subarray
 *
 * @author cheng
 *         2018/9/11 15:49
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] result = new int[nums.length];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result[i] = Math.max(nums[i], nums[i] + result[i - 1]);
            max = Math.max(max, result[i]);
        }

        return max;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution2().maxSubArray(nums));
    }
}
