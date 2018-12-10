package _118_Pascals_Triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 118. Pascal's Triangle
 *
 * @author cheng
 *         2018/12/10 19:22
 */
public class Solution2 {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        if (numRows == 0) {
            return res;
        }

        List<Integer> prev = new ArrayList<>();

        prev.add(1);
        res.add(prev);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> cur = new ArrayList<>();

            for (int j = 0; j <= prev.size(); j++) {
                int left = j - 1 >= 0 ? prev.get(j - 1) : 0;
                int right = j < prev.size() ? prev.get(j) : 0;
                cur.add(left + right);
            }

            res.add(cur);
            prev = cur;
        }

        return res;
    }

    public static void main(String[] args) {

        int numRows = 5;
        System.out.println(new Solution2().generate(numRows));
    }
}
