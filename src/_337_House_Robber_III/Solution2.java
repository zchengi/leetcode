package _337_House_Robber_III;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 337. House Robber III
 * <p>
 * 最优子结构 + 重叠子问题
 * 使用哈希映射来记录访问的子树的结果
 *
 * @author cheng
 *         2018/12/16 22:43
 */
public class Solution2 {

    public int rob(TreeNode root) {
        return robSub(root, new HashMap<>());
    }

    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {

        if (root == null) {
            return 0;
        }

        if (map.containsKey(root)) {
            return map.get(root);
        }

        int val = 0;

        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);

        return val;
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(2);
        left.right = new TreeNode(3);
        TreeNode right = new TreeNode(3);
        right.right = new TreeNode(1);

        TreeNode root = new TreeNode(3);
        root.left = left;
        root.right = right;

        System.out.println(new Solution2().rob(root));
    }
}
