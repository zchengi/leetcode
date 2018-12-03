package _051_N_Queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 051. N-Queens
 * <p>
 * 二刷
 * <p>
 * 时间复杂度: O(n^n)
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2018/12/3 20:11
 */
public class Solution3 {

    /**
     * 记录每一列已经被占用的列标记
     */
    private boolean[] col;

    /**
     * 记录对角线1已经被节点占用的标记
     * 计算方式：横坐标 + 纵坐标（x + y）
     */
    private boolean[] dia1;

    /**
     * 记录对角线1已经被节点占用的标记
     * 计算方式：横坐标 - 纵坐标（x - y + n - 1，加n减一是为了保证得到的值永远是整值）
     */
    private boolean[] dia2;

    private ArrayList<List<String>> res;

    public List<List<String>> solveNQueens(int n) {

        res = new ArrayList<>();
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        // 记录每个皇后每一个行所在的位置
        List<Integer> row = new ArrayList<>();
        putQueue(n, 0, row);

        return res;
    }

    /**
     * 尝试在一个n皇后问题中，摆放第 index 行的皇后位置
     */
    private void putQueue(int n, int index, List<Integer> row) {

        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }

        for (int i = 0; i < n; i++) {
            // 尝试将第 index 行的皇后摆放在第 i 列
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {

                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                row.add(i);

                putQueue(n, index + 1, row);

                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.remove(row.size() - 1);
            }
        }
    }

    private List<String> generateBoard(int n, List<Integer> row) {

        assert row.size() == n;

        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[row.get(i)] = 'Q';
            board.add(new String(chars));
        }

        return board;
    }

    public static void main(String[] args) {

        int n = 4;
        List<List<String>> lists = new Solution3().solveNQueens(n);

        int count = 1;
        for (List<String> list : lists) {
            System.out.println(n + "皇后问题，第 " + count++ + " 种解法：");
            for (String str : list) {
                System.out.println(str);
            }
            System.out.println();
        }
        System.out.println(n + "皇后问题共有" + lists.size() + "种解法。");
    }
}
