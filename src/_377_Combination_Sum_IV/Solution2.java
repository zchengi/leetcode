package _377_Combination_Sum_IV;

/**
 * LeetCode 377. Combination Sum IV
 *
 * @author cheng
 *         2018/12/23 20:05
 */
public class Solution2 {
    public int combinationSum4(int[] nums, int target) {


        int[] comb = new int[target+1];
        comb[0] = 1;

        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }

        return comb[target];
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(new Solution2().combinationSum4(nums, target));
    }
}
