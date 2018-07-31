package _113_Path_Sum_II;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 113. Path Sum II
 *
 * @author cheng
 *         2018/7/31 19:23
 */
public class Solution2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, result, path);

        return result;
    }

    private void dfs(TreeNode node, int sum, List<List<Integer>> result, List<Integer> path) {

        // entering the node
        path.add(node.val);

        // op at node
        if (node.left == null && node.right == null && node.val == sum) {
            result.add(new ArrayList<>(path));
        }

        if (node.left != null) {
            dfs(node.left, sum - node.val, result, path);
        }
        if (node.right != null) {
            dfs(node.right, sum - node.val, result, path);
        }

        // leaving the node
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(4);
        TreeNode leftLeft = new TreeNode(11);
        leftLeft.left = new TreeNode(7);
        leftLeft.right = new TreeNode(2);
        left.left = leftLeft;

        TreeNode right = new TreeNode(8);
        TreeNode rightLeft = new TreeNode(13);
        TreeNode rightRight = new TreeNode(4);
        rightRight.left = new TreeNode(5);
        rightRight.right = new TreeNode(1);

        right.left = rightLeft;
        right.right = rightRight;

        TreeNode root = new TreeNode(5);
        root.left = left;
        root.right = right;

        int sum = 22;
        List<List<Integer>> lists = new Solution2().pathSum(root, 22);
        System.out.println(lists);
    }
}
