package _155_Min_Stack;

/**
 * LeetCode 155. Min Stack
 * 使用自定义数据类型 Node
 * 另一种版本
 *
 * @author cheng
 *         2018/3/23 16:59
 */
public class Solution3 {
    private static class MinStack {

        private Node head;
        private int min;

        private class Node {
            int value;
            Node next;

            public Node(int value) {
                this.value = value;
            }
        }

        public MinStack() {
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if (head == null) {
                head = new Node(x);
                min = x;
            } else {
                if (x <= min) {
                    Node minNode = new Node(min);
                    minNode.next = head;
                    head = minNode;
                    min = x;
                }

                Node current = new Node(x);
                current.next = head;
                head = current;
            }
        }

        public void pop() {
            if (head != null) {
                if (min == head.value && head.next != null) {
                    min = head.next.value;
                    head = head.next.next;
                } else {
                    head = head.next;
                }
            }
        }

        public int top() {
            if (head != null) {
                return head.value;
            }

            return -1;
        }

        public int getMin() {
            return min;
        }
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());

        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());

        minStack.pop();
        System.out.println(minStack.getMin());

        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());
    }


}
