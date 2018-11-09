package _797_All_Paths_From_Source_to_Target;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode  797. All Paths From Source to Target
 *
 * @author cheng
 *         2018/11/9 11:36
 */
public class Solution2 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<>();
        if (graph.length > 0) {
            findPaths(graph, res, new ArrayList<>(), 0, graph.length - 1);
        }

        return res;
    }

    private void findPaths(int[][] graph, List<List<Integer>> res, List<Integer> path, int src, int dist) {

        path.add(src);

        if (src == dist) {
            res.add(new ArrayList<>(path));
        } else {
            for (int i : graph[src]) {
                findPaths(graph, res, path, i, dist);
            }
        }

        path.remove(path.size() - 1);
    }


    public static void main(String[] args) {

        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(new Solution2().allPathsSourceTarget(graph));
    }
}
