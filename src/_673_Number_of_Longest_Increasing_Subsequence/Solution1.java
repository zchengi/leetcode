package _673_Number_of_Longest_Increasing_Subsequence;

/**
 * LeetCode 673. Number of Longest Increasing SubSequence
 *
 * @author cheng
 *         2018/12/30 22:12
 */
public class Solution1 {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;
        int res = 0;
        int maxLength = 0;

        // 以 nums[i] 结束的最长递增子序列的长度
        int len[] = new int[n];
        // 以 nums[i] 结尾的最长递增子序列的个数
        int count[] = new int[n];

        for (int i = 0; i < n; i++) {
            len[i] = count[i] = 1;

            // 计算以 num[i] 结尾的最长递增子序列的长度&个数
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1) {
                        count[i] += count[j];
                    }

                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                }
            }

            if (maxLength == len[i]) {
                res += count[i];
            }

            if (maxLength < len[i]) {
                maxLength = len[i];
                res = count[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(new Solution1().findNumberOfLIS(nums));

        nums = new int[]{2, 2, 2, 2, 2};
        System.out.println(new Solution1().findNumberOfLIS(nums));
    }
}
