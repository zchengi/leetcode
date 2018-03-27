package _445_Add_Two_Numbers_II;

import util.ListNode;

import java.util.Stack;

/**
 * LeetCode 445. Add Two Numbers II
 *
 * @author cheng
 *         2018/3/27 21:55
 */
public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }

            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }

        return list.val == 0 ? list.next : list;
    }

    public static void main(String[] args) {

        int[] arr1 = {7, 2, 4, 3};
        int[] arr2 = {5, 6, 4};
        ListNode l1 = new ListNode(arr1);
        ListNode l2 = new ListNode(arr2);

        System.out.println(new Solution1().addTwoNumbers(l1, l2));
    }
}
