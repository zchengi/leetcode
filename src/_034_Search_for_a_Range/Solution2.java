package _034_Search_for_a_Range;

import java.util.Arrays;

/**
 * LeetCode 34. Search for a Range
 * <p>
 * https://leetcode.com/problems/search-for-a-range/description/
 *
 * @author cheng
 *         2018/3/5 19:47
 */
public class Solution2 {
    public int[] searchRange(int[] nums, int target) {

        int[] position = {-1, -1};

        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                position[0] = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (target == nums[i]) {
                position[1] = i;
                break;
            }
        }

        return position;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(new Solution2().searchRange(arr, 8)));
    }
}
