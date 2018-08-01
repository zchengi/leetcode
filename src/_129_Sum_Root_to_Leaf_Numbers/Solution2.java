package _129_Sum_Root_to_Leaf_Numbers;

import util.TreeNode;

/**
 * LeetCode 129. Sum Root to Leaf Numbers
 *
 * @author cheng
 *         2018/8/1 17:25
 */
public class Solution2 {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int num) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 10 * num + node.val;
        }

        return helper(node.left, 10 * num + node.val) + helper(node.right, 10 * num + node.val);
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(9);
        left.left = new TreeNode(5);
        left.right = new TreeNode(1);

        TreeNode root = new TreeNode(4);
        root.left = left;
        root.right = new TreeNode(0);

        System.out.println(new Solution2().sumNumbers(root));
    }
}
