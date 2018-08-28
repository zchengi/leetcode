package _005_Longest_Palindromic_Substring;

/**
 * LeetCode 005. Longest Palindromic Substring
 *
 * @author cheng
 *         2018/08/28 13:56
 */
public class Solution1 {

    private int lo;

    private int maxLength;

    public String longestPalindrome(String s) {

        int len = s.length();
        if (len < 2) {
            return s;
        }

        for (int i = 0; i < len - 1; i++) {
            // assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i);
            // assume even length
            extendPalindrome(s, i, i + 1);
        }

        return s.substring(lo, lo + maxLength);
    }

    private void extendPalindrome(String s, int j, int k) {

        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        if (maxLength < k - j - 1) {
            lo = j + 1;
            maxLength = k - j - 1;
        }
    }

    public static void main(String[] args) {

        String s = "babad";
        System.out.println(new Solution1().longestPalindrome(s));

        s = "cbbd";
        System.out.println(new Solution1().longestPalindrome(s));
    }
}
