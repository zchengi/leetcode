package _713_Subarray_Product_Less_Than_K;

/**
 * LeetCode 713. Subarray Product Less Than K
 * <p>
 * 滑动窗口
 * 优化循环，不报错
 * <p>
 * 时间复杂度：O(len(nums))
 * 空间复杂度：O(N)
 *
 * @author cheng
 *         2018/3/13 15:20
 */
public class Solution3 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) return 0;

        // nums[left...right]
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left++];
            }

            ans += right - left + 1;
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] nums1 = {10, 5, 2, 6};
        int k1 = 100;
        System.out.println(new Solution3().numSubarrayProductLessThanK(nums1, k1));
        int[] nums2 = {1, 2, 3};
        int k2 = 0;
        System.out.println(new Solution3().numSubarrayProductLessThanK(nums2, k2));
    }
}
