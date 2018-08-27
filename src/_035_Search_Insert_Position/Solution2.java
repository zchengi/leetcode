package _035_Search_Insert_Position;

/**
 * LeetCode 035. Search Insert Position
 *
 * @author cheng
 *         2018/08/27 17:54
 */
public class Solution2 {

    public int searchInsert(int[] nums, int target) {

        int lo = 0;
        int high = nums.length;

        while (lo < high) {
            int hi = lo + (high - lo) / 2;

            if (target == nums[hi]) {
                return hi;
            } else if (target < nums[hi]) {
                high = hi;
            } else {
                if (hi == lo) {
                    return lo + 1;
                }
                lo = hi;
            }
        }

        return lo;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6};
        int target = 2;

        System.out.println(new Solution2().searchInsert(nums, target));
    }
}
