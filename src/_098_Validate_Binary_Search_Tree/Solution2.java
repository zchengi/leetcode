package _098_Validate_Binary_Search_Tree;

import util.TreeNode;

import java.util.Stack;

/**
 * LeetCode 098. Validate Binary Search Tree
 *
 * @author cheng
 *         2018/8/4 22:58
 */
public class Solution2 {
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (pre != null && root.val <= pre.val) {
                return false;
            }

            pre = root;
            root = root.right;
        }

        return true;
    }


    public static void main(String[] args) {

        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);

        TreeNode root = new TreeNode(4);
        root.left = left;
        root.right = new TreeNode(6);

        System.out.println(new Solution2().isValidBST(root));
    }
}
