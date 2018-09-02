package _014_Longest_Common_Prefix;

/**
 * LeetCode 014. Longest Common Prefix
 *
 * @author cheng
 *         2018/9/2 15:33
 */
public class Solution2 {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String res = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {

        String[] strs = {"dog", "racecar", "car"};
        System.out.println(new Solution2().longestCommonPrefix(strs));

        strs = new String[]{"flower", "flow", "flight"};
        System.out.println(new Solution2().longestCommonPrefix(strs));
    }
}
