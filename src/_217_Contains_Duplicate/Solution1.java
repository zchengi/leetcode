package _217_Contains_Duplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 217. Contains Duplicate
 * <p>
 * 使用 查找表
 *
 * @author cheng
 *         2018/3/23 15:10
 */
public class Solution1 {
    public boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> record = new HashSet<>();
        for (int num : nums) {
            if (!record.add(num)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 1};
        System.out.println(new Solution1().containsDuplicate(nums));
    }
}
