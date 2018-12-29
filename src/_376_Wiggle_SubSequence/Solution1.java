package _376_Wiggle_SubSequence;

/**
 * LeetCode 376. Wiggle SubSequence
 *
 * @author cheng
 *         2018/12/29 18:26
 */
public class Solution1 {
    public int wiggleMaxLength(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        // 记录 num[i] > nums[i-1] 的最大长度
        up[0] = 1;
        // 记录 num[i] < nums[i-1] 的最大长度
        down[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }

        return Math.max(up[nums.length - 1], down[nums.length - 1]);
    }

    public static void main(String[] args) {

        int[] nums = {1, 7, 4, 9, 2, 5};
        System.out.println(new Solution1().wiggleMaxLength(nums));

        nums = new int[]{1, 7, 4, 5, 5};
        System.out.println(new Solution1().wiggleMaxLength(nums));
    }
}
