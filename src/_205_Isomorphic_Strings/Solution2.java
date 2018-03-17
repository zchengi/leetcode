package _205_Isomorphic_Strings;

/**
 * LeetCode 205. Isomorphic Strings
 * <p>
 * 使用两个 int[] 实现
 *
 * @author cheng
 *         2018/3/17 18:40
 */
public class Solution2 {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] ss = new int[256];
        int[] tt = new int[256];
        // 判断第 i项 在 s 和 t 中的出现次数是否相同，如果不相同，证明不匹配
        // 如果相同，更新它们的出现位置，从 1 开始索引
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i), ct = t.charAt(i);
            if (ss[cs] != tt[ct]) {
                return false;
            }

            // 当前出现位置为 i + 1
            ss[cs] = i + 1;
            tt[ct] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "egg";
        String t = "add";
        System.out.println(new Solution2().isIsomorphic(s, t));

        s = "foo";
        t = "bar";
        System.out.println(new Solution2().isIsomorphic(s, t));
    }
}
