package _784_letter_case_permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 784. letter-case-permutation
 *
 * @author cheng
 *         2018/11/15 14:33
 */
public class Solution2 {

    public List<String> letterCasePermutation(String S) {

        List<String> res = new ArrayList<>();

        char[] chars = S.toCharArray();
        dfs(res, chars, 0);
        return res;
    }

    private void dfs(List<String> res, char[] chars, int count) {

        res.add(new String(chars));

        for (int i = count; i < chars.length; i++) {
            char c = chars[i];

            if (c <= 'z' && c >= 'a') {
                chars[i] = (char) (c - 'a' + 'A');
                dfs(res, chars, i + 1);
                chars[i] = c;
            } else if (c >= 'A' && c <= 'Z') {
                chars[i] = (char) (c - 'A' + 'a');
                dfs(res, chars, i + 1);
                chars[i] =c;
            }
        }
    }

    public static void main(String[] args) {

        String s = "a1b2";
        System.out.println(new Solution2().letterCasePermutation(s));

        s = "3z4";
        System.out.println(new Solution2().letterCasePermutation(s));

        s = "12345";
        System.out.println(new Solution2().letterCasePermutation(s));
    }
}
