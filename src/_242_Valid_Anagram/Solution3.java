package _242_Valid_Anagram;

/**
 * LeetCode 242. Valid Anagram
 * <p>
 * 使用int数组直接判断
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * @author cheng
 *         2018/3/17 16:56
 */
public class Solution3 {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];
        // 将字符串 s 的每个字符出现的次数添加到 freq 中
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // 当字符串 t 中字符出现一次时，将 freq[c-'a']--
        // 也就是说如果 freq[c-'a'] < 0 的话说明不是 Anagram
        for (char c : t.toCharArray()) {
            if (--freq[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        // 'a'=97,'b'=98,'c'=99,d='100'
        // 一共二十六个字母，所以可以使用一个大小为26的 int 数组表示26个字母
        System.out.println('b' - 'a');
        System.out.println('c' - 'a');
        System.out.println('d' - 'a');
        String s = "anagram";
        String t = "nagaram";
        System.out.println(new Solution3().isAnagram(s, t));
    }
}
