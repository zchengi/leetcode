package _155_Min_Stack;

/**
 * LeetCode 155. Min Stack
 * 使用自定义数据类型 Node
 *
 * @author cheng
 *         2018/3/23 16:52
 */
public class Solution2 {
    private static class MinStack {

        private Node head;

        private class Node {
            int value;
            int min;
            Node next;

            public Node(int value, int min) {
                this.value = value;
                this.min = min;
            }
        }

        public MinStack() {
        }

        public void push(int x) {
            if (head == null) {
                head = new Node(x, x);
            } else {
                Node current = new Node(x, Math.min(x, head.min));
                current.next = head;
                head = current;
            }
        }

        public void pop() {
            if (head != null) {
                head = head.next;
            }
        }

        public int top() {
            if (head != null) {
                return head.value;
            }

            return -1;
        }

        public int getMin() {
            if (head != null) {
                return head.min;
            }

            return -1;
        }
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }


}
