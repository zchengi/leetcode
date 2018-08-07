package _230_Kth_Smallest_Element_in_a_BST;

import util.TreeNode;

import java.util.Stack;

/**
 * LeetCode 230. Kth Smallest Element in a BST
 * <p>
 * DFS in-order recursive:
 *
 * @author cheng
 *         2018/8/7 23:31
 */
public class Solution3 {
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> st = new Stack<>();

        while (root != null) {
            st.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0) {
                return n.val;
            }

            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }
        // never hit if k is valid
        return -1;
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(3);
        left.left = new TreeNode(2);
        left.right = new TreeNode(4);

        TreeNode right = new TreeNode(6);
        right.right = new TreeNode(7);

        TreeNode root = new TreeNode(5);
        root.left = left;
        root.right = right;

        int k = 3;

        System.out.println(new Solution3().kthSmallest(root, k));
    }
}
