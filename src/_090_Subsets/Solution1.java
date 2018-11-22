package _090_Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 090. Subsets
 *
 * @author cheng
 *         2018/11/22 10:18
 */
public class Solution1 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        res.add(new ArrayList<>());
        subsets(nums, 0, new ArrayList<>());

        return res;
    }

    private void subsets(int[] nums, int index, List<Integer> path) {

        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {

            if (i > index) {
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
            }

            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            subsets(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2};
        System.out.println(new Solution1().subsetsWithDup(nums));
    }
}
