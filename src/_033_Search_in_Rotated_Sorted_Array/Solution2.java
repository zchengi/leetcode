package _033_Search_in_Rotated_Sorted_Array;

/**
 * LeetCode 033. Search in Rotated Sorted Array
 *
 * @author cheng
 *         2018/09/05 16:31
 */
public class Solution2 {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int l, int r) {

        if (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else {

                if (nums[l] < nums[m] && nums[m] < nums[r]) {
                    if (target < nums[m]) {
                        return search(nums, target, l, m - 1);
                    } else {
                        return search(nums, target, m + 1, r);
                    }
                }else {
                    return Math.max(search(nums, target, l, m - 1), search(nums, target, m + 1, r));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        System.out.println(new Solution2().search(nums, target));
    }
}
