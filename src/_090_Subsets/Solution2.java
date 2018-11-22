package _090_Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 090. Subsets
 *
 * @author cheng
 *         2018/11/22 10:20
 */
public class Solution2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums, 0, new ArrayList<>(), res);

        return res;
    }

    private void subsets(int[] nums, int index, List<Integer> path, List<List<Integer>> res) {

        res.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            subsets(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2};
        System.out.println(new Solution2().subsetsWithDup(nums));
    }
}
