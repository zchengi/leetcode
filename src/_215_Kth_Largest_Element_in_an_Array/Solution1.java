package _215_Kth_Largest_Element_in_an_Array;

/**
 * LeetCode 215. Kth Largest Element in an Array
 * <p>
 * 利用快速排序的 pattern方法查询
 * 单路快排
 *
 * @author cheng
 *         2018/3/6 20:48
 */
public class Solution1 {
    public int findKthLargest(int[] nums, int k) {

        if (nums == null || nums.length < k || k < 1) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int lo, int hi, int k) {

        if (lo == hi) return nums[lo];

        int p = partition(nums, lo, hi);
        if (k == p) return nums[p];
        else if (k > p) return quickSelect(nums, p + 1, hi, k);
        else return quickSelect(nums, lo, p - 1, k);

    }

    private int partition(int[] nums, int lo, int hi) {

        int v = nums[lo];

        int j = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (nums[i] < v) {
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, lo, j);

        return j;
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        System.out.println(new Solution1().findKthLargest(nums, k));
    }
}
