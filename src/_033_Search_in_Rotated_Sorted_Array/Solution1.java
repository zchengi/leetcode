package _033_Search_in_Rotated_Sorted_Array;

/**
 * LeetCode 033. Search in Rotated Sorted Array
 *
 * @author cheng
 *         2018/09/05 16:22
 */
public class Solution1 {
    public int search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (target == nums[mid]) {
                return mid;
            }

            if (nums[mid] < nums[lo]) {
                // 6,7,0,1,2,3,4,5
                if (target < nums[mid] || target >= nums[lo]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                // 2,3,4,5,6,7,0,1
                if (target > nums[mid] || target < nums[lo]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        System.out.println(new Solution1().search(nums, target));
    }
}
