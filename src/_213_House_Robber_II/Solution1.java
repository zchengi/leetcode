package _213_House_Robber_II;

/**
 * LeetCode 213. House Robber II
 *
 * @author cheng
 *         2018/12/15 13:55
 */
public class Solution1 {
    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] nums2 = nums.clone();

        int max1;
        nums[1] = Math.max(nums[0], nums[1]);

        // 跳过最后一个房子的 nums 数组并找到 max sum
        for (int i = 2; i < n - 1; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i] + nums[i - 2]);
        }
        max1 = nums[n - 2];


        int max2;
        nums2[2] = Math.max(nums2[1], nums2[2]);
        // 跳过第一个房子的 nums 数组并找到 max sum
        for (int i = 3; i < n; i++) {
            nums2[i] = Math.max(nums2[i - 1], nums2[i] + nums2[i - 2]);
        }
        max2 = nums2[n - 1];

        return Math.max(max1, max2);
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 2};
        System.out.println(new Solution1().rob(nums));
        int[] nums2 = {1, 2, 3, 1};
        System.out.println(new Solution1().rob(nums2));
    }
}
