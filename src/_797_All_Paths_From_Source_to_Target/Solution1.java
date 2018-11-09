package _797_All_Paths_From_Source_to_Target;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 797. All Paths From Source to Target
 *
 * @author cheng
 *         2018/11/9 10:56
 */
public class Solution1 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<>();
        findPaths(res, new ArrayList<>(), graph, 0);

        return res;
    }

    private void findPaths(List<List<Integer>> res, List<Integer> path, int[][] graph, int start) {

        path.add(start);

        if (start == graph.length - 1) {
            res.add(new ArrayList<>(path));
        } else {
            for (int i : graph[start]) {
                findPaths(res, path, graph, i);
            }
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(new Solution1().allPathsSourceTarget(graph));
    }
}
