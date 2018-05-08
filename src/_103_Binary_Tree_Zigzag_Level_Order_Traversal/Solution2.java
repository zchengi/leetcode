package _103_Binary_Tree_Zigzag_Level_Order_Traversal;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 103. Binary Tree Zigzag Level Order Traversal
 * <p>
 * 二叉树的层序遍历（递归）
 * 时间复杂度: O(n), n为树的节点个数
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2018/5/8 21:43
 */
public class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        travel(root, res, 0);
        return res;
    }

    private void travel(TreeNode node, List<List<Integer>> res, int level) {

        if (node == null) {
            return;
        }

        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }

        if (level % 2 == 0) {
            res.get(level).add(node.val);
        } else {
            res.get(level).add(0, node.val);
        }

        travel(node.left, res, level + 1);
        travel(node.right, res, level + 1);
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3);
        TreeNode right = new TreeNode(20);

        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        treeNode.left = new TreeNode(9);
        treeNode.right = right;

        System.out.println(new Solution2().zigzagLevelOrder(treeNode));
    }
}
