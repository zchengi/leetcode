package _103_Binary_Tree_Zigzag_Level_Order_Traversal;

import javafx.util.Pair;
import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 103. Binary Tree Zigzag Level Order Traversal
 * <p>
 * 二叉树的层序遍历（迭代）
 * 时间复杂度: O(n), n为树的节点个数
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2018/5/8 21:43
 */
public class Solution1 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> front = queue.removeFirst();
            TreeNode node = front.getKey();
            int level = front.getValue();

            if (res.size() <= level) {
                // 使用 LinkedList 实现要求
                res.add(new LinkedList<>());
            }
            assert level < res.size();

            LinkedList<Integer> temp = (LinkedList<Integer>) res.get(level);
            if (level % 2 == 0) {
                // 如果当前层数是偶数层，则从左到右添加元素
                temp.addLast(node.val);
            } else {
                // 如果当前层数是奇数层，则从右到左添加元素
                temp.addFirst(node.val);
            }

            if (node.left != null) {
                queue.addLast(new Pair<>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.addLast(new Pair<>(node.right, level + 1));
            }
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

        System.out.println(new Solution1().zigzagLevelOrder(treeNode));
    }
}
