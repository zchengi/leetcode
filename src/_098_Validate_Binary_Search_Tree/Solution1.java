package _098_Validate_Binary_Search_Tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 098. Validate Binary Search Tree
 *
 * @author cheng
 *         2018/8/4 22:42
 */
public class Solution1 {
    public boolean isValidBST(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }

        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) <= res.get(i - 1)) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);

        TreeNode root = new TreeNode(4);
        root.left = left;
        root.right = new TreeNode(6);

        System.out.println(new Solution1().isValidBST(root));
    }
}
