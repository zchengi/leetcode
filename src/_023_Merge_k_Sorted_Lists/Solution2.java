package _023_Merge_k_Sorted_Lists;

import util.ListNode;

/**
 * LeetCode 023. Merge k Sorted Lists
 * <p>
 * 多路归并排序思想：
 * -        两两归并，依次归并完所有数组，运用递归
 *
 * @author cheng
 *         2018/7/21 20:51
 */
public class Solution2 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start < end) {
            int mid = (end - start) / 2 + start;

            ListNode left = mergeKLists(lists, start, mid);
            ListNode right = mergeKLists(lists, mid + 1, end);
            // 两两归并
            return mergeTwoLists(left, right);
        } else {
            return null;
        }
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(-1);
        ListNode tmp = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = l1 == null ? l2 : l1;

        return dummyHead.next;
    }

    public static void main(String[] args) {

        ListNode[] listNodes = {new ListNode(new int[]{1, 4, 5}),
                new ListNode(new int[]{1, 3, 4}),
                new ListNode(new int[]{2, 6})};

        System.out.println(new Solution2().mergeKLists(listNodes));
    }
}
