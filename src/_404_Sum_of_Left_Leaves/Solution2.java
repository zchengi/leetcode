package _404_Sum_of_Left_Leaves;

import util.TreeNode;

import java.util.Stack;

/**
 * LeetCode 404. Sum of Left Leaves
 *
 * @author cheng
 *         2018/7/29 20:59
 */
public class Solution2 {
    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int sum = 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                } else {
                    stack.push(node.left);
                }
            }

            if (node.right != null) {
                if (node.right.left != null || node.right.right != null) {
                    stack.push(node.right);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        TreeNode root = new TreeNode(3);
        root.left = left;
        root.right = right;

        System.out.println(new Solution2().sumOfLeftLeaves(root));
    }
}
