package _494_Target_Sum;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 494. Target Sum
 * <p>
 * 记忆化搜索
 *
 * @author cheng
 *         2018/12/26 13:57
 */
public class Solution3 {

    public int findTargetSumWays(int[] nums, int S) {

        int[] sums = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            sums[i] = nums[i] + (i < nums.length - 1 ? sums[i + 1] : 0);
        }

        return dfs(nums, 0, 0, S, sums, new HashMap<>());
    }

    private int dfs(int[] nums, int start, int sum, int S, int[] sums, Map<String, Integer> map) {

        if (start == nums.length) {
            return sum == S ? 1 : 0;
        }

        if (sum + sums[start] < S) {
            return 0;
        }

        String key = start + " " + sum;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int count = dfs(nums, start + 1, sum + nums[start], S, sums, map)
                +dfs(nums, start+1, sum-nums[start], S, sums, map);

        map.put(key, count);

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(new Solution3().findTargetSumWays(nums, S));
    }
}
