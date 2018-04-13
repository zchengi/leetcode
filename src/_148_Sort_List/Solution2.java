package _148_Sort_List;

import util.ListNode;

/**
 * LeetCode 148. Sort List
 * <p>
 * 自底向上的归并排序实现
 *
 * @author cheng
 *         2018/4/13 11:44
 */
public class Solution2 {

    ListNode dummyRes = new ListNode(0);

    private class MergeResult {
        ListNode head;
        ListNode tail;

        public MergeResult(ListNode head, ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        int length = length(head);

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        MergeResult mr = new MergeResult(null, null);

        for (int step = 1; step < length; step <<= 1) {
            ListNode left = dummy.next;
            ListNode prev = dummy;
            while (left != null) {
                ListNode right = split(left, step);
                if (right == null) {
                    prev.next = left;
                    break;
                }

                ListNode next = split(right, step);
                merge(left, right, mr);
                prev.next = mr.head;
                prev = mr.tail;
                left = next;
            }
        }

        return dummy.next;
    }

    private void merge(ListNode head1, ListNode head2, MergeResult mr) {
        if (head2 == null) {
            mr.head = head1;
            mr.tail = null;
        }

        ListNode res = dummyRes;
        ListNode tail = res;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }

            tail = tail.next;
        }

        while (head1 != null) {
            tail.next = head1;
            head1 = head1.next;
            tail = tail.next;
        }

        while (head2 != null) {
            tail.next = head2;
            head2 = head2.next;
            tail = tail.next;
        }

        mr.head = res.next;
        mr.tail = tail;
    }


    public ListNode split(ListNode head, int step) {
        while (head != null && step != 1) {
            head = head.next;
            step--;
        }

        if (head == null) {
            return null;
        }

        ListNode res = head.next;
        head.next = null;
        return res;
    }

    private int length(ListNode listNode) {
        int len = 0;
        while (listNode != null) {
            listNode = listNode.next;
            len++;
        }
        return len;
    }


    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5, 2, 1};
        ListNode listNode = new ListNode(arr);
        System.out.println(new Solution2().sortList(listNode));
    }
}
