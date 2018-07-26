package _110_Balanced_Binary_Tree;

import util.TreeNode;

/**
 * LeetCode 110. Balanced Binary Tree
 *
 * @author cheng
 *         2018/7/26 20:53
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        return dfsDepth(root) != -1;
    }

    private int dfsDepth(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftDepth = dfsDepth(node.left);
        if (leftDepth == -1) {
            return -1;
        }

        int rightDepth = dfsDepth(node.right);
        if (rightDepth == -1) {
            return -1;
        }

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);

        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        TreeNode root = new TreeNode(3);
        root.left = left;
        root.right = right;

        System.out.println(new Solution().isBalanced(root));
    }
}
