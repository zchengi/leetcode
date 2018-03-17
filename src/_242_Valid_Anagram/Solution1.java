package _242_Valid_Anagram;

import java.util.HashMap;

/**
 * LeetCode 242. Valid Anagram
 * <p>
 * 使用一个 map
 *
 * @author cheng
 *         2018/3/17 16:45
 */
public class Solution1 {
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        for (char c : arr1) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : arr2) {
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }

        for (char c : map.keySet()) {
            if (map.get(c) > 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "ab";
        String t = "b";
        System.out.println(new Solution1().isAnagram(s, t));
    }
}
