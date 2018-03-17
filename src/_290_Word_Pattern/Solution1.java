package _290_Word_Pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * LeetCode 290. Word Pattern
 * <p>
 * 利用 map 的 put() 方法的返回值判断
 * map.put() 方法返回当前 key 的旧值，第一次 put() 返回 null，例
 * <p>
 * 第一次： map.put(1,1) 返回 null
 * 第二次： map.put(1,2) 返回 1   （第一次添加的值 1）
 * 第三次： map.put(1,3) 返回 2   （第二次添加的值 2）
 *
 * @author cheng
 *         2018/3/17 17:45
 */
public class Solution1 {
    public boolean wordPattern(String pattern, String str) {

        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        Map map = new HashMap();
        for (int i = 0; i < pattern.length(); i++) {
            // 这里是关键
            // 使用 map put() 方法的特性
            // 添加 pattern 和 str 的第 i 项，并且设置其值为 i
            // 如果 当前添加的第 i 项，两者 put() 方法返回值不同，则证明不匹配
            if (!Objects.equals(map.put(words[i], i), map.put(pattern.charAt(i), i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map.put(2, 2));
        System.out.println(map.put(2, 3));
        System.out.println(map.put(2, 4));

        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(new Solution1().wordPattern(pattern, str));
    }
}
