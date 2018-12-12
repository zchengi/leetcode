package _091_Decode_Ways;

/**
 * LeetCode 091. Decode Ways
 *
 * @author cheng
 *         2018/12/12 17:30
 */
public class Solution1 {
    public int numDecodings(String s) {

        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int memo[] = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];
            }
        }

        return memo[0];
    }

    public static void main(String[] args) {
        String s = "12";
        System.out.println(new Solution1().numDecodings(s));
        s = "226";
        System.out.println(new Solution1().numDecodings(s));
    }
}
