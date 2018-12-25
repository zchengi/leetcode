package _139_Word_Break;

import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 139. Word Break
 * <p>
 * 动态规划
 *
 * @author cheng
 *         2018/12/25 11:45
 */
public class Solution2 {

    /**
     * hi 从 1 开始判断 wordDict 中是包含 s[lo, hi)
     * <p>
     * dp[lo] 表示 wordDict 中是否有对应的字符串 s[0, lo)
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        // hi 从 1 开始
        for (int hi = 1; hi <= s.length(); hi++) {
            // lo 从 0 开始，不能超过 hi
            for (int lo = 0; lo < hi; lo++) {
                if (dp[lo] && wordDict.contains(s.substring(lo, hi))) {
                    // [0, hi) 是否能在 wordDict 找到对应的字符串
                    dp[hi] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {

        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(new Solution2().wordBreak(s, wordDict));

        s = "applepenapple";
        wordDict = Arrays.asList("apple", "pen");
        System.out.println(new Solution2().wordBreak(s, wordDict));

        s = "catsandog";
        wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(new Solution2().wordBreak(s, wordDict));
    }
}
