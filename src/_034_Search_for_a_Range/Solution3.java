package _034_Search_for_a_Range;

import java.util.Arrays;

/**
 * LeetCode 34. Search for a Range
 * <p>
 * 二分法
 * <p>
 * https://leetcode.com/problems/search-for-a-range/description/
 *
 * @author cheng
 *         2018/3/5 19:55
 */
public class Solution3 {
    public int[] searchRange(int[] nums, int target) {

        int[] targetRange = new int[2];
        targetRange[0] = firstTarget(nums, target);
        targetRange[1] = lastTarget(nums, target);

        return targetRange;
    }

    private int firstTarget(int[] nums, int target) {

        int first = -1;
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (target <= nums[mid]) hi = mid - 1;
            else if (target > nums[mid]) lo = mid + 1;
            if (target == nums[mid]) first = mid;
        }

        return first;
    }

    private int lastTarget(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int last = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (target < nums[mid]) hi = mid - 1;
            else if (target >= nums[mid]) lo = mid + 1;

            if (target == nums[mid]) last = mid;
        }

        return last;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(new Solution3().searchRange(arr, 8)));
    }
}
