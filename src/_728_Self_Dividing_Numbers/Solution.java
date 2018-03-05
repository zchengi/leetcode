package _728_Self_Dividing_Numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 728. Self Dividing Numbers
 * <p>
 * https://leetcode.com/problems/self-dividing-numbers/description/
 *
 * @author cheng
 *         2018/2/3 11:03
 */
public class Solution {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();

        /*for (int i = left; i <= right; i++) {
            if (!String.valueOf(i).matches("^[1-9]+")) continue;
            int j = i;
            int divisor = 10;
            while (j > 0) {
                j = i % divisor / (divisor / 10);
                if (j == 0) {
                    list.add(i);
                    break;
                } else if (i % j == 0) {
                    divisor *= 10;
                } else {
                    break;
                }
            }
        }*/

        // 时间复杂度为： ~O(nm)， n = right - left, m是迭代数字的位数（12为2位，123为3位）

        // 内层for循环分析，如果 i = 128:
        // 1. 赋值 j = i，判断 j 的个位是否为 0，再判断 i 除以它的某一位 j 是否为0;
        // 2. 下一步删除8： j = 128 / 10 = 12;
        // 3. 重复1和2的步骤;
        // 4. 循环结束，如果 j 的值为 0，则证明当前 i 是自分数；

        for (int i = left; i <= right; i++) {
            int j = i;
            for (; j > 0; j /= 10) {
                if ((j % 10 == 0) || (i % (j % 10) != 0)) break;
            }
            if (j == 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 1000));
        System.out.println(selfDividingNumbers(1, 24));
    }
}
