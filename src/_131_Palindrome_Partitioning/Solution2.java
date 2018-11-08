package _131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 131. Palindrome Partitioning
 *
 * @author cheng
 *         2018/11/8 11:35
 */
public class Solution2 {

    public List<List<String>> partition(String s) {

        if (s.isEmpty()) {
            return new ArrayList<>();
        }

        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();

        dfs(s, 0, cur, res);
        return res;
    }

    private void dfs(String s, int left, List<String> cur, List<List<String>> res) {

        if (left >= s.length()) {
            res.add(new ArrayList<>(cur));
        }

        for (int right = left; right < s.length(); right++) {
            String substring = s.substring(left, right + 1);
            if (isPalindrome(substring)) {
                cur.add(substring);
                dfs(s, right + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static void main(String[] args) {

        String s = "aab";
        System.out.println(new Solution2().partition(s));
    }
}
