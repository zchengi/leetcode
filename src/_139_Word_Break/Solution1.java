package _139_Word_Break;

import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 139. Word Break
 * <p>
 * 记忆化搜索
 *
 * @author cheng
 *         2018/12/25 11:05
 */
public class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0, new Boolean[s.length()]);
    }

    /**
     * 用 wordDict 的每一个单词遍历，看是不是存在于 s 中，
     * - 如果存在，则把记录 s 的开始位置 lo 变为这个单词的长度，然后再用 wordDict 中的单词遍历，寻找是否存在 lo 之后元素
     * - 如果不存在，则找下一个单词，全部不存在返回 false
     * - 当s中的每一个字符都能在 wordDict 中找到对应的单词时，即 lo = s.length，返回 true
     */
    private boolean dfs(String s, List<String> wordDict, int lo, Boolean[] memo) {

        if (lo == s.length()) {
            return true;
        }

        if (memo[lo] != null) {
            return memo[lo];
        }

        memo[lo] = false;
        for (String word : wordDict) {
            int hi = lo + word.length();

            if (hi > s.length()) {
                continue;
            }

            if (s.substring(lo, hi).equals(word)) {
                if (dfs(s, wordDict, hi, memo)) {
                    memo[lo] = true;
                    break;
                }
            }
        }

        return memo[lo];
    }

    public static void main(String[] args) {

        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(new Solution1().wordBreak(s, wordDict));

        s = "applepenapple";
        wordDict = Arrays.asList("apple", "pen");
        System.out.println(new Solution1().wordBreak(s, wordDict));

        s = "catsandog";
        wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(new Solution1().wordBreak(s, wordDict));
    }
}
