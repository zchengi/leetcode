package _719_Find_K_th_Smallest_Pair_Distance;

import java.util.Arrays;

/**
 * LeetCode 719. Find K-th Smallest Pair Distance
 * <p>
 * 时间复杂度：O(nlogn + n^2 + W)
 * 空间复杂度：O(W)，where W = max(nums) - min(nums)
 *
 * @author cheng
 *         2018/3/22 21:27
 */
public class Solution1 {
    public int smallestDistancePair(int[] nums, int k) {

        int[] dis = new int[1000000];

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                dis[nums[j] - nums[i]]++;
            }
        }

        int index = 0;
        for (int i = 0; i < 1000000; i++) {
            index += dis[i];
            if (k <= index) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 1};
        int k = 1;
        System.out.println(new Solution1().smallestDistancePair(nums, k));
    }
}
