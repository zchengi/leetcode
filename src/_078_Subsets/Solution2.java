package _078_Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 078. Subsets
 *
 * @author cheng
 *         2018/11/21 11:23
 */
public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(int[] nums, int index, List<Integer> path, List<List<Integer>> res) {

        res.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println(new Solution2().subsets(nums));
    }
}
