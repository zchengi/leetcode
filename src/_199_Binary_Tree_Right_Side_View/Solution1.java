package _199_Binary_Tree_Right_Side_View;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 199. Binary Tree Right Side View
 * <p>
 * 思路：
 * 1.树的每一高度都只能选取一个结点
 * 2.用 list 的大小来查看当前树的深度
 *
 * @author cheng
 *         2018/6/27 16:51
 */
public class Solution1 {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        rightSideView(root, result, 0);
        return result;
    }

    private void rightSideView(TreeNode curNode, List<Integer> result, int curDepth) {

        if (curNode == null) {
            return;
        }

        if (curDepth == result.size()) {
            result.add(curNode.val);
        }

        rightSideView(curNode.right, result, curDepth + 1);
        rightSideView(curNode.left, result, curDepth + 1);
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(5);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(4);
        System.out.println(new Solution1().rightSideView(treeNode));
    }
}
