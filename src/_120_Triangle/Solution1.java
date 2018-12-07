package _120_Triangle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 120. Triangle
 * <p>
 * 动态规划
 *
 * @author cheng
 *         2018/12/7 12:49
 */
public class Solution1 {

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // 获取第 i+1 行 j+1 个数字
                int self = triangle.get(i).get(j);
                // 获取这一行与下一行相邻数的和的最小值
                int res = Math.min(triangle.get(i + 1).get(j) + self, triangle.get(i + 1).get(j + 1) + self);
                // 更新第 i+1 行 第 j+1 个数字
                triangle.get(i).set(j, res);
            }
        }

        // 返回第一行第一个数字，也就是最小值
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {

        List<List<Integer>> triangle = Arrays.asList(
                Collections.singletonList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );

        System.out.println(new Solution1().minimumTotal(triangle));
    }
}
