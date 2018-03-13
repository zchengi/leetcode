package _713_Subarray_Product_Less_Than_K;

/**
 * LeetCode 713. Subarray Product Less Than K
 * <p>
 * 另一种实现：log the numbers and binary search
 * <p>
 * 时间复杂度：O(nlogn),n = len(nums)
 * 空间复杂度：O(n)
 *
 * @author cheng
 *         2018/3/13 14:59
 */
public class Solution2 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) return 0;

        double logk = Math.log(k);
        double[] prefix = new double[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + Math.log(nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < prefix.length; i++) {
            int lo = i + 1, hi = prefix.length;
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (prefix[mi] < prefix[i] + logk - 1e-9) lo = mi + 1;
                else hi = mi;
            }
            ans += lo - i - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 5, 2, 6};
        int k1 = 100;
        System.out.println(new Solution2().numSubarrayProductLessThanK(nums1, k1));
        int[] nums2 = {1, 2, 3};
        int k2 = 0;
        System.out.println(new Solution2().numSubarrayProductLessThanK(nums2, k2));
    }
}
