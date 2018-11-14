package _047_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 047. Permutations II
 * <p>
 * 分析：与46题很类似，先将该数组排序，然后添加判断。
 * -
 *
 * @author cheng
 *         2018/11/14 10:29
 */
public class Solution1 {

    private List<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {

        res = new ArrayList<>();
        used = new boolean[nums.length];

        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        generatePermutation(nums, new ArrayList<>());
        return res;
    }

    private void generatePermutation(int[] nums, List<Integer> p) {

        if (nums.length == p.size()) {
            res.add(new ArrayList<>(p));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            // 如果当前元素和它的前一个元素相等，且前一个元素没有使用，则跳出循环进入下一次
            // 这里没有使用的意思也就是已经遍历过一次该值的元素了，不用再重复遍历
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            p.add(nums[i]);

            generatePermutation(nums, p);

            used[i] = false;
            p.remove(p.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2};
        System.out.println(new Solution1().permuteUnique(nums));
    }
}
