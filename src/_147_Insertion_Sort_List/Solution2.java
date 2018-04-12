package _147_Insertion_Sort_List;

import util.ListNode;

/**
 * LeetCode 147. Insertion Sort List
 * <p>
 * Solution1的优化版本
 *
 * @author cheng
 *         2018/4/12 22:36
 */
public class Solution2 {
    public ListNode insertionSortList(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;

        while (head != null) {
            ListNode next = head.next;

            // 这里判断 pre 是否大于 head，如果大于，才将 pre 置为 dummyHead
            if (pre.val >= head.val) pre = dummyHead;

            // 从头开始判断当前结点该插入的位置
            while (pre.next != null && pre.next.val < head.val) {
                pre = pre.next;
            }

            // 插入当前结点
            head.next = pre.next;
            pre.next = head;
            head = next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5, 2, 1};
        ListNode listNode = new ListNode(arr);
        System.out.println(new Solution2().insertionSortList(listNode));
    }
}
