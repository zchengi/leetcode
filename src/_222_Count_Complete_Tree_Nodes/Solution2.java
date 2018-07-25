package _222_Count_Complete_Tree_Nodes;

import util.TreeNode;

/**
 * LeetCode 222. Count Complete Tree Nodes
 *
 * @author cheng
 *         2018/7/25 15:59
 */
public class Solution2 {

    public int countNodes(TreeNode root) {

        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);

        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int leftDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }

    private int rightDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.right;
            depth++;
        }
        return depth;
    }


    public static void main(String[] args) {

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        right.left = new TreeNode(6);

        TreeNode root = new TreeNode(1);
        root.left = left;
        root.right = right;

        System.out.println(new Solution2().countNodes(root));
    }
}
