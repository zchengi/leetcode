package _088_Merge_Sorted_Array;

import java.util.Arrays;

/**
 * Leet Code 088. Merge Sorted Array
 * <p>
 * 归并排序的归并操作
 * 优化：从大到小归并，不使用额外的空间
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/3/6 20:37
 */
public class Solution2 {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int last = m + n - 1;
        int first = m - 1;
        int second = n - 1;

        while (first >= 0 && second >= 0) {
            if (nums1[first] > nums2[second]) {
                nums1[last] = nums1[first--];
            } else {
                nums1[last] = nums2[second--];
            }
            last--;
        }

        // 当 nums1 的元素用完， nums2 中还有元素，剩余的这些元素只可能是最小的部分
        if (first < 0) {
            for (int i = 0; i <= last; i++) {
                nums1[i] = nums2[i];
            }
        }

        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        int m = 3;
        int n = 3;

        System.out.println(Arrays.toString(new Solution2().merge(nums1, n, nums2, n)));
    }
}
