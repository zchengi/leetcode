package _230_Kth_Smallest_Element_in_a_BST;

import util.TreeNode;

/**
 * LeetCode 230. Kth Smallest Element in a BST
 * <p>
 * Binary Search (dfs): most preferable
 *
 * @author cheng
 *         2018/8/7 23:17
 */
public class Solution1 {
    public int kthSmallest(TreeNode root, int k) {

        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            // 1 is counted as current node
            return kthSmallest(root.right, k - 1 - count);
        }

        return root.val;
    }

    public int countNodes(TreeNode node) {

        if (node == null) {
            return 0;
        }

        return 1 + countNodes(node.left) + countNodes(node.right);
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

        System.out.println(new Solution1().kthSmallest(root, k));
    }
}
