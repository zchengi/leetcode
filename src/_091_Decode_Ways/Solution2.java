package _091_Decode_Ways;

/**
 * LeetCode 091. Decode Ways
 *
 * @author cheng
 *         2018/12/12 17:30
 */
public class Solution2 {
    public int numDecodings(String s) {

        int n = s.length();
        if (n == 0) {
            return 0;
        }

        // dp[i]：表示对第i个字符（包括i）的可能解码方式，其字符串中的索引是 i-1
        int[] dp = new int[n + 1];
        // 基数
        dp[0] = 1;
        // 当有一个字符时，如果它不为零，则只能是1个解码方式。如果为0，则不会有解码方式。
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        // 这里只需要在i之前查看最多两位数字，因为最大有效代码是26，它有两位数。
        for (int i = 2; i <= n; i++) {
            // 对于dp[i]：为了避免索引超出边界，提取（i-1, i）的子串 - 这是第i个char（String中的索引是 i-1）和子串（i-2, i）
            int one = Integer.parseInt(s.substring(i - 1, i));
            int two = Integer.parseInt(s.substring(i - 2, i));

            // 检查子串（i-1，i）是否为 0
            if (one != 0) {
                dp[i] += dp[i - 1];
            }

            // 检查子串（i-2, i）是否落在 10~26 之间
            if (two >= 10 && two <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "12";
        System.out.println(new Solution2().numDecodings(s));
        s = "226";
        System.out.println(new Solution2().numDecodings(s));
    }
}
