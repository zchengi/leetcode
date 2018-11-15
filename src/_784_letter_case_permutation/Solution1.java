package _784_letter_case_permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 784. letter-case-permutation
 *
 * @author cheng
 *         2018/11/15 14:01
 */
public class Solution1 {

    private List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {

        if (S.isEmpty()) {
            res.add("");
            return res;
        }

        S = S.toLowerCase();
        dfs(S, "", 0);
        return res;
    }

    private void dfs(String s, String cur, int index) {

        if (cur.length() == s.length()) {
            res.add(cur);
            return;
        }

        char c = s.charAt(index);

        if (c >= 48 && c <= 57) {
            dfs(s, cur + String.valueOf(c), index + 1);
        } else {
            dfs(s, cur + String.valueOf(c), index + 1);
            c = (char) (c - 32);
            dfs(s, cur + String.valueOf(c), index + 1);
        }
    }

    public static void main(String[] args) {

        String s = "a1b2";
        System.out.println(new Solution1().letterCasePermutation(s));

        s = "3z4";
        System.out.println(new Solution1().letterCasePermutation(s));

        s = "12345";
        System.out.println(new Solution1().letterCasePermutation(s));
    }
}
