package _049_Group_Anagrams._697_Degree_of_an_Array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 697. Degree of an Array
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * <p>
 * 分析：这道题的解法的关键字在于：选取了 数组元素 i 第一次出现的索引 left，最后一次出现的索引 right，
 * 以及 元素 i 在数组中的出现次数 counts，然后：
 * 1. 找到 counts 数组中的最大值即元素的 degree；
 * 2. 根据 counts 的 key 计算出 left 与 right 之间的元素个数 answer；
 * 3. 循环查找是否存在某个元素的出现次数与 degree 相同，如果有则判断该元素的 left 与 right 之间的元素个数与 answer 的大小，
 * -  小于 answer 则更新 answer 的值更小值。
 *
 * @author cheng
 *         2018/3/19 20:26
 */
public class Solution1 {
    public int findShortestSubArray(int[] nums) {

        if (nums.length == 0 || nums == null) return 0;

        // 假设当前索引的值为 i
        // i 从左侧遍历第一次出现的索引
        Map<Integer, Integer> left = new HashMap<>();
        // i 从右侧遍历第一次出现的索引
        Map<Integer, Integer> right = new HashMap<>();
        // 包含所有 i 的最小数组的长度
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            // 如果当前 x 没有在 left 中出现过则添加
            if (left.get(x) == null) {
                left.put(x, i);
            }
            // 将当前 x 及其出现的索引添加到 right 中
            right.put(x, i);
            // 将当前 x 出现的次数记录在 count 中
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        // 求出数组的 degree
        int degree = Collections.max(count.values());

        int answer = nums.length;
        for (int x : count.keySet()) {
            if (count.get(x) == degree) {
                answer = Math.min(answer, right.get(x) - left.get(x) + 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 3, 1};
        System.out.println(new Solution1().findShortestSubArray(nums));
    }
}
