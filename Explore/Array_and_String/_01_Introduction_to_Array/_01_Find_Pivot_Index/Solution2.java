package _01_Find_Pivot_Index;

/**
 * LeetCode 724. Find Pivot Index
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author cheng
 *         2019/1/20 17:54
 */
public class Solution2 {
    public int pivotIndex(int[] nums) {

        if (nums.length == 0) {
            return -1;
        }

        int sum = 0, leftSum = 0;
        for (int num : nums) {
            sum += num;
        }

        for (int index = 0; index < nums.length; index++) {
            if (leftSum == sum - leftSum - nums[index]) {
                return index;
            }

            leftSum += nums[index];
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(new Solution2().pivotIndex(nums));

        nums = new int[]{-1, -1, -1, 0, 1, 1};
        System.out.println(new Solution2().pivotIndex(nums));
    }
}
