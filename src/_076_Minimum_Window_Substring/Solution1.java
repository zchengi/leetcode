package _076_Minimum_Window_Substring;

import java.util.HashMap;

/**
 * LeetCode 076. Minimum Window Substring
 * <p>
 * 滑动窗口
 *
 * @author cheng
 *         2018/3/12 20:14
 */
public class Solution1 {
    public String minWindow(String s, String t) {

        if (t.isEmpty()) return "";

        // map 中记录 t 的所有字母在 s 中出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, 0);
        }
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else return "";
        }

        // counter 记录 t 中的所有字母个数
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            char c1 = s.charAt(end);
            // 如果当前字母存在于 t 中，则 counter--
            if (map.get(c1) > 0) {
                counter--;
            }
            // 更新 map 中 c1 的出现次数，如果 t 不包含当前字母，则该字母的 value 值为 -1
            map.put(c1, map.get(c1) - 1);

            end++;

            // 当 counter 为 0，则表示当前 s[end,start] 中出现了 t
            while (counter == 0) {
                // 判断与 minLen 的大小，如果更小则更新值
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }

                // 将 start 向后移动一位
                char c2 = s.charAt(start);
                map.put(c2, map.get(c2) + 1);

                // 判断 t 中是否包含 c2 ，如包含则 counter++
                if (map.get(c2) > 0) {
                    counter++;
                }

                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new Solution1().minWindow(s, t));
    }
}
