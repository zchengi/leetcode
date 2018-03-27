package _086_Partition_List;

import util.ListNode;

/**
 * LeetCode 086. Partition List
 * <p>
 * 分析：将链表分成两个不同的链表，一个小于x的所有元素，一个大于x，然后合并即可；
 *
 * @author cheng
 *         2018/3/27 20:44
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0), right = new ListNode(0);
        ListNode leftCurr = left, rightCurr = right;

        while (head != null) {
            if (head.val < x) {
                leftCurr.next = new ListNode(head.val);
                leftCurr = leftCurr.next;
            } else {
                rightCurr.next = new ListNode(head.val);
                rightCurr = rightCurr.next;
            }
            head = head.next;
        }
        leftCurr.next = right.next;

        return left.next;
    }

    public static void main(String[] args) {

        int[] arr = {1, 4, 3, 2, 5, 2};
        ListNode listNode = new ListNode(arr);
        int x = 3;
        System.out.println(new Solution().partition(listNode, x));
    }
}
