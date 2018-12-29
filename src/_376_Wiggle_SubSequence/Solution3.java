package _376_Wiggle_SubSequence;

/**
 * LeetCode 376. Wiggle SubSequence
 *
 * @author cheng
 *         2018/12/29 18:58
 */
public class Solution3 {
    public int wiggleMaxLength(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        // 最少有一个
        int result = 1;
        //  记录 nums[i-2] - nums[i-1] 的值
        int preDiff = 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];

            // nums[i] 与 nums[i-1] 为升 nums[i-1] 与 nums[i-2] 为降或相等 或者
            // nums[i] 与 nums[i-1] 为降 nums[i-1] 与 nums[i-2] 为升或相等
            // 隐含判断: nums[i] 不等于 num[i-1]
            if ((diff > 0 && preDiff <= 0) || (diff < 0 && preDiff >= 0)) {

                preDiff = diff;
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 7, 4, 9, 2, 5};
        System.out.println(new Solution3().wiggleMaxLength(nums));

        nums = new int[]{1, 7, 4, 5, 5};
        System.out.println(new Solution3().wiggleMaxLength(nums));
    }
}
