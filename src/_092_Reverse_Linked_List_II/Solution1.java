package _092_Reverse_Linked_List_II;

/**
 * LeetCode 092. Reverse Linked List II
 * <p>
 * 分析：start：第一个要反转的元素，每次取出下一个元素，将其放到 pre 之后，然后更新 then 的值为 start 的下一个元素，循环；
 * 结束条件为需要反转的次数 反转索引 n - m；
 *
 * @author cheng
 *         2018/3/25 16:47
 */
public class Solution1 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }

        @Override
        public String toString() {
            ListNode list = this;
            StringBuilder builder = new StringBuilder();
            while (list != null) {
                builder.append(list.val).append(" ");
                list = list.next;
            }
            return builder.toString();
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0, null);
        dummy.next = head;

        // pre：要反转的元素的前一个元素
        ListNode pre = dummy;
        // m-1：循环结束条件找到开始索引的前一个索引
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        // first：从 first 元素开始反转
        ListNode first = pre.next;
        // then：first 元素的下一个元素
        ListNode then = first.next;

        // n-m：循环结束条件要反转的次数
        for (int i = 0; i < n - m; i++) {
            // 当前结点的 next 指向 then 的 next
            first.next = then.next;
            // then 的 next 指向 pre 的 next
            then.next = pre.next;
            // pre 的 next 指向 then（交换完毕）
            pre.next = then;
            // 更新新的 then 值
            then = first.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        int m = 2;
        int n = 4;
        System.out.println("未反转：" + listNode);
//        System.out.println(new Solution1().reverseBetween(listNode, m, n));

        listNode = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        System.out.println(new Solution1().reverseBetween(listNode, 1, 5));

    }
}
