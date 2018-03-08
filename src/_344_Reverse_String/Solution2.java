package _344_Reverse_String;

/**
 * LeetCode 344. Reverse String
 * <p>
 * 使用一个字节数组反转
 *
 * @author cheng
 *         2018/3/8 20:17
 */
public class Solution2 {
    public String reverseString(String s) {

        char[] charArray = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        return new String(charArray);
    }

    public static void main(String[] args) {

        String str = "hello";
        System.out.println(new Solution2().reverseString(str));
    }
}
