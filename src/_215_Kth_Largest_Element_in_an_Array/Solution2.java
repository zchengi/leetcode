package _215_Kth_Largest_Element_in_an_Array;

/**
 * LeetCode 215. Kth Largest Element in an Array
 * <p>
 * 利用快速排序的 pattern方法查询
 * 优化：使用双路快排
 *
 * @author cheng
 *         2018/3/6 20:48
 */
public class Solution2 {
    public int findKthLargest(int[] nums, int k) {

        if (nums == null || nums.length < k || k < 1) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int lo, int hi, int k) {

        if (lo == hi) return nums[lo];

        int p = nums[lo + (hi - lo) / 2];
        int i = lo;
        int j = hi;
        while (i <= j) {
            while (i <= j && nums[i] < p) {
                i++;
            }

            while (i <= j && nums[j] > p) {
                j--;
            }

            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }

        // 判断 索引 k 位置的值是否已被排序
        if (k <= j) {
            return quickSelect(nums, lo, j, k);
        } else if (k >= i) {
            return quickSelect(nums, i, hi, k);
        }

        return nums[k];
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,0};
        int k = 2;

        System.out.println(new Solution2().findKthLargest(nums, k));
    }
}
