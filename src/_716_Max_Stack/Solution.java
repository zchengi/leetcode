package _716_Max_Stack;

import java.util.Stack;

/**
 * LeetCode 716. Max Stack
 * <p>
 * 使用两个 stack
 * <p>
 * 时间复杂度：push:O(1)、pop:O(1)、peek:O(1)、peekMax:O(1)、popMax:O(n)
 * 空间复杂度：O(n)
 * <p>
 * 分析：
 * We have one regular stack for push, pop and peek operations
 * We have another stack for peekMax and popMax operations, which named maxStack
 * maxStack will store the current max value in the stack for popMax,
 * we will find the max value in the stack in O(n) time
 *
 * @author cheng
 *         2018/3/23 17:22
 */
public class Solution {

    private static class MaxStack {
        private Stack<Integer> normalStack;
        private Stack<Integer> maxStack;

        public MaxStack() {
            normalStack = new Stack<>();
            maxStack = new Stack<>();
        }

        public void push(int x) {
            normalStack.push(x);
            if (maxStack.isEmpty()) {
                maxStack.push(x);
            } else {
                maxStack.push(Math.max(maxStack.peek(), x));
            }
        }

        public int pop() {
            if (normalStack.size() <= 0) {
                return -1;
            }

            maxStack.pop();
            return normalStack.pop();
        }

        public int peek() {
            if (normalStack.size() <= 0) {
                return -1;
            }

            return normalStack.peek();
        }

        public int peekMax() {
            if (normalStack.size() <= 0) {
                return -1;
            }

            return maxStack.peek();
        }

        public int popMax() {
            if (normalStack.size() <= 0) {
                return -1;
            }

            int maxValue = peekMax();
            Stack<Integer> tstack = new Stack<>();

            while (true) {
                int value = pop();

                if (value == maxValue) {
                    break;
                }

                tstack.push(value);
            }

            while (!tstack.isEmpty()) {
                push(tstack.pop());
            }

            return maxValue;
        }
    }

    public static void main(String[] args) {

        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(5);

        System.out.println(stack.peek());
        System.out.println(stack.popMax());
        System.out.println(stack.peek());
        System.out.println(stack.peekMax());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        System.out.println();

        MaxStack stack2 = new MaxStack();
        stack2.push(-83);
        stack2.push(-1);
        stack2.push(98);
        stack2.push(38);
        stack2.push(-99);
        System.out.println(stack2.peek());
        System.out.println(stack2.popMax());
        System.out.println(stack2.popMax());
        stack2.push(-92);
        stack2.push(-17);
        stack2.push(-1);
        stack2.push(-74);
        System.out.println(stack2.popMax());
        System.out.println(stack2.pop());
        System.out.println(stack2.popMax());
        stack2.push(-80);
        stack2.push(-13);
        System.out.println(stack2.peek());
        stack2.push(-25);
    }
}