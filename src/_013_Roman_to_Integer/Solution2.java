package _013_Roman_to_Integer;

/**
 * LeetCode 013. Roman to Integer
 *
 * @author cheng
 *         2018/08/31 17:25
 */
public class Solution2 {
    public int romanToInt(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] hash = new int[26];

        hash['I' - 'A'] = 1;
        hash['V' - 'A'] = 5;
        hash['X' - 'A'] = 10;
        hash['L' - 'A'] = 50;
        hash['C' - 'A'] = 100;
        hash['D' - 'A'] = 500;
        hash['M' - 'A'] = 1000;

        int roman = 0;
        int prev = Integer.MIN_VALUE;

        // M:1000  C:-100  M:1000  X:-10  C:100  I:-1  V:5
        // 1000 - 100 + 1000 - 10 + 100 - 1 + 5 = 1994

        for (int i = s.length() - 1; i >= 0; i--) {
            int dig = hash[s.charAt(i) - 'A'];

            if (dig < prev) {
                roman -= dig;
            } else {
                roman += dig;
            }
            prev = dig;
        }

        return roman;
    }

    public static void main(String[] args) {

        String s = "MCMXCIV";
        System.out.println(new Solution2().romanToInt(s));

    }
}
