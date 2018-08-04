package _098_Validate_Binary_Search_Tree;

import util.TreeNode;

/**
 * LeetCode 098. Validate Binary Search Tree
 *
 * @author cheng
 *         2018/8/4 23:07
 */
public class Solution3 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {

        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);

        TreeNode root = new TreeNode(4);
        root.left = left;
        root.right = new TreeNode(6);

        System.out.println(new Solution3().isValidBST(root));
    }
}
