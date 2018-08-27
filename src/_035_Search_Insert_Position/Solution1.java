package _035_Search_Insert_Position;

/**
 * LeetCode 035. Search Insert Position
 *
 * @author cheng
 *         2018/08/27 17:48
 */
public class Solution1 {

    public int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            } else if (target < nums[i]) {
                return i;
            }
        }

        return nums.length;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6};
        int target = 2;

        System.out.println(new Solution1().searchInsert(nums, target));
    }
}
