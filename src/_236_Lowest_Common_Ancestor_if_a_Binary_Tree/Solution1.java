package _236_Lowest_Common_Ancestor_if_a_Binary_Tree;

import util.TreeNode;

/**
 * LeetCode 236. Lowest Common Ancestor if a Binary Tree
 *
 * @author cheng
 *         2018/8/8 22:17
 */
public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return null;
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

        System.out.println(new Solution1().lowestCommonAncestor(root, p, q));
    }
}
