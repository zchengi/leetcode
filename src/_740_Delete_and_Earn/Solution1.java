package _740_Delete_and_Earn;

/**
 * LeetCode 740. Delete and Earn
 *
 * @author cheng
 *         2018/12/18 11:48
 */
public class Solution1 {

    public int deleteAndEarn(int[] nums) {

        int[] sum = new int[10002];

        // 遍历 nums 数组，从小到大排列所有值
        // i 在 nums 数组中出现的总和
        for (int num : nums) {
            sum[num] += num;
        }

        // sum[i] 的值只有两种情况:
        // 1. 获取当前节点，最大值为 当前节点 + sum[i - 2]
        // 2. 放弃当前节点，获取 sum[i - 1]
        for (int i = 2; i < sum.length; i++) {
            sum[i] = Math.max(sum[i - 1], sum[i] + sum[i - 2]);
        }

        return sum[10001];
    }


    public static void main(String[] args) {

        int[] nums = {3, 4, 2};
        System.out.println(new Solution1().deleteAndEarn(nums));
    }
}
