package _345_Reverse_Vowels_of_a_String;

/**
 * LeetCode 345. Reverse Vowels of a String
 * <p>
 * 使用一个字符数组
 *
 * @author cheng
 *         2018/3/8 20:25
 */
public class Solution1 {
    public String reverseVowels(String s) {

        String vowels = "aeiouAEIOU";
        char[] charArray = s.toCharArray();

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (start < end && vowels.indexOf(charArray[start]) == -1) {
                start++;
            }
            while (start < end && vowels.indexOf(charArray[end]) == -1) {
                end--;
            }

            if (start < end) {
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
            }

            start++;
            end--;
        }

        return new String(charArray);
    }

    public static void main(String[] args) {

        String str = "hello.,";
        System.out.println(new Solution1().reverseVowels(str));
    }
}
