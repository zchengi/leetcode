package _014_Longest_Common_Prefix;

/**
 * LeetCode 014. Longest Common Prefix
 *
 * @author cheng
 *         2018/9/2 15:17
 */
public class Solution1 {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (minLength > str.length()) {
                minLength = str.length();
            }
        }

        for (int i = 0; i < minLength; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    return builder.toString();
                }
            }
            builder.append(c);
        }

        return builder.toString();
    }

    public static void main(String[] args) {

        String[] strs = {"dog", "racecar", "car"};
        System.out.println(new Solution1().longestCommonPrefix(strs));

        strs = new String[]{"flower", "flow", "flight"};
        System.out.println(new Solution1().longestCommonPrefix(strs));
    }
}
