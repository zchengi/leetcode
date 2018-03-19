package _697_Degree_of_an_Array;


/**
 * LeetCode 697. Degree of an Array
 * <p>
 * 与 Solution1 思路相同，但是进行了优化，使用数组替代 map 存储 left right counts
 * 性能比 Solution 更好
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * @author cheng
 *         2018/3/19 21:02
 */
public class Solution2 {
    public int findShortestSubArray(int[] nums) {

        if (nums.length == 0 || nums == null) return 0;

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] left = new int[max + 1];
        int[] right = new int[max + 1];
        int[] counts = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            if (counts[nums[i]] == 0) {
                left[nums[i]] = i;
                right[nums[i]] = i;
            } else {
                right[nums[i]] = i;
            }

            counts[nums[i]]++;
        }

        int max_count = 0;
        for (int count : counts) {
            max_count = Math.max(max_count, count);
        }

        int min = nums.length;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == max_count) {
                min = Math.min(min, right[i] - left[i] + 1);
            }
        }

        return min;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 3, 1};
        System.out.println(new Solution2().findShortestSubArray(nums));
    }
}
