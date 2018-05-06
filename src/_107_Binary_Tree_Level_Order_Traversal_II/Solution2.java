package _107_Binary_Tree_Level_Order_Traversal_II;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 102. Binary Tree Level Order Traversal II
 * <p>
 * 二叉树的层序遍历（递归）
 * 时间复杂度: O(n), n为树的节点个数
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2018/5/6 23:34
 */
public class Solution2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> levelList = new ArrayList<>();

        helper(root, levelList, 0);
        return levelList;
    }

    private void helper(TreeNode node, List<List<Integer>> levelList, int level) {

        if (node == null) {
            return;
        }

        if (levelList.size() <= level) {
            levelList.add(0, new ArrayList<>());
        }

        helper(node.left, levelList, level + 1);
        helper(node.right, levelList, level + 1);
        levelList.get(levelList.size() - level - 1).add(node.val);
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3);
        TreeNode right = new TreeNode(20);

        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        treeNode.left = new TreeNode(9);
        treeNode.right = right;

        System.out.println(new Solution2().levelOrderBottom(treeNode));
    }
}
