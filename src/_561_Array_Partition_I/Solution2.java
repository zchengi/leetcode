package _561_Array_Partition_I;

/**
 * LeetCode 561. Array Partition I
 *
 * @author cheng
 *         2019/1/13 10:27
 */
public class Solution2 {
    public int arrayPairSum(int[] nums) {

        int[] exist = new int[20001];
        for (int num : nums) {
            exist[num + 10000]++;
        }

        int sum = 0;

        boolean odd = true;

        for (int i = 0; i < exist.length; i++) {
            while (exist[i] > 0) {
                if (odd) {
                    sum += i - 10000;
                }
                odd = !odd;
                exist[i]--;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] nums = {1, 4, 3, 2};
        System.out.println(new Solution2().arrayPairSum(nums));
    }
}