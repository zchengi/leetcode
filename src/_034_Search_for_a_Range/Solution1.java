package _034_Search_for_a_Range;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * LeetCode 34. Search for a Range
 * <p>
 * https://leetcode.com/problems/search-for-a-range/description/
 *
 * @author cheng
 *         2018/2/27 23:15
 */
public class Solution1 {
    public int[] searchRange(int[] nums, int target) {

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                list.add(i);
            }
        }

        if (list.size() == 0) {
            return new int[]{-1, -1};
        }

        int[] position = new int[2];
        position[0] = list.get(0);
        position[1] = list.get(list.size() - 1);

        return position;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(new Solution1().searchRange(arr, 8)));
    }
}
