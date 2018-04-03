package _082_Remove_Duplicates_from_Sorted_List_II;

import util.ListNode;

/**
 * LeetCode 082. Remove Duplicates from Sorted List II
 * <p>
 * 使用虚拟头结点
 * <p>
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 *
 * @author cheng
 *         2018/4/3 22:11
 */
public class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = head;
        while (cur != null) {
            // 循环找出最后一个与 cur.val 相同的元素
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            // 判断 pre.next 是否是 cur 元素
            if (pre.next == cur) {
                // 相等：则证明 cur.val 只出现一次
                pre = cur;
            } else {
                // 不相等：则证明 cur.val 出现不止一次，且当前 cur 为最后一次出现的位置
                // 更新 pre.next 的指向
                pre.next = cur.next;
            }
            cur = cur.next;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 4, 5};
        ListNode listNode = new ListNode(arr);
        System.out.println(new Solution1().deleteDuplicates(listNode));
    }
}
