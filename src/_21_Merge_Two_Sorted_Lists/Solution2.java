package _21_Merge_Two_Sorted_Lists;

import util.ListNode;

/**
 * LeetCode 21. Merge Two Sorted Lists
 * <p>
 * 归并排序的 merge 思想
 * <p>
 * 时间复杂度：O(n + m)
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/4/3 22:58
 */
public class Solution2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        ListNode l1 = new ListNode(arr1);
        ListNode l2 = new ListNode(arr2);
        System.out.println(new Solution2().mergeTwoLists(l1, l2));
    }
}
