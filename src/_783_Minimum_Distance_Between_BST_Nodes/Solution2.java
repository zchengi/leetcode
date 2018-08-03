package _783_Minimum_Distance_Between_BST_Nodes;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 783. Minimum Distance Between BST Nodes
 * <p>
 * 思路：中序遍历将所有元素添加到一个链表，排序链表，然后计算相邻的两个数的最小差值
 *
 * @author cheng
 *         2018/8/3 20:20
 */
public class Solution2 {
    public int minDiffInBST(TreeNode root) {

        int res = Integer.MAX_VALUE;

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }

        for (int i = 1; i < list.size() ; i++) {
            res = Math.min(res, list.get(i) - list.get(i - 1));
        }

        return res;
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);

        TreeNode root = new TreeNode(4);
        root.left = left;
        root.right = new TreeNode(6);

        System.out.println(new Solution2().minDiffInBST(root));
    }
}
