package _108_Convert_Sorted_Array_to_Binary_Search_Tree;

import util.TreeNode;

/**
 * LeetCode 108. Convert Sorted Array to Binary Search Tree
 *
 * @author cheng
 *         2018/8/6 23:34
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    private TreeNode merge(int[] nums, int lo, int hi) {

        if (lo > hi) {
            return null;
        }

        int mid = (hi - lo) / 2 + lo;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = merge(nums, lo, mid - 1);
        node.right = merge(nums, mid + 1, hi);

        return node;
    }

    public static void main(String[] args) {

        int[] nums = {-10, -3, 0, 5, 9};
        System.out.println(new Solution().sortedArrayToBST(nums));
    }
}
