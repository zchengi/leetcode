package _404_Sum_of_Left_Leaves;

import util.TreeNode;

/**
 * LeetCode 404. Sum of Left Leaves
 *
 * @author cheng
 *         2018/7/29 20:44
 */
public class Solution1 {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode node, boolean flag) {

        if (node == null) {
            return 0;
        }

        if (flag && node.left == null && node.right == null) {
            return node.val;
        }

        return sumOfLeftLeaves(node.left, true) + sumOfLeftLeaves(node.right, false);
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        TreeNode root = new TreeNode(3);
        root.left = left;
        root.right = right;

        System.out.println(new Solution1().sumOfLeftLeaves(root));
    }
}
