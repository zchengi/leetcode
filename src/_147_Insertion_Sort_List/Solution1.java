package _147_Insertion_Sort_List;

import util.ListNode;

/**
 * LeetCode 147. Insertion Sort List
 *
 * @author cheng
 *         2018/4/12 22:36
 */
public class Solution1 {
    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        ListNode cur = head;

        // 当前结点不为空
        while (cur != null) {
            ListNode next = cur.next;

            // 从头开始判断当前结点该插入的位置
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }

            // 插入当前结点
            cur.next = pre.next;
            pre.next = cur;
            pre = dummyHead;
            cur = next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5, 2, 1};
        ListNode listNode = new ListNode(arr);
        System.out.println(new Solution1().insertionSortList(listNode));
    }
}
