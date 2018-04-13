package _148_Sort_List;

import util.ListNode;

/**
 * LeetCode 148. Sort List
 * <p>
 * 自顶向下的归并排序实现
 *
 * @author cheng
 *         2018/4/13 11:44
 */
public class Solution1 {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // 将链表切分为两半
        ListNode pre = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        // 将切分后的两部分链表再切分
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);


        // 将 l1 与 l2 归并
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }

            pre = pre.next;
        }

        if (l1 != null) {
            pre.next = l1;
        }

        if (l2 != null) {
            pre.next = l2;
        }

        return dummyHead.next;
    }


    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5, 2, 1};
        ListNode listNode = new ListNode(arr);
        System.out.println(new Solution1().sortList(listNode));
    }
}
