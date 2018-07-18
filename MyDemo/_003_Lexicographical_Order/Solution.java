package _003_Lexicographical_Order;

import java.util.Arrays;

/**
 * 字典序算法
 * 找出最近的一个大于自身的相同数字组成的整数
 *
 * @author cheng
 *         2018/4/16 13:09
 */
public class Solution {
    public int[] findNearestNumber(int[] numbers) {

        // 拷贝参数，避免直接修改
        int[] numberCopy = Arrays.copyOf(numbers, numbers.length);

        // 1. 从后向前查看逆序区域，找到逆序区域的第一位的索引值，也就是数字置换的边界
        int index = findTransferPoint(numberCopy);

        // 如果数字置换边界是0，说明整个数组已经是逆序，无法得到更大的相同数字组成的数组，返回空
        if (index == 0) {
            return null;
        }

        // 2. 把逆序区域前一位和逆序区域中大于它的最小值交换位置
        int[] exchangeHeadNumbers = exchangeHead(numberCopy, index);

        // 3. 把原来的逆序数组转换为顺序的
        return reverse(exchangeHeadNumbers, index);
    }

    private int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    private int[] exchangeHead(int[] numbers, int index) {

        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[index - 1] < numbers[i]) {
                int temp = numbers[index - 1];
                numbers[index - 1] = numbers[i];
                numbers[i] = temp;
                break;
            }
        }

        return numbers;
    }

    private int[] reverse(int[] numbers, int index) {
        for (int i = index, j = numbers.length - 1; i < j; i++, j--) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }

        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < 10; i++) {
            numbers = new Solution().findNearestNumber(numbers);
            System.out.println(Arrays.toString(numbers));
        }
    }
}
