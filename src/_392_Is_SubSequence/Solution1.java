package _392_Is_SubSequence;

/**
 * LeetCode 392. Is SubSequence
 *
 * @author cheng
 *         2019/1/12 14:52
 */
public class Solution1 {
    public boolean isSubSequence(String s, String t) {

        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {

        String s = "abc";
        String t = "ahbgdc";
        System.out.println(new Solution1().isSubSequence(s, t));

        s = "axc";
        System.out.println(new Solution1().isSubSequence(s, t));
    }
}
