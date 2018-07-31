package _113_Path_Sum_II;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 113. Path Sum II
 *
 * @author cheng
 *         2018/7/31 19:23
 */
public class Solution1 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> currentResult = new LinkedList<>();

        pathSum(root, sum, currentResult, result);
        return result;
    }

    private void pathSum(TreeNode node, int sum, List<Integer> currentResult, List<List<Integer>> result) {

        if (node == null) {
            return;
        }

        currentResult.add(node.val);
        if (node.left == null && node.right == null && sum == node.val) {
            result.add(new LinkedList<>(currentResult));
            currentResult.remove(currentResult.size() - 1);
            return;
        } else {
            pathSum(node.left, sum - node.val, currentResult, result);
            pathSum(node.right, sum - node.val, currentResult, result);
        }

        currentResult.remove(currentResult.size() - 1);
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
        List<List<Integer>> lists = new Solution1().pathSum(root, 22);
        System.out.println(lists);
    }
}
