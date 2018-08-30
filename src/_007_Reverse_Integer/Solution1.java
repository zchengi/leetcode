package _007_Reverse_Integer;

/**
 * LeetCode 007 Reverse Integer
 *
 * @author cheng
 *         2018/08/30 10:39
 */
public class Solution1 {
    public int reverse(int x) {

        int res = 0;

        while (x != 0) {
            int tail = x % 10;

            int newRes = res * 10 + tail;
            if ((newRes - tail) / 10 != res) {
                return 0;
            }

            res = newRes;
            x /= 10;
        }

        return res;
    }

    public static void main(String[] args) {

        int x = -213;
        System.out.println(new Solution1().reverse(x));
    }
}
