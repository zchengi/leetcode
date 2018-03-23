package _217_Contains_Duplicate;

import java.util.Arrays;

/**
 * LeetCode 217. Contains Duplicate
 * <p>
 * 使用 排序后的数组
 *
 * @author cheng
 *         2018/3/23 15:15
 */
public class Solution2 {
    public boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length < 2) {
            return false;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 1};
        System.out.println(new Solution2().containsDuplicate(nums));
    }
}
