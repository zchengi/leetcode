package _120_Triangle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 120. Triangle
 * <p>
 * 自下而上使用dp解决
 *
 * @author cheng
 *         2018/12/7 13:21
 */
public class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null) {
            return 0;
        }

        // dp[i] 代表每一条路径的最小和
        /*
         *
         *    11
         *    9 10
         *    7 6 10
         *    4 1 8 3
         *
         */
        int[] dp = new int[triangle.get(triangle.size() - 1).size() + 1];

        for (int level = 0; level < triangle.size(); level++) {
            List<Integer> currentRow = triangle.get(triangle.size() - level - 1);
            for (int i = 0; i < triangle.get(triangle.size() - level - 1).size(); i++) {
                dp[i] = Math.min(dp[i], dp[i + 1]) + currentRow.get(i);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {

        List<List<Integer>> triangle = Arrays.asList(
                Collections.singletonList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );

        System.out.println(new Solution2().minimumTotal(triangle));
    }
}
