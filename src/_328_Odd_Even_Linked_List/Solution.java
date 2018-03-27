package _328_Odd_Even_Linked_List;

import util.ListNode;

/**
 * LeetCode 328. Odd Even Linked List
 * <p>
 * 参考 LeetCode 086. Partition List
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/3/27 21:02
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null) return null;

        ListNode odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 4, 3, 6, 5, 7, 8};
        ListNode listNode = new ListNode(arr);
        System.out.println(new Solution().oddEvenList(listNode));
    }
}
