package _392_Is_SubSequence;

/**
 * LeetCode 392. Is SubSequence
 *
 * @author cheng
 *         2019/1/12 14:52
 */
public class Solution2 {
    public boolean isSubSequence(String s, String t) {

        if (s == null || s.length() == 0) {
            return true;
        }

        int index = 0;

        for (char ss : s.toCharArray()) {
            // t 从索引 0 开始找字符 ss
            index = t.indexOf(ss, index);
            if (index == -1) {
                return false;
            }

            index++;
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "abc";
        String t = "ahbgdc";
        System.out.println(new Solution2().isSubSequence(s, t));

        s = "axc";
        System.out.println(new Solution2().isSubSequence(s, t));
    }
}
