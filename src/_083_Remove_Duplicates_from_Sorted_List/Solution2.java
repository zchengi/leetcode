package _083_Remove_Duplicates_from_Sorted_List;

import util.ListNode;

/**
 * LeetCode 083. Remove Duplicates from Sorted List
 * <p>
 * 递归解法
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * @author cheng
 *         2018/3/25 23:29
 */
public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);

        return head.val == head.next.val ? head.next : head;
        /*if (head.val == head.next.val) {
            return head.next;
        } else {
            return head;
        } */
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 2};
        ListNode listNode = new ListNode(arr);
        System.out.println(new Solution2().deleteDuplicates(listNode));

        int[] arr2 = {1, 1, 2, 3, 3};
        ListNode listNode2 = new ListNode(arr2);
        System.out.println(new Solution2().deleteDuplicates(listNode2));
    }
}
