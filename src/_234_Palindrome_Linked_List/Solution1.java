package _234_Palindrome_Linked_List;

import util.ListNode;

/**
 * LeetCode 234. Palindrome Linked List
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/4/18 23:08
 */
public class Solution1 {
    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }

        // reverse 为前半部分的反转链表
        ListNode slow = head, fast = head, reverse = null;
        while (fast != null && fast.next != null) {
            ListNode temp = reverse;
            reverse = slow;
            slow = slow.next;
            fast = fast.next.next;
            reverse.next = temp;
        }

        // 如果传入的链表是奇数个，则去除中间元素不判断
        if (fast != null) {
            // slow 指向了后半部分
            slow = slow.next;
        }

        // 判断前半部分反转链表与后半部分是否相同
        while (reverse != null) {
            if (slow.val != reverse.val) {
                return false;
            }

            slow = slow.next;
            reverse = reverse.next;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1};
        ListNode head = new ListNode(arr);
        System.out.println(new Solution1().isPalindrome(head));
    }
}