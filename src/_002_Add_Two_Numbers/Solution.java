package _002_Add_Two_Numbers;

import util.ListNode;

/**
 * LeetCode 002. Add Two Numbers
 *
 * @author cheng
 *         2018/3/27 21:27
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode cur = sentinel;
        int sum = 0;

        while (c1 != null || c2 != null) {
            sum /= 10;

            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }

            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }

        if (sum / 10 == 1) {
            cur.next = new ListNode(1);
        }

        return sentinel.next;
    }

    public static void main(String[] args) {

        int[] arr1 = {2, 4, 3};
        int[] arr2 = {5, 6, 4};
        ListNode l1 = new ListNode(arr1);
        ListNode l2 = new ListNode(arr2);

        System.out.println(new Solution().addTwoNumbers(l1, l2));
    }
}
