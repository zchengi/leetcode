package _125_Valid_Palindrome;

/**
 * LeetCode 125. Valid Palindrome
 *
 * @author cheng
 *         2018/3/8 19:17
 */
public class Solution3 {
    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char lc = s.charAt(start);
            char rc = s.charAt(end);
            if ((lc < 65 || lc > 90) && (lc < 97 || lc > 122) && (lc < 48 || lc > 57)) {
                start++;
                continue;
            }

            if ((rc < 65 || rc > 90) && (rc < 97 || rc > 122) && (rc < 48 || rc > 57)) {
                end--;
                continue;
            }
            if (lc != rc) { // Mean either a is upper case or a is lower case
                if (lc >= 65 && lc <= 90) {
                    return (lc - 'A') == (rc - 'a');
                    // if a is upper case then substract a from A which will give you [0-26]
                    // and substract rc from lower case which will also give you [0-26]
                }
                if (lc >= 97 && lc <= 122) {
                    return (lc - 'a') == (rc - 'A');
                    // if lc is lower case then substract lc from a(109) which will give you [0-26]
                    // and substract rc from uppercase A(65) which will also give you [0-26]
                }
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        // race a car
        String str = "A man, a plan, a canal Panama";

        System.out.println(new Solution3().isPalindrome(str));
    }
}
