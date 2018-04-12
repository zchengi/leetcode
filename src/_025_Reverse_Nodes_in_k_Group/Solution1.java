package _025_Reverse_Nodes_in_k_Group;

import util.ListNode;

/**
 * LeetCode 025. Reverse Nodes in k-Group
 * <p>
 * 递归解法
 *
 * @author cheng
 *         2018/4/12 21:35
 */
public class Solution1 {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode cur = head;
        int count = 0;
        // 找到位于 k + 1 的结点
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }

        // 找到位于 k + 1 的结点
        if (count == k) {
            // 以k + 1节点为头的反向列表
            cur = reverseKGroup(cur, k);

            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;

            // 反转 current k-group
            while (count-- > 0) {
                // tmp - next head in direct part
                ListNode tmp = head.next;
                // preappending "direct" head to the reversed list
                head.next = cur;
                // move head of reversed part to a new node
                cur = head;
                // move "direct" head to the next node in direct part
                head = tmp;
            }
            head = cur;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(arr);
        int k = 2;
        System.out.println(new Solution1().reverseKGroup(listNode, k));
    }
}
