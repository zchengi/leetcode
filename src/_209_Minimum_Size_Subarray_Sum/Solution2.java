package _209_Minimum_Size_Subarray_Sum;

/**
 * LeetCode 209. Minimum Size SubArray Sum
 * <p>
 * 优化暴力解法
 * <p>
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 *
 * @author cheng
 *         2018/3/9 20:55
 */
public class Solution2 {
    public int minSubArrayLen(int s, int[] nums) {

        if (s <= 0 || nums == null) {
            throw new IllegalArgumentException("Illegal  Arguments.");
        }

        // sums[i] 存放 nums[0...i-1] 的和
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        int res = nums.length + 1;
        for (int l = 0; l < nums.length; l++) {
            for (int r = l; r < nums.length; r++) {
                // 使用sums[r+1] - sums[l] 快速获得 nums[l...r] 的和
                if (sums[r + 1] - sums[l] >= s) {
                    res = Math.min(res, r - l + 1);
                }
            }
        }

        if (res == nums.length + 1) return 0;
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(new Solution2().minSubArrayLen(s, nums));
    }
}
