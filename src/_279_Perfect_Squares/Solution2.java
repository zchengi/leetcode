package _279_Perfect_Squares;

import javafx.util.Pair;

import java.util.LinkedList;

/**
 * LeetCode 279. Perfect Squares
 * <p>
 * 使用 visited 数组，记录每一个入队元素
 * <p>
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2018/6/27 20:08
 */
public class Solution2 {
    public int numSquares(int n) {

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(n, 0));

        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            if (num == 0) {
                return step;
            }

            for (int i = 1; num - i * i >= 0; i++) {
                if (!visited[num - i * i]) {
                    queue.addLast(new Pair<>(num - i * i, step + 1));
                    visited[num - i * i] = true;
                }
            }
        }

        throw new IllegalArgumentException("No Solution.");
    }

    public static void main(String[] args) {

        System.out.println(new Solution2().numSquares(12));
        System.out.println(new Solution2().numSquares(13));
    }
}
