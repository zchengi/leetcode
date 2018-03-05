package _026_Remove_Duplicated_from_Sorted_Array;

/**
 * LeetCode 026. Remove Duplicated from Sorted Array
 *
 * @author cheng
 *         2018/3/5 20:32
 */
public class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;

        int j = 0;
        int size = nums.length;
        for (int i = 1; i < size; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }

        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        System.out.println(new Solution().removeDuplicates(nums));
    }
}
