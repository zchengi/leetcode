package _300_Longest_Increasing_SubSequence;

import java.util.Arrays;

/**
 * LeetCode 300. Longest Increasing SubSequence
 * <p>
 * 改变动态规划的状态定义，带来解决问题方法的重大不同, 甚至是时间复杂度数量级上的巨大优化
 * <p>
 * 时间复杂度: O(nlogn)
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2018/12/28 19:00
 */
public class Solution4 {

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        // dp[i] 表示最长长度为 i 的递增子序列，最后一个数字的最小值
        int dp[] = new int[nums.length + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[1] = nums[0];

        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[len]) {
                len++;
                dp[len] = nums[i];
            } else {
                // dp 数组是一个单调递增的数组，所有可以使用二分查找法
                int index = lowerBound(dp, len, nums[i]);
                if (dp[index] != nums[i]) {
                    dp[index] = Math.min(dp[index], nums[i]);
                }
            }
        }

        return len;
    }

    /**
     * lowerBound 求出 arr[l...r] 范围里，大于等于 target 的第一个元素所以在的索引
     */
    private int lowerBound(int[] arr, int r, int target) {

        int left = 0;
        int right = r + 1;

        while (left != right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                // arr[mid] < target
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Solution4().lengthOfLIS(nums));
    }
}
