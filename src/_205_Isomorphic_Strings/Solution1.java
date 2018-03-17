package _205_Isomorphic_Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 205. Isomorphic Strings
 * <p>
 * 使用一个 map 实现
 * 参考 LeetCode 290 题
 *
 * @author cheng
 *         2018/3/17 18:29
 */
public class Solution1 {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<Character, Character>();

        // 判断第 i 项 的 s 和 t 的值在 map 中对应的 key value 是否相同，如果不相同，证明不匹配
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                } else {
                    map.put(s.charAt(i), t.charAt(i));
                }
            } else {
                if (!map.get(s.charAt(i)).equals(t.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "egg";
        String t = "add";
        System.out.println(new Solution1().isIsomorphic(s, t));

        s = "foo";
        t = "bar";
        System.out.println(new Solution1().isIsomorphic(s, t));
    }
}
