package _209_Minimum_Size_Subarray_Sum;

/**
 * LeetCode 209. Minimum Size SubArray Sum
 * <p>
 * 暴力解法
 * <p>
 * 时间复杂度：O(n^3)
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/3/9 20:47
 */
public class Solution1 {
    public int minSubArrayLen(int s, int[] nums) {

        if (s <= 0 || nums == null) {
            throw new IllegalArgumentException("Illegal  Arguments.");
        }

        int res = nums.length + 1;

        for (int l = 0; l < nums.length; l++) {
            for (int r = l; r < nums.length; r++) {
                int sum = 0;
                for (int i = l; i <= r; i++) {
                    sum += nums[i];
                }
                if (sum >= s) {
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
        System.out.println(new Solution1().minSubArrayLen(s, nums));
    }
}
