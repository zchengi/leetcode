package _377_Combination_Sum_IV;

/**
 * LeetCode 377. Combination Sum IV
 *
 * @author cheng
 *         2018/12/23 19:52
 */
public class Solution1 {
    public int combinationSum4(int[] nums, int target) {

        if (target == 0 ) {
            return 1;
        }

        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += combinationSum4(nums, target - num);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(new Solution1().combinationSum4(nums, target));
    }
}
