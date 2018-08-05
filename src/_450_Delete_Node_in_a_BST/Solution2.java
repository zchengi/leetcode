package _450_Delete_Node_in_a_BST;

import util.TreeNode;

/**
 * LeetCode 450. Delete Node in a BST
 *
 * @author cheng
 *         2018/8/5 19:17
 */
public class Solution2 {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode node = minRight(root.right);
                root.val = node.val;
                root.right = deleteNode(root.right, root.val);
            }
        }

        return root;
    }

    private TreeNode minRight(TreeNode node) {
        if (node == null) {
            return null;
        }

        while (node.left != null) {
            node = node.left;
        }

        return node;
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

        int key = 3;

        System.out.println(new Solution2().deleteNode(root, 3));
    }
}
