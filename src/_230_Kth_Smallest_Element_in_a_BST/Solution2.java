package _230_Kth_Smallest_Element_in_a_BST;

import util.TreeNode;

/**
 * LeetCode 230. Kth Smallest Element in a BST
 * <p>
 * DFS in-order recursive:
 *
 * @author cheng
 *         2018/8/7 23:29
 */
public class Solution2 {

    private static int number = 0;
    private static int count = 0;

    public int kthSmallest(TreeNode root, int k) {

        count = k;
        helper(root);
        return number;
    }

    private void helper(TreeNode node) {

        if (node.left != null) {
            helper(node.left);
        }
        count--;

        if (count == 0) {
            number = node.val;
            return;
        }

        if (node.right != null) {
            helper(node.right);
        }
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(3);
        left.left = new TreeNode(2);
        left.right = new TreeNode(4);

        TreeNode right = new TreeNode(6);
        right.right = new TreeNode(7);

        TreeNode root = new TreeNode(5);
        root.left = left;
        root.right = right;

        int k = 3;

        System.out.println(new Solution2().kthSmallest(root, k));
    }
}
