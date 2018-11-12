package _402_Remove_K_Digits;

/**
 * LeetCode 402. Remove K Digits
 *
 * @author cheng
 *         2018/11/12 10:51
 */
public class Solution1 {
    /**
     * 删除整数的 k 个数字，获得删除后的最小值
     *
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {

        String newNum = num;
        for (int i = 0; i < k; i++) {
            boolean hasCut = false;

            // 从左到右遍历，找到比自己右侧数字大的数字并删除
            for (int j = 0; j < newNum.length() - 1; j++) {
                if (newNum.charAt(j) > newNum.charAt(j + 1)) {
                    newNum = newNum.substring(0, j) + newNum.substring(j + 1, newNum.length());

                    hasCut = true;
                    break;
                }
            }

            // 如果没有找到要删除的数字，则删除最后一个数字
            if (!hasCut) {
                newNum = newNum.substring(0, newNum.length() - 1);
            }

            // 清除整数左侧的数字 0
            newNum = removeZero(newNum);
        }

        // 如果整数的所有数字都被删除了，直接返回 0
        if (newNum.length() == 0) {
            return "0";
        }

        return newNum;
    }

    private String removeZero(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(0) != '0') {
                break;
            }
            num = num.substring(1, num.length());
        }

        return num;
    }

    public static void main(String[] args) {

        String num = "1432219";
        int k = 3;
        System.out.println(new Solution1().removeKdigits(num, k));
    }
}
