package _713_Subarray_Product_Less_Than_K;

/**
 * LeetCode 713. Subarray Product Less Than K
 * <p>
 * 滑动窗口
 * 数量过大出现问题计算有误
 * <p>
 * 时间复杂度：O(len(nums))
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/3/13 14:35
 */
public class Solution1 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) return 0;

        int res = 0;
        // 滑动窗口 nums[l...r)
        int l = 0, r = 0;
        // 记录nums[l...r)的乘积
        int prod = 1;
        while (l < nums.length) {
            if (r < nums.length && prod * nums[r] < k) {
                prod *= nums[r++];
            } else {
                // r >= nums.length || prod * nums[r] >= k
                res += r - l;
                prod /= nums[l++];
                if (l > r) r = l;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 5, 2, 6};
        int k1 = 100;
        System.out.println(new Solution1().numSubarrayProductLessThanK(nums1, k1));
        int[] nums2 = {1, 2, 3};
        int k2 = 0;
        System.out.println(new Solution1().numSubarrayProductLessThanK(nums2, k2));
    }
}
