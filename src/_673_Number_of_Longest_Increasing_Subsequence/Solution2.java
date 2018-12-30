package _673_Number_of_Longest_Increasing_Subsequence;

/**
 * LeetCode 673. Number of Longest Increasing SubSequence
 *
 * @author cheng
 *         2018/12/30 22:43
 */
public class Solution2 {
    public int findNumberOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Node[] nodes = new Node[nums.length];
        nodes[0] = new Node(nums[0], 1, null);

        int curNodeIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            int sum = 0;

            if (nums[i] > nodes[curNodeIndex].num) {
                Node node = nodes[curNodeIndex];
                while (node != null && node.num < nums[i]) {
                    sum += node.count;
                    node = node.next;
                }

                nodes[++curNodeIndex] = new Node(nums[i], sum, null);
            } else {
                int index = get(nodes, curNodeIndex + 1, nums[i]);
                if (index == 0) {
                    sum = 1;
                } else {
                    Node node = nodes[index - 1];
                    while (node != null && node.num < nums[i]) {
                        sum += node.count;
                        node = node.next;
                    }
                }

                nodes[index] = new Node(nums[i], sum, nodes[index]);
            }
        }

        int res = 0;
        Node node = nodes[curNodeIndex];

        while (node != null) {
            res += node.count;
            node = node.next;
        }

        return res;
    }

    public int get(Node[] nodes, int last, int target) {
        int left = 0, right = last;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nodes[mid].num < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private class Node {

        // 当前节点值
        int num;
        // 以 当前节点 结束的最长递增子序列的长度
        int count;
        Node next;

        Node() {
            num = 0;
            count = 0;
            next = null;
        }

        Node(int num, int count, Node next) {
            this.num = num;
            this.count = count;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(new Solution2().findNumberOfLIS(nums));

        nums = new int[]{2, 2, 2, 2, 2};
        System.out.println(new Solution2().findNumberOfLIS(nums));
    }
}
