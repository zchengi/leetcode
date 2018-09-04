package _028_Implement_strStr;

/**
 * LeetCode 028. Implement strStr()
 *
 * @author cheng
 *         2018/09/04 16:20
 */
public class Solution1 {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }

                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        String haystack = "sss";
        String needle = "s";
        System.out.println(new Solution1().strStr(haystack, needle));
    }
}
