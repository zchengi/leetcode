package _131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 131. Palindrome Partitioning
 *
 * 运行效率: Solution1 > Solution2
 * @author cheng
 *         2018/11/8 10:56
 */
public class Solution1 {

    private List<List<String>> res = new ArrayList<>();
    private List<String> cur = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int l) {

        // the initial str could be palindrome
        if (cur.size() > 0 && l >= s.length()) {
            res.add(new ArrayList<>(cur));
        }

        for (int r = l; r < s.length(); r++) {
            if (isPalindrome(s, l, r)) {
                // 添加当前字符串到结果集
                cur.add(s.substring(l, r + 1));
                // 继续递归遍历
                dfs(s, r + 1);
                // 删除之前添加的字符串
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int l, int r) {

        if (l == r) {
            return true;
        }

        for (; l < r; l++, r--) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "aab";
        System.out.println(new Solution1().partition(s));
    }
}
