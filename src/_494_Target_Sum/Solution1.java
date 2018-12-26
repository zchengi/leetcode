package _494_Target_Sum;

/**
 * LeetCode 494. Target Sum
 * <p>
 * DFS
 *
 * @author cheng
 *         2018/12/26 13:25
 */
public class Solution1 {

    private int res = 0;

    public int findTargetSumWays(int[] nums, int S) {

        dfs(nums, S, 0, 0);

        return res;
    }

    private void dfs(int[] nums, int s, int index, int cur) {

        if (index == nums.length) {
            if (cur == s) {
                res++;
            }
            return;
        }


        dfs(nums, s, index + 1, cur + nums[index]);
        dfs(nums, s, index + 1, cur - nums[index]);
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(new Solution1().findTargetSumWays(nums, S));
    }
}
