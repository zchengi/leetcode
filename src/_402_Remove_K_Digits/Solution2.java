package _402_Remove_K_Digits;

/**
 * LeetCode 402. Remove K Digits
 *
 * @author cheng
 *         2018/11/12 11:10
 */
public class Solution2 {

    /**
     * 删除整数的 k 个数字，获得删除后的最小值
     *
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {

        // 新整数的最终长度 = 原整数长度 - k
        int newLength = num.length() - k;
        // 创建一个栈，用于接收所有的数字
        char[] stack = new char[num.length()];
        int top = 0;

        for (int i = 0; i < num.length(); i++) {

            char c = num.charAt(i);
            while (top > 0 && stack[top - 1] > c && k > 0) {
                top--;
                k--;
            }

            stack[top++] = c;
        }

        int offset = 0;
        while (offset < newLength && stack[offset] == '0') {
            offset++;
        }

        return offset == newLength ? "0" : new String(stack, offset, newLength - offset);
    }

    public static void main(String[] args) {

        String num = "1432219";
        int k = 3;
        System.out.println(new Solution2().removeKdigits(num, k));
    }
}
