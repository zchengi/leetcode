package _013_Roman_to_Integer;

/**
 * LeetCode 013. Roman to Integer
 *
 * @author cheng
 *         2018/08/31 16:45
 */
public class Solution1 {
    public int romanToInt(String s) {

        int sum = 0;

        // 计算所有可以组合的值之和
        if (s.contains("IV") || s.contains("IX")) {
            sum -= 2;
        }
        if (s.contains("XL") || s.contains("XC")) {
            sum -= 20;
        }
        if (s.contains("CD") || s.contains("CM")) {
            sum -= 200;
        }

        for (char c : s.toCharArray()) {
            switch (c) {
                case 'I':
                    sum += 1;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    sum += 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    sum += 100;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
                default:
                    throw new IllegalArgumentException("输入参数有误");
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        String s = "MCMXCIV";
        System.out.println(new Solution1().romanToInt(s));
    }
}
