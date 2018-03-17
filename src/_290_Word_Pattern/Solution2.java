package _290_Word_Pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 290. Word Pattern
 * <p>
 * 利用 map 的 add() 、 containKey() 和 containValue() 方法
 *
 * @author cheng
 *         2018/3/17 18:16
 */
public class Solution2 {
    public boolean wordPattern(String pattern, String str) {

        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            // 如果 map 的 key 中没有包含当前 pattern.charAt(i)
            if (!map.containsKey(pattern.charAt(i))) {
                // 如果 map 的 value 中包含当前 words[i]
                if (map.containsValue(words[i])) {
                    // 这里说明 value = words[i] 出现过（说明它有对应的 key），但是 key = pattern.charAt(i) 没有出现，即不匹配
                    return false;
                } else {
                    // 这里证明 value = words[i] 和 key = pattern.charAt(i) 都没有出现过，将它们加入 map 中
                    map.put(pattern.charAt(i), words[i]);
                }
            } else {
                // 这里说明 map 的 key 中包含过 pattern.charAt(i)

                // 只需要判断 当前 key 所对应的 value 是否与 words[i] 相等
                // 相等：证明匹配
                // 不相等：证明不匹配
                if (!map.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(new Solution2().wordPattern(pattern, str));
    }
}
