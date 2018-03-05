package _027_Remove_Element;

/**
 * LeetCode 027. Remove Element
 * <p>
 * https://leetcode.com/problems/remove-element/description/
 *
 * @author cheng
 *         2018/3/5 20:19
 */
public class Solution {
    public int removeElement(int[] nums, int val) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) nums[j++] = nums[i];
        }

        return j;
    }

    public int removeElement2(int[] nums, int val) {

        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) nums[++j] = nums[i];
        }

        return ++j;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int[] nums2 = {3, 2, 2, 3};
        int val = 3;

        System.out.println(new Solution().removeElement(nums, val));
        System.out.println(new Solution().removeElement2(nums2, val));
    }
}
