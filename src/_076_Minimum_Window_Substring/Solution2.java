package _076_Minimum_Window_Substring;

/**
 * LeetCode 076. Minimum Window Substring
 * <p>
 * 滑动窗口
 * 优化：用一个int数组代替map
 *
 * @author cheng
 *         2018/3/12 20:30
 */
public class Solution2 {
    public String minWindow(String s, String t) {

        if (t.isEmpty()) return "";

        int negCnt = 0;
        // 记录 每个字母出现的次数 t中出现一次 -1 ， s中出现一次 +1，
        int[] cnts = new int[128];
        for (char c : t.toCharArray()) {
            if (cnts[c]-- == 0) {
                negCnt++;
            }
        }

        char[] cs = s.toCharArray();
        int minS = 0, minE = Integer.MAX_VALUE;
        for (int start = 0, end = 0; end < cs.length; ) {

            // 如果当前字母存在于 t 中，则negCnt--
            if (++cnts[cs[end++]] == 0) {
                negCnt--;
            }

            // 如果 t 中的所有字母已经全部出现过
            if (negCnt == 0) {
                // 首字母
                char c = cs[start];
                // 右移滑动窗口的 start
                while (cnts[c] > 0) {
                    cnts[c]--;
                    c = cs[++start];
                }

                // 更新索引值
                if (minE - minS > end - start) {
                    minS = start;
                    minE = end;
                }
            }
        }

        return minE == Integer.MAX_VALUE ? "" : s.substring(minS, minE);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new Solution2().minWindow(s, t));
    }
}
