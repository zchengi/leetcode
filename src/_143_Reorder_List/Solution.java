package _143_Reorder_List;

import util.ListNode;

/**
 * LeetCode 143. Reorder List
 *
 * @author cheng
 *         2018/4/17 22:24
 */
public class Solution {
    public void reorderList(ListNode head) {

        if (head == null) {
            return;
        }

        // 找到中间结点 slow
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;

        // 这里是创建一个新的 slow，开辟新空间
        ListNode temp = slow.next;
        slow.next = null;
        slow = temp;
        // 反转后半部分
        slow = reverseList(slow);

        // merge 链表
        while (slow != null) {
            ListNode nextSlow = slow.next;
            slow.next = fast.next;
            fast.next = slow;
            fast = slow.next;
            slow = nextSlow;
        }
    }

    private ListNode reverseList(ListNode head) {

        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode listNode = new ListNode(arr);
        new Solution().reorderList(listNode);
        System.out.println(listNode);
    }
}
