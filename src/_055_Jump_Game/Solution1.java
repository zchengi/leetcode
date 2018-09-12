package _055_Jump_Game;

/**
 * LeetCode 055. Jump Game
 * <p>
 * 贪心解法：求出最大的能跳的步数，判断是否大于数组大小
 *
 * @author cheng
 *         2018/09/12 15:17
 */
public class Solution1 {
    public boolean canJump(int[] nums) {

        int reach = 0;
        int i = 0;
        while (i < nums.length && i <= reach) {
            reach = Math.max(reach, i + nums[i]);
            i++;
        }

        return reach >= nums.length - 1;
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(new Solution1().canJump(nums));

        nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(new Solution1().canJump(nums));
    }
}
