package _049_Group_Anagrams;

import java.util.*;

/**
 * LeetCode 049. Group Anagrams
 * <p>
 * 解法分析： https://leetcode.com/problems/group-anagrams/solution/
 *
 * @author cheng
 *         2018/3/19 20:04
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> res = new HashMap<>();

        for (String str : strs) {
            // 取出当前字符串的所有字符
            char[] cs = str.toCharArray();
            // 将字符排序
            Arrays.sort(cs);
            // 用排序后的字符数组生成新字符串 key
            String key = String.valueOf(cs);

            // 如果 res 中不包含键 key，则添加新键值对
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList<>());
            }

            // 如果包含，更新其值
            res.get(key).add(str);
        }

        return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Solution().groupAnagrams(strs));
    }
}
