package _337_House_Robber_III;

import util.TreeNode;

/**
 * LeetCode 337. House Robber III
 * <p>
 * 最优子结构 + 重叠子问题 -> 动态规划(贪心算法)
 *
 * @author cheng
 *         2018/12/16 22:58
 */
public class Solution3 {

    public int rob(TreeNode root) {

        // res[0] 表示不抢劫当前节点
        // res[1] 表示抢劫当前节点
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * 如果我们能够维护每个树根的两个可能，如下：
     * 重新定义 rob(root) 作为一个新函数，它将返回两个元素的数组，
     * 其中第一个元素表示如果 root 没有被抢劫可以抢劫的最大金额，而第二个元素表示 root 被抢劫的最大金额。
     * <p>
     * 这让我们将 rob(root) 与 rob(root.left) 和 rob(root.right)...... 等联系起来。
     * 对于 rob(root) 的第一个元素，我们只需要总结 rob(root.left) 和 rob(root.right) 的最大值，
     * 因为 root 不被抢夺，我们可以自由地抢夺它的左右子树。
     * 但是，对于 rob(root) 的第二个元素，我们只需要分别添加 rob(root.left) 和 rob(root.right) 的第一个元素，
     * 加上从 root 本身抢夺的值，因为在这种情况下我们保证不会抢夺 root.left 和 root.right 的节点。
     */
    private int[] robSub(TreeNode root) {

        if (root == null) {
            return new int[2];
        }

        // root 节点左子树
        int[] left = robSub(root.left);
        // root 节点右子树
        int[] right = robSub(root.right);

        int[] res = new int[2];

        // 不抢劫当前节点
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 抢劫当前节点
        res[1] = root.val + left[0] + right[0];

        return res;
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(2);
        left.right = new TreeNode(3);
        TreeNode right = new TreeNode(3);
        right.right = new TreeNode(1);

        TreeNode root = new TreeNode(3);
        root.left = left;
        root.right = right;

        System.out.println(new Solution3().rob(root));
    }
}
