package _344_Reverse_String;

/**
 * LeetCode 344. Reverse String
 * <p>
 * 使用两个字节数组反转
 *
 * @author cheng
 *         2018/3/8 20:21
 */
public class Solution3 {
    public String reverseString(String s) {

        char[] charArray = s.toCharArray();
        char[] reverseCharArray = new char[s.length()];

        for (int i = 0; i < charArray.length; i++) {
            reverseCharArray[reverseCharArray.length - i - 1] = charArray[i];
        }

        return new String(reverseCharArray);
    }

    public static void main(String[] args) {

        String str = "hello";
        System.out.println(new Solution3().reverseString(str));
    }
}
