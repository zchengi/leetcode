package _129_Sum_Root_to_Leaf_Numbers;

import util.TreeNode;

import java.util.ArrayList;

/**
 * LeetCode 129. Sum Root to Leaf Numbers
 *
 * @author cheng
 *         2018/8/1 17:14
 */
public class Solution1 {
    public int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        ArrayList<Integer> res = new ArrayList<>();
        dfs(root, new StringBuilder(), res);

        int sum = 0;
        for (int num : res) {
            sum += num;
        }

        return sum;
    }

    private void dfs(TreeNode root, StringBuilder builder, ArrayList<Integer> res) {

        builder.append(root.val);

        if (root.left == null && root.right == null) {
            res.add(Integer.parseInt(String.valueOf(builder)));
        }

        if (root.left != null) {
            dfs(root.left, builder, res);
        }
        if (root.right != null) {
            dfs(root.right, builder, res);
        }

        builder.delete(builder.length() - 1, builder.length());
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(9);
        left.left = new TreeNode(5);
        left.right = new TreeNode(1);

        TreeNode root = new TreeNode(4);
        root.left = left;
        root.right = new TreeNode(0);

        System.out.println(new Solution1().dfs(root));
    }
}
