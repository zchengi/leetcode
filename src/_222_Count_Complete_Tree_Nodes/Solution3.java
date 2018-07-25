package _222_Count_Complete_Tree_Nodes;

import util.TreeNode;

/**
 * LeetCode 222. Count Complete Tree Nodes
 * <p>
 *
 *
 * @author cheng
 *         2018/7/25 16:44
 */
public class Solution3 {

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.val != -1) {
            root.val = -1;
            return 1 + countNodes(root.left) + countNodes(root.right);
        } else {
            return 0;
        }
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

        System.out.println(new Solution3().countNodes(root));
    }
}
