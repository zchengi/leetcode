package _856_Score_of_Parentheses;

/**
 * LeetCode 856. Score of Parentheses
 *
 * @author cheng
 *         2018/08/23 13:52
 */
public class Solution3 {
    public int scoreOfParentheses(String S) {

        int res = 0;
        int layers = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                layers++;
            } else {
                layers--;
            }

            if (S.charAt(i) == '(' && S.charAt(i + 1) == ')') {
                res += 1 << (layers - 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        String S = "()";
        System.out.println(new Solution3().scoreOfParentheses(S));

        S = "(())";
        System.out.println(new Solution3().scoreOfParentheses(S));


        S = "()()";
        System.out.println(new Solution3().scoreOfParentheses(S));

        S = "(()(()))";
        System.out.println(new Solution3().scoreOfParentheses(S));

        S = "(())()";
        System.out.println(new Solution3().scoreOfParentheses(S));
    }
}
