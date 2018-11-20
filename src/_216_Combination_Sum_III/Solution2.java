package _216_Combination_Sum_III;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 216. Combination Sum III
 *
 * @author cheng
 *         2018/11/20 11:09
 */
public class Solution2 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        combinationSum3(k, n, 1, new ArrayList<>());
        return res;
    }

    private void combinationSum3(int k, int n, int index, List<Integer> path) {

        if (index > 10 || k < 0 || n < 0) {
            return;
        }

        if (k == 0 && n == 0 && index <= 10) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < 10; i++) {
            path.add(i);
            combinationSum3(k - 1, n - i, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        int k = 3, n = 7;
        System.out.println(new Solution2().combinationSum3(k, n));

        k = 3;
        n = 9;
        System.out.println(new Solution2().combinationSum3(k, n));
    }
}
