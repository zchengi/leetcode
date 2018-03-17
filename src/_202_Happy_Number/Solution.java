package _202_Happy_Number;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 202. Happy Number
 * <p>
 * 在java中，Set的add()方法的返回值为boolean，
 * 当添加一个元素 a 返回 true，当再尝试添加 a 的时候会返回 false。
 *
 * @author cheng
 *         2018/3/17 17:13
 */
public class Solution {
    public boolean isHappy(int n) {

        Set<Integer> inLoop = new HashSet<>();
        int squareSum;

        // 第一次添加 n 为 true，再添加 n 为 false
        while (inLoop.add(n)) {
            squareSum = 0;
            // 对 n 依次从最高位取值
            while (n > 0) {
                squareSum += (n % 10) * (n % 10);
                n /= 10;
            }

            if (squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        // 第一次添加 a true
        System.out.println(set.add("a"));
        // 第二次添加 a false
        System.out.println(set.add("a"));
        // 删除 a true
        System.out.println(set.remove("a"));
        // 第一次添加 a true
        System.out.println(set.add("a"));
        // 第二次添加 a false
        System.out.println(set.add("a"));
        System.out.println();

        int n = 19;
        System.out.println(new Solution().isHappy(n));
        n = 2;
        System.out.println(new Solution().isHappy(n));
    }
}
