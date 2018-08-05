package _450_Delete_Node_in_a_BST;

import util.TreeNode;

/**
 * LeetCode 450. Delete Node in a BST
 *
 * @author cheng
 *         2018/8/5 18:58
 */
public class Solution1 {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null) {
                TreeNode rightNode = root.right;
                root.right = null;
                return rightNode;
            }

            if (root.right == null) {
                TreeNode leftNode = root.left;
                root.left = null;
                return leftNode;
            }

            TreeNode successor = minium(root.right);
            successor.right = removeMin(root.right);
            successor.left = root.left;

            root.left = root.right = null;

            return successor;
        }
    }

    private TreeNode minium(TreeNode node) {

        if (node.left == null) {
            return node;
        }

        return minium(node.left);
    }

    private TreeNode removeMin(TreeNode node) {

        if (node.left == null) {
            TreeNode rightNode = node.right;
            node.right = null;
            return rightNode;
        }

        node.left = removeMin(node.left);
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

        System.out.println(new Solution1().deleteNode(root, 3));
    }
}
