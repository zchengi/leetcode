package _856_Score_of_Parentheses;

/**
 * LeetCode 856. Score of Parentheses
 *
 * @author cheng
 *         2018/08/23 13:52
 */
public class Solution2 {
    public int scoreOfParentheses(String S) {

        int[] res = new int[30];
        int i = 0;

        for (char c : S.toCharArray()) {
            if ('(' == c) {
                res[++i] = 0;
            } else {
                res[i - 1] += Math.max(res[i--] * 2, 1);
            }
        }

        return res[0];
    }

    public static void main(String[] args) {

        String S = "()";
        System.out.println(new Solution2().scoreOfParentheses(S));

        S = "(())";
        System.out.println(new Solution2().scoreOfParentheses(S));


        S = "()()";
        System.out.println(new Solution2().scoreOfParentheses(S));

        S = "(()(()))";
        System.out.println(new Solution2().scoreOfParentheses(S));

        S = "(())()";
        System.out.println(new Solution2().scoreOfParentheses(S));
    }
}
