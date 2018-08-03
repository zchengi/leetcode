package _783_Minimum_Distance_Between_BST_Nodes;

import util.TreeNode;

/**
 * LeetCode 783. Minimum Distance Between BST Nodes
 * <p>
 * 思路：前序遍历，即按照从小到大的顺序遍历，然后计算没两个数的差，找出最小差值
 *
 * @author cheng
 *         2018/8/3 20:20
 */
public class Solution1 {

    private int res = Integer.MAX_VALUE;
    private int prev = -1;

    public int minDiffInBST(TreeNode root) {

        inorder(root);
        return res;
    }

    private void inorder(TreeNode node) {

        if (node == null) {
            return;
        }

        inorder(node.left);
        if (prev != -1) {
            res = Math.min(res, node.val - prev);
        }
        prev = node.val;

        inorder(node.right);
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);

        TreeNode root = new TreeNode(4);
        root.left = left;
        root.right = new TreeNode(6);

        System.out.println(new Solution1().minDiffInBST(root));
    }
}
