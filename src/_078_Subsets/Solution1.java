package _078_Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 078. Subsets
 *
 * @author cheng
 *         2018/11/21 11:05
 */
public class Solution1 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        res.add(new ArrayList<>());
        subsets(nums, 0, new ArrayList<>());
        return res;
    }

    private void subsets(int[] nums, int index, List<Integer> path) {

        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {

            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            subsets(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println(new Solution1().subsets(nums));
    }
}
