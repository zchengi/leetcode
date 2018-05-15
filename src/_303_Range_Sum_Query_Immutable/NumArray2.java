package _303_Range_Sum_Query_Immutable;


/**
 * LeetCode 303. Range Sum Query - Immutable
 *
 * @author cheng
 *         2018/5/15 13:51
 */
public class NumArray2 {

    /**
     * sum[i] 存储前 i 个元素的和
     * sum[i] 存储 nums[0...i-1] 的和
     * sum(i, j) = sum[j + 1] - sum[i]
     */
    private int[] sum;

    public NumArray2(int[] nums) {

        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray2 numArray = new NumArray2(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}
