package _01_Find_Pivot_Index;

/**
 * LeetCode 724. Find Pivot Index
 * <p>
 * Time Complexity: O(2n)
 * Space Complexity: O(n)
 *
 * @author cheng
 *         2019/1/20 17:34
 */
public class Solution1 {
    public int pivotIndex(int[] nums) {

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return -1;
        }

        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum == 0) {
            return 0;
        }

        int leftSum = 0;
        for (int cur = 1; cur < nums.length; cur++) {
            leftSum += nums[cur - 1];
            sum -= nums[cur];

            if (leftSum == sum) {
                return cur;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(new Solution1().pivotIndex(nums));

        nums = new int[]{-1, -1, -1, 0, 1, 1};
        System.out.println(new Solution1().pivotIndex(nums));
    }
}
