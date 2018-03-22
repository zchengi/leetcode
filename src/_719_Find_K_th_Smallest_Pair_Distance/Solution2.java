package _719_Find_K_th_Smallest_Pair_Distance;


import java.util.Arrays;

/**
 * LeetCode 719. Find K-th Smallest Pair Distance
 * <p>
 * 使用 二分查找 和 滑动窗口
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/3/22 21:37
 */
public class Solution2 {
    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);

        // 0 为 一对 的最小值， nums[nums.length - 1] - nums[0] 为 一对 的最大值
        int l = 0, r = nums[nums.length - 1] - nums[0];
        while (l < r) {
            // 这里的 mid 是 最小对的差值 与 最大对的差值 的 mid，不是索引
            int mid = l + (r - l) / 2;

            // 记录所有小于 mid 的 一对 的对数
            int count = 0;

            // 这里每次循环 right 到 nums.length 来计算 每一对 的差值的绝对值
            for (int left = 0, right = 0; right < nums.length; right++) {
                // 如果当前索引为 left 和 right 的 一对 的差值大于 mid ，则 left++
                while (nums[right] - nums[left] > mid) {
                    left++;
                }

                // 当前一个索引为 right 时， 一对 差的值小于 mid 的对数
                count += right - left;
            }

            if (count < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        int k = 1;
        System.out.println(new Solution2().smallestDistancePair(nums, k));
    }
}
