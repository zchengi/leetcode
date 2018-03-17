package _242_Valid_Anagram;

import java.util.HashMap;
import java.util.Objects;

/**
 * LeetCode 242. Valid Anagram
 * <p>
 * 使用两个 map
 *
 * @author cheng
 *         2018/3/17 16:56
 */
public class Solution2 {
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        for (char c : arr1) {
            if (map1.containsKey(c)) {
                map1.put(c, map1.get(c) + 1);
            } else {
                map1.put(c, 1);
            }
        }
        for (char c : arr2) {
            if (map2.containsKey(c)) {
                map2.put(c, map2.get(c) + 1);
            } else {
                map2.put(c, 1);
            }
        }

        for (char c : map1.keySet()) {
            if (!Objects.equals(map1.get(c), map2.get(c))) {
                return false;
            }
        }

        for (char c : map2.keySet()) {
            if (!Objects.equals(map1.get(c), map2.get(c))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";
        System.out.println(new Solution2().isAnagram(s, t));
    }
}
