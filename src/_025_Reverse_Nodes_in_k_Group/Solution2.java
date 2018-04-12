package _025_Reverse_Nodes_in_k_Group;

import util.ListNode;

/**
 * LeetCode 025. Reverse Nodes in k-Group
 * <p>
 * 迭代解法
 *
 * @author cheng
 *         2018/4/12 21:35
 */
public class Solution2 {
    public ListNode reverseKGroup(ListNode head, int k) {

        int count = 0;
        ListNode tmp = head;
        // 计算出结点个数
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }

        // 设定虚拟头结点
        ListNode dummyNode = new ListNode(0);
        // next 指向 head
        dummyNode.next = head;

        // 反转每一组链表 如果当前组结点小于 k，结束循环
        for (ListNode prev = dummyNode, tail = head; count >= k; count -= k) {
            // 反转链表
            for (int i = 1; i < k; i++) {
                ListNode next = tail.next.next;
                tail.next.next = prev.next;
                prev.next = tail.next;
                tail.next = next;
            }

            prev = tail;
            tail = tail.next;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(arr);
        int k = 2;
        System.out.println(new Solution2().reverseKGroup(listNode, k));
    }
}
