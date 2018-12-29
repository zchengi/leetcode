package _376_Wiggle_SubSequence;

/**
 * LeetCode 376. Wiggle SubSequence
 *
 * @author cheng
 *         2018/12/29 18:36
 */
public class Solution2 {
    public int wiggleMaxLength(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int k = 0;
        while (k < nums.length - 1 && nums[k] == nums[k + 1]) {
            k++;
        }

        if (k == nums.length - 1) {
            return 1;
        }

        int result = 2;
        boolean smallReq = nums[k] < nums[k + 1];
        for (int i = k + 1; i < nums.length - 1; i++) {
            if (smallReq && nums[i + 1] < nums[i]) {
                nums[result] = nums[i + 1];
                result++;

                smallReq = !smallReq;
            } else {
                if (!smallReq && nums[i + 1] > nums[i]) {
                    nums[result] = nums[i + 1];
                    result++;

                    smallReq = !smallReq;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 7, 4, 9, 2, 5};
        System.out.println(new Solution2().wiggleMaxLength(nums));

        nums = new int[]{1, 7, 4, 5, 5};
        System.out.println(new Solution2().wiggleMaxLength(nums));
    }
}
