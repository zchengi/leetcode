package _118_Pascals_Triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 118. Pascal's Triangle
 *
 * @author cheng
 *         2018/12/10 18:54
 */
public class Solution1 {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            res.add(new ArrayList<>(row));
        }

        return res;
    }

    public static void main(String[] args) {

        int numRows = 5;
        System.out.println(new Solution1().generate(numRows));
    }
}
