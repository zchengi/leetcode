package _111_Minimum_Depth_of_Binary_Tree;

import util.TreeNode;

/**
 * LeetCode 111. Minimum Depth of Binary Tree
 *
 * @author cheng
 *         2018/7/23 18:04
 */
public class Solution {

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0 || right == 0) {
            return left + right + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        TreeNode root = new TreeNode(3);
        root.left = left;
        root.right = right;

        System.out.println(new Solution().minDepth(root));
    }
}
