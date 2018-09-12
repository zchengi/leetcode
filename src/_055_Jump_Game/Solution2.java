package _055_Jump_Game;

/**
 * LeetCode 055. Jump Game
 *
 * @author cheng
 *         2018/09/12 15:46
 */
public class Solution2 {
    public boolean canJump(int[] nums) {

        if (nums.length == 0) {
            return true;
        }

        if (nums.length == 1) {
            return true;
        }

        int ed = nums.length - 1;
        int st = nums.length - 2;
        while (st >= 0) {
            if (nums[st] >= ed - st) {
                ed = st;
            }
            st--;
        }

        return ed == 0;
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(new Solution2().canJump(nums));

        nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(new Solution2().canJump(nums));
    }
}
