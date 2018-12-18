package _740_Delete_and_Earn;

/**
 * LeetCode 740. Delete and Earn
 *
 * @author cheng
 *         2018/12/18 11:48
 */
public class Solution2 {

    /**
     * since nums[i] is positive integer range [1,10000];
     * If we sort all the numbers into buckets indexed by these numbers, this is essentially
     * asking you to repetitively take an bucket while giving up the 2 buckets next to it.
     * 1) store values in nums into respected buckets called int[] memo
     * 2) The optimal solution at bucket index 'i' is memo[i] = max(memo[i-2] + memo[i], memo[i-1])
     */
    public int deleteAndEarn(int[] nums) {

        int[] memo = new int[10001];

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            memo[num] += num;
        }

        for (int i = 2; i <= max; i++) {
            memo[i] = Math.max(memo[i] + memo[i - 2], memo[i - 1]);
        }

        return memo[max];
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 2};
        System.out.println(new Solution2().deleteAndEarn(nums));
    }
}
