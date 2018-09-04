package _028_Implement_strStr;

/**
 * LeetCode 028. Implement strStr()
 *
 * @author cheng
 *         2018/09/04 16:42
 */
public class Solution2 {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {

        String haystack = "hello";
        String needle = "ll";
        System.out.println(new Solution2().strStr(haystack, needle));
    }
}
