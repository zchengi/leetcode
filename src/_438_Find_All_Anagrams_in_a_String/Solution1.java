package _438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 438. Find All Anagrams in a String
 * <p>
 * 滑动窗口
 * <p>
 * 时间复杂度：O(len(p)+len(s))
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/3/12 19:38
 */
public class Solution1 {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }
        if (p.length() <= 0) throw new IllegalArgumentException("p can not be null");

        // 记录p中每个字母出现的次数
        int[] freq_p = new int[26];

        for (int i = 0; i < p.length(); i++) {
            freq_p[p.charAt(i) - 'a'] += 1;
        }

        // 动态记录字母出现次数
        int[] freq_s = new int[26];
        // 滑动窗口：s[l...r]
        int l = 0, r = -1;
        while (r + 1 < s.length()) {
            r++;
            freq_s[s.charAt(r) - 'a']++;
            if (r - l + 1 > p.length()) {
                freq_s[s.charAt(l++) - 'a']--;
            }

            if (r - l + 1 == p.length() && same(freq_s, freq_p)) {
                res.add(l);
            }
        }

        return res;
    }

    private boolean same(int[] freq_s, int[] freq_p) {
        for (int i = 0; i < 26; i++) {
            if (freq_s[i] != freq_p[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "cbaebabacd";
        String p1 = "abc";
        System.out.println(new Solution1().findAnagrams(s1, p1));

        String s2 = "abab";
        String p2 = "ab";
        System.out.println(new Solution1().findAnagrams(s2, p2));
    }
}
