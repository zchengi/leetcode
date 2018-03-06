package _088_Merge_Sorted_Array;

import java.util.Arrays;

/**
 * Leet Code 088. Merge Sorted Array
 * <p>
 * 归并排序的归并操作
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n), n为nums1的数组大小
 *
 * @author cheng
 *         2018/3/6 20:18
 */
public class Solution1 {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int[] tempNUms = new int[m];
        System.arraycopy(nums1, 0, tempNUms, 0, m);

        int i = 0;
        int j = 0;
        for (int k = 0; k < m + n; ) {
            if (i == m) {
                nums1[k++] = nums2[j++];
            } else if (j == n) {
                nums1[k++] = tempNUms[i++];
            } else if (tempNUms[i] <= nums2[j]) {
                nums1[k++] = tempNUms[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }

        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        int m = 3;
        int n = 3;

        System.out.println(Arrays.toString(new Solution1().merge(nums1, n, nums2, n)));
    }
}
