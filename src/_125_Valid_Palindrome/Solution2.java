package _125_Valid_Palindrome;

/**
 * LeetCode 125. Valid Palindrome
 *
 * @author cheng
 *         2018/3/8 19:17
 */
public class Solution2 {
    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char lc = 0;
            char rc = 0;

            while (start <= end && (lc = getChar(s, start)) == 0) {
                start++;
            }

            while (end >= start && (rc = getChar(s, end)) == 0) {
                end--;
            }
            if (lc != rc) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    private char getChar(String s, int index) {

        char ch = s.charAt(index);
        if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
            return ch;
        } else if (ch >= 'A' && ch <= 'Z') {
            return (char) (ch - 'A' + 'a');
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

        // race a car
        String str = "A man, a plan, a canal Panama";

        System.out.println(new Solution2().isPalindrome(str));
    }
}
