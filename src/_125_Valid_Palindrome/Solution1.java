package _125_Valid_Palindrome;

/**
 * LeetCode 125. Valid Palindrome
 *
 * @author cheng
 *         2018/3/8 19:17
 */
public class Solution1 {
    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        s = s.toLowerCase();
        String pattern = "[a-z0-9]";

        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !String.valueOf(s.charAt(l)).matches(pattern)) {
                l++;
            }

            while (l < r && !String.valueOf(s.charAt(r)).matches(pattern)) {
                r--;
            }
            if (l < r) {
                System.out.println(s.charAt(l) + "-" + s.charAt(r));
                if (!(s.charAt(l) == s.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            } else if (l == r) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        // race a car
        String str = "A man, a plan, a canal Panama";

        System.out.println(new Solution1().isPalindrome(str));
    }
}
