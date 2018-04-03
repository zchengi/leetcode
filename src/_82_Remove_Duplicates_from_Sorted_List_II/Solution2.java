package _82_Remove_Duplicates_from_Sorted_List_II;

import util.ListNode;

/**
 * LeetCode 082. Remove Duplicates from Sorted List II
 * <p>
 * 使用虚拟头结点(改进版)
 * <p>
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 *
 * @author cheng
 *         2018/4/3 22:41
 */
public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = head;
        // 添加一个标记
        boolean flag = false;
        while (cur != null) {
            // 循环找出最后一个与 cur.val 相同的元素
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                flag = true;
            }

            if (flag) {
                pre.next = cur.next;
                flag = false;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 4, 5};
        ListNode listNode = new ListNode(arr);
        System.out.println(new Solution2().deleteDuplicates(listNode));
    }
}
