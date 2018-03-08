package _344_Reverse_String;

/**
 * LeetCode 344. Reverse String
 * <p>
 * 使用StringBuilder拼接
 *
 * @author cheng
 *         2018/3/8 20:04
 */
public class Solution1 {
    public String reverseString(String s) {

        StringBuilder builder = new StringBuilder();

        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {

            if (start == end) {
                builder.insert(start, s.charAt(start));
                break;
            }

            builder.insert(start, s.charAt(start));
            builder.insert(start, s.charAt(end));

            start++;
            end--;
        }

        return builder.toString();
    }

    public static void main(String[] args) {

        String str = "hello";

        // 可以直接用 StringBuilder的内置函数完成
        System.out.println(new StringBuilder(str).reverse().toString());
        System.out.println(new Solution1().reverseString(str));
    }
}
