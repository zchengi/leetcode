package _236_Lowest_Common_Ancestor_if_a_Binary_Tree;

import util.TreeNode;

/**
 * LeetCode 236. Lowest Common Ancestor if a Binary Tree
 *
 * @author cheng
 *         2018/8/8 22:17
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {

        TreeNode leftRight = new TreeNode(2);
        leftRight.left = new TreeNode(7);
        leftRight.right = new TreeNode(4);

        TreeNode left = new TreeNode(5);
        left.left = new TreeNode(6);
        left.right = leftRight;

        TreeNode right = new TreeNode(1);
        right.left = new TreeNode(0);
        right.right = new TreeNode(8);

        TreeNode root = new TreeNode(3);
        root.left = left;
        root.right = right;

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);

        System.out.println(new Solution().lowestCommonAncestor(root, p, q));
    }
}
