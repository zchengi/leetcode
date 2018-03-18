package _015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 015. 3Sum
 * <p>
 * 相同的思路，另一种方法，效率更高，速度更快
 *
 * @author cheng
 *         2018/3/18 19:49
 */
public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] <= 0 && (i == 0 || (i > 0 && nums[i] != nums[i - 1]))) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] > -nums[i]) {
                        right--;
                    } else if (nums[left] + nums[right] < -nums[i]) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution2().threeSum(nums));
    }
}
