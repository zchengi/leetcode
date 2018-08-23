package _856_Score_of_Parentheses;

import java.util.Stack;

/**
 * LeetCode 856. Score of Parentheses
 *
 * @author cheng
 *         2018/08/23 13:55
 */
public class Solution1 {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {

            char c = S.charAt(i);
            if ('(' == c) {
                stack.push(-1);
            } else {
                int s = 0;
                while (stack.peek() != -1) {
                    s += stack.pop();
                }

                stack.pop();
                // 1. () 运算 优先级最高
                // 2. (()) 运算 优先级第二
                stack.push((s == 0) ? 1 : 2 * s);
            }
        }

        int res = 0;
        // ()() 运算 优先级第二
        // (()) ()() 同级 谁先结束就先运行谁
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {

        String S = "()";
        System.out.println(new Solution1().scoreOfParentheses(S));

        S = "(())";
        System.out.println(new Solution1().scoreOfParentheses(S));


        S = "()()";
        System.out.println(new Solution1().scoreOfParentheses(S));

        S = "(()(()))";
        System.out.println(new Solution1().scoreOfParentheses(S));

        S = "(())()";
        System.out.println(new Solution1().scoreOfParentheses(S));
    }
}
