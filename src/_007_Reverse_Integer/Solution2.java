package _007_Reverse_Integer;

/**
 * LeetCode 007 Reverse Integer
 *
 * @author cheng
 *         2018/08/30 11:03
 */
public class Solution2 {
    public int reverse(int x) {

        long res = 0;
        for (int temp = x; temp != 0; temp /= 10) {
            res = res * 10 + temp % 10;
        }

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }

        return (int)res;
    }

    public static void main(String[] args) {

        int x = -213;
        System.out.println(new Solution2().reverse(x));
    }
}
