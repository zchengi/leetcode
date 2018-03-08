package _345_Reverse_Vowels_of_a_String;

/**
 * LeetCode 345. Reverse Vowels of a String
 * <p>
 * 使用一个布尔数组
 *
 * @author cheng
 *         2018/3/8 20:45
 */
public class Solution2 {
    public String reverseVowels(String s) {

        boolean[] marked = new boolean[256];

        marked['u'] = true;
        marked['e'] = true;
        marked['o'] = true;
        marked['a'] = true;
        marked['i'] = true;
        marked['U'] = true;
        marked['E'] = true;
        marked['O'] = true;
        marked['A'] = true;
        marked['I'] = true;

        char[] charArray = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; i++) {
            if (marked[charArray[i]]) {
                for (; j > i; j--) {
                    if (marked[charArray[j]]) {
                        char temp = charArray[i];
                        charArray[i] = charArray[j];
                        charArray[j--] = temp;

                        break;
                    }
                }
            }
        }

        return new String(charArray);
    }

    public static void main(String[] args) {

        String str = "hello.,";
        System.out.println(new Solution2().reverseVowels(str));
    }
}
