package _040_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 040. Combination Sum II
 *
 * @author cheng
 *         2018/11/19 11:03
 */
public class Solution3 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void combinationSum2(int[] candidates, int target, int index, List<Integer> path) {

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        int prev = 0;
        for (int i = index; i < candidates.length; i++) {

            if (candidates[i] > target) {
                break;
            }

            if (prev != candidates[i]) {
                path.add(candidates[i]);
                combinationSum2(candidates, target - candidates[i], i + 1, path);
                path.remove(path.size() - 1);
                prev = candidates[i];
            }
        }
    }

    public static void main(String[] args) {

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(new Solution3().combinationSum2(candidates, target));
    }
}
