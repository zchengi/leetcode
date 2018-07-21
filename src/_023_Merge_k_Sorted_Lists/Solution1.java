package _023_Merge_k_Sorted_Lists;

import util.ListNode;

/**
 * LeetCode 023. Merge k Sorted Lists
 * <p>
 * 暴力解法···
 *
 * @author cheng
 *         2018/7/21 19:50
 */
public class Solution1 {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummyHead = new ListNode(-1);
        ListNode tmp = dummyHead;
        int length = lists.length;
        boolean[] isEmpty = new boolean[length];

        for (; ; ) {

            for (int i = 0; i < length; i++) {
                if (lists[i] == null) {
                    isEmpty[i] = true;
                }
            }

            int count = 0;
            for (int i = 0; i < isEmpty.length; i++) {
                if (isEmpty[i]) {
                    count++;
                } else {
                    tmp.next = new ListNode(lists[i].val);
                    tmp = tmp.next;
                    break;
                }
            }

            if (count == length) {
                break;
            }

            for (int i = 0; i < length; i++) {
                if (!isEmpty[i]) {
                    if (tmp.val > lists[i].val) {
                        tmp.val = lists[i].val;
                    }
                }
            }

            for (int i = 0; i < length; i++) {
                if (!isEmpty[i] && lists[i].val == tmp.val) {
                    lists[i] = lists[i].next;
                    break;
                }
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

        ListNode[] listNodes = {new ListNode(new int[]{1, 4, 5}),
                new ListNode(new int[]{1, 3, 4}),
                new ListNode(new int[]{2, 6})};

        System.out.println(new Solution1().mergeKLists(listNodes));
    }
}
