package _438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 438. Find All Anagrams in a String
 * <p>
 * 滑动窗口
 * 使用while循环
 * <p>
 * 时间复杂度：O(len(p)+len(s))
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/3/12 19:58
 */
public class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return res;
        }

        int[] freq_p = new int[26];
        for (char c : p.toCharArray()) {
            freq_p[c - 'a']++;
        }

        int l = 0, r = 0, count = p.length();
        while (r < s.length()) {
            // If the char at start appeared in p, we increase count
            if (r - l == p.length() && freq_p[s.charAt(l++) - 'a']++ >= 0) {
                count++;
            }
            // If the char at end appeared in p (since it's not -1 after decreasing), we decrease count
            if (--freq_p[s.charAt(r++) - 'a'] >= 0) {
                count--;
            }

            if (count == 0) res.add(l);
        }

        return res;
    }

    public static void main(String[] args) {
        String s1 = "cbaebabacd";
        String p1 = "abc";
        System.out.println(new Solution2().findAnagrams(s1, p1));

        String s2 = "abab";
        String p2 = "ab";
        System.out.println(new Solution2().findAnagrams(s2, p2));
    }
}
