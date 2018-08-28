package _005_Longest_Palindromic_Substring;

/**
 * LeetCode 005. Longest Palindromic Substring
 *
 * @author cheng
 *         2018/08/28 14:23
 */
public class Solution2 {

    public String longestPalindrome(String s) {

        char[] ca = s.toCharArray();
        int rs = 0;
        int re = 0;
        int max = 0;

        for (int i = 0; i < ca.length; i++) {
            if (isPalindrome(ca, i - max - 1, i)) {
                rs = i - max - 1;
                re = i;
                max += 2;
            } else if (isPalindrome(ca, i - max, i)) {
                rs = i - max;
                re = i;
                max += 1;
            }
        }

        return s.substring(rs, re + 1);
    }

    private boolean isPalindrome(char[] ca, int s, int e) {

        if (s < 0) {
            return false;
        }

        while (s < e) {
            if (ca[s++] != ca[e--]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "babad";
        System.out.println(new Solution2().longestPalindrome(s));

        s = "cbbd";
        System.out.println(new Solution2().longestPalindrome(s));
    }
}
