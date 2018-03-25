package _083_Remove_Duplicates_from_Sorted_List;

import util.ListNode;

/**
 * LeetCode 083. Remove Duplicates from Sorted List
 * <p>
 * Straight-Forward Approach
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/3/25 23:09
 */
public class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 2};
        ListNode listNode = new ListNode(arr);
        System.out.println(new Solution1().deleteDuplicates(listNode));

        int[] arr2 = {1, 1, 2, 3, 3};
        ListNode listNode2 = new ListNode(arr2);
        System.out.println(new Solution1().deleteDuplicates(listNode2));
    }
}
