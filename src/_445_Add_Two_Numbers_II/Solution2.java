package _445_Add_Two_Numbers_II;

import util.ListNode;

/**
 * LeetCode 445. Add Two Numbers II
 * <p>
 * 参考 LeetCode 002. Add Two Numbers
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * @author cheng
 *         2018/3/27 22:12
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode c1 = reverse(l1);
        ListNode c2 = reverse(l2);
        ListNode sentinel = new ListNode(0);
        ListNode cur = sentinel;
        int sum = 0;

        while (c1 != null || c2 != null) {

            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }

            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;
        }

        if (sum != 0) cur.next = new ListNode(sum);
        return reverse(sentinel.next);
    }

    private static ListNode reverse(ListNode head) {

        if (head == null || head.next == null) return head;

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

        int[] arr1 = {7, 2, 4, 3};
        int[] arr2 = {5, 6, 4};
        ListNode l1 = new ListNode(arr1);
        ListNode l2 = new ListNode(arr2);

        System.out.println(new Solution2().addTwoNumbers(l1, l2));
    }
}
