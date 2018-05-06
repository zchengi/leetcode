package _107_Binary_Tree_Level_Order_Traversal_II;

import javafx.util.Pair;
import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 107. Binary Tree Level Order Traversal II
 * <p>
 * 二叉树的层序遍历（迭代）
 * 时间复杂度: O(n), n为树的节点个数
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2018/5/6 23:19
 */
public class Solution1 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 使用 LinkedList 来作为先入先出的队列
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> front = queue.removeFirst();
            TreeNode node = front.getKey();
            int level = front.getValue();

            // 第一层为0，第二层为1 ···
            if (level == res.size()) {
                res.add(0, new ArrayList<>());
            }
            assert level < res.size();

            if (node.left != null) {
                queue.addLast(new Pair<>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.addLast(new Pair<>(node.right, level + 1));
            }
            res.get(res.size() - level - 1).add(node.val);
        }

        return res;
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3);
        TreeNode right = new TreeNode(20);

        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        treeNode.left = new TreeNode(9);
        treeNode.right = right;

        System.out.println(new Solution1().levelOrderBottom(treeNode));
    }
}
