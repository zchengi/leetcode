package _061_Rotate_List;

import util.ListNode;

/**
 * LeetCode 061. Rotate List
 *
 * @author cheng
 *         2018/4/17 21:40
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return head;
        }

        ListNode fast = head, slow = head;

        // 因为从头结点开始，所以从1开始
        int count = 1;
        // 计算所有结点数
        while (fast.next != null) {
            count++;
            fast = fast.next;
        }

        // 找到要右移的结点的前一个结点
        //  i > 1 因为从1开始计数的
        for (int i = count - k % count; i > 1; i--) {
            slow = slow.next;
        }

        // 最后一个结点的下一个结点指向头结点
        fast.next = head;
        // 头结点移动到右移后的新头结点
        head = slow.next;
        // 删除要移动的结点
        slow.next = null;

        return head;
    }

    public static void main(String[] args) {
        int k = 2;
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(arr);
        System.out.println(new Solution().rotateRight(listNode, k));
    }
}
