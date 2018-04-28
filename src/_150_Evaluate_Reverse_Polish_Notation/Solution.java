package _150_Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

/**
 * LeetCode 150. Evaluate Reverse Polish Notation
 *
 * @author cheng
 *         2018/4/28 23:18
 */
public class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> numbers = new Stack<>();

        int num1, num2;
        for (String token : tokens) {

            switch (token) {
                case "+":
                    num1 = numbers.pop();
                    num2 = numbers.pop();
                    numbers.push(num2 + num1);
                    break;
                case "-":
                    num1 = numbers.pop();
                    num2 = numbers.pop();
                    numbers.push(num2 - num1);
                    break;
                case "*":
                    num1 = numbers.pop();
                    num2 = numbers.pop();
                    numbers.push(num2 * num1);
                    break;
                case "/":
                    num1 = numbers.pop();
                    num2 = numbers.pop();
                    numbers.push(num2 / num1);
                    break;
                default:
                    numbers.push(Integer.valueOf(token));
                    break;
            }
        }

        return numbers.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(new Solution().evalRPN(tokens));
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(new Solution().evalRPN(tokens2));
    }
}
