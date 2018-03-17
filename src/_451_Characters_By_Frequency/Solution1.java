package _451_Characters_By_Frequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 451. Characters By Frequency
 * <p>
 * 时间复杂度：O(n)
 * LeetCode 运行需要 34 ms
 *
 * @author cheng
 *         2018/3/17 18:49
 */
public class Solution1 {
    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.putIfAbsent(c, 1);
            }
        }

        // 使用一个 list[] 数组，将 map 中的 value 作为 key，map 的 key 作为 value
        // 这样 bucket[i] 中的 i 就是 每个字母出现的次数，而 bucket[i] 的值为该出现次数对应的字母
        // 这样就可以字母按照出现从大到小依次输出了
        List<Character>[] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            // 这里可以产生出现次数相同的两个字母
            bucket[frequency].add(key);
        }

        StringBuilder builder = new StringBuilder();
        // 按照字母出现的次数从大到小输出
        for (int pos = bucket.length - 1; pos >= 0; pos--) {
            // 如果 bucket[pos] 不为空，则证明 bucket[pos] 出现过
            if (bucket[pos] != null) {
                // 找到出现次数为 pos 对应的所有 key，这里可能有两个字母出现次数相同，所以要用 for 循环
                for (char key : bucket[pos]) {
                    // 按照其出现次数 pos 依次添加到 builder 中
                    for (int i = 0; i < pos; i++) {
                        builder.append(key);
                    }
                }
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {

        String s = "Aabb";
        System.out.println(new Solution1().frequencySort(s));

        s = "cccaaa";
        System.out.println(new Solution1().frequencySort(s));
    }
}
