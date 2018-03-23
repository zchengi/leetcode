package _155_Min_Stack;

import java.util.Stack;

/**
 * LeetCode 155. Min Stack
 * 使用 java 的 stack
 *
 * @author cheng
 *         2018/3/23 16:26
 */
public class Solution1 {
    private static class MinStack {

        private int min ;
        private Stack<Integer> stack;

        public MinStack() {
            stack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            // 如果当前值 x 小于等于最小值 min
            // 则 将前一个最小值推入栈中，这样在删除最小值后，还能可以找到上一个最小值
            if (x <= min) {
                stack.push(min);
                min = x;
            }
            // 将当前值推入栈中
            stack.push(x);
        }

        public void pop() {
            // 如果当前值是最小值
            // 则删除当前值后的栈顶元素为新的最小值
            // 删除当前最小值，然后更新最小值为新值
            if (stack.peek() == min) {
                stack.pop();
                min = stack.pop();
            } else {
                stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
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
