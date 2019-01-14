package _561_Array_Partition_I;

import java.util.Arrays;

/**
 * LeetCode 561. Array Partition I
 *
 * @author cheng
 *         2019/1/13 10:21
 */
public class Solution1 {
    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 4, 3, 2};
        System.out.println(new Solution1().arrayPairSum(nums));
    }
}