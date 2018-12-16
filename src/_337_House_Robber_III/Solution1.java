package _337_House_Robber_III;

import util.TreeNode;

/**
 * LeetCode 337. House Robber III
 * <p>
 * 递归
 *
 * @author cheng
 *         2018/12/16 22:20
 */
public class Solution1 {
    /**
     * 终止条件：我们何时知道 rob(root) 没有任何计算的答案？当然，当树是空的时候----我们没有什么可以抢劫的，因此金额为零。
     * <p>
     * 递归关系：即，如何 rob(root) 从 rob(root.left), rob(root.right), ...等等。
     * 从树根的角度来看，最后只有两个场景：root 抢劫或不抢劫。
     * 如果是，由于“我们不能抢夺任何两个直接连接的房屋”的约束，
     * 可用的下一级子树将是四个“ 孙子 - 子树 ”（root.left.left, root.left.right, root.right.left, root.right.right）。
     * 但是，如果 root 没有被抢夺，下一级可用子树就是两个“ 子子树 ”（root.left, root.right）。我们只需要选择产生更多金钱的情景。
     */
    public int rob(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int val = 0;

        // root 节点左子树不抢劫
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }

        // root 节点右子树不抢劫
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }

        // root 节点最大值:
        // 可能1. 抢劫 root 节点
        // 可能2. 不抢劫 root 节点
        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(2);
        left.right = new TreeNode(3);
        TreeNode right = new TreeNode(3);
        right.right = new TreeNode(1);

        TreeNode root = new TreeNode(3);
        root.left = left;
        root.right = right;

        System.out.println(new Solution1().rob(root));
    }
}
