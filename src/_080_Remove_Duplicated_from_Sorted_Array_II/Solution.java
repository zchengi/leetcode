package _080_Remove_Duplicated_from_Sorted_Array_II;

/**
 * LeetCode 080. Remove Duplicated from Sorted Array II
 * <p>
 * 设置哨兵 k 记录未重复值
 * - 如果当前元素与最后一个要返回的元素不同时， k = 当前元素；
 * - 如果当前元素与 k 第一次相等时， num[++j] = k;  再给 k 赋一个不会使用的值；
 *
 * @author cheng
 *         2018/3/5 20:46
 */
public class Solution {
    public int removeDuplicates(int[] nums) {

        if(nums == null || nums.length <= 2) {
            return nums.length;
        }

        int size = nums.length;

        int j = 0;
        int k = nums[0];
        for (int i = 1; i < size; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
                k = nums[i];
            } else if (k == nums[i]) {
                nums[++j] = k--;
            }
        }

        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};

        System.out.println(new Solution().removeDuplicates(nums));
    }
}
